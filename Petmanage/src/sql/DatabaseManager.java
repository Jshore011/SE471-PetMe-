package sql;

import PetManager2.Pet;
import PetManager2.PetLogType;
import PetManager.*;

import utils.Constants;
import utils.DateUtils;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
public class DatabaseManager {
    private Connection connection;
    private String authenticatedUser;

    /**
     * Creates a database manager and connects to the database.
     */
    public DatabaseManager() {
        try {

            // load configuration file containing database creds
            Properties prop = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
//            InputStream stream = loader.getResourceAsStream("config.properties");
//            prop.load(stream);
//            String host = prop.getProperty("localhost:3306");
//            String dbname = prop.getProperty("pet_manager");
//            String user = prop.getProperty("root");
//            String pass = prop.getProperty("");


            // load mysql driver library for sql operations
            Class.forName("com.mysql.jdbc.Driver");

//            this.connection = DriverManager.getConnection("jdbc:mysql://"+host+"/"+dbname, user, pass);
            //this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_manager", "root", "P@$$w0rd");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_manager", "root", "");
            this.createTables();
        }
        catch (SQLException e) {
            System.out.println("Error connecting: " + e);
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public boolean deleteUser(UserProfile profile) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.DELETE_USER_PETS);
        stmt.setString(1, profile.email);
        boolean success = stmt.execute();

        stmt = this.connection.prepareStatement(Constants.DELETE_USER_PROFILE);
        stmt.setString(1, profile.email);
        boolean success2 = stmt.execute();

        stmt = this.connection.prepareStatement(Constants.DELETE_USER_LOGS);
        stmt.setString(1, profile.email);
        boolean success3 = stmt.execute();

        stmt.close();
        return success && success2 && success3;
    }

    /**
     * Returns the user authenticated
     * @return authenticated user
     */
    public String getUser() {
        return this.authenticatedUser;
    }

    /**
     * Registers a user as authenticated
     * @param username username to authenticate
     */
    public void registerAuthenticated(String username) {
        this.authenticatedUser = username;
    }

    /**
     * Retrieves the salt for a given user
     * @param username user to retrieve salt from
     * @return salt
     * @throws SQLException exception on failed fetch
     */
    public String getSaltForUser(String username) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.GET_SALT);
        stmt.setString(1, username);

        ResultSet results = stmt.executeQuery();
        if (!results.next()) {
            return null;
        }

        String salt = results.getString(1);
        stmt.close();
        return salt;
    }

    /**
     * Gets the password hash for the given user
     * @param username user to fetch hash for
     * @return password hash
     * @throws SQLException sql exception on failed db query
     */
    public String getHashForUser(String username) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.GET_HASH);
        stmt.setString(1, username);

        ResultSet results = stmt.executeQuery();
        if (!results.next()) {
            return null;
        }

        String hash = results.getString(1);
        stmt.close();
        return hash;
    }

    /**
     * Creates a new user and inserts it into the database
     * @param email username
     * @param name user's name
     * @param hash hash to store
     * @param salt accompanying salt for the given hash
     * @throws SQLException throws on failed insertion
     */
    public void createUser(String email, String name, String hash, String salt) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.INSERT_NEW_USER);
        stmt.setString(1, email);
        stmt.setString(2, name);
        stmt.setString(3, hash);
        stmt.setString(4, salt);

        stmt.executeUpdate();
        stmt.close();
    }

    /**
     * Gets user profile data, only to be used on authenticated users.
     * @param username User to grab data for
     * @return UserProfile object representing their user information
     * @throws SQLException throws on failed fetch
     */
    public UserProfile getUserData(String username) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.GET_PROFILE);
        stmt.setString(1, username);

        ResultSet results = stmt.executeQuery();
        if (!results.next()) {
            return null;
        }

        UserProfile profile = new UserProfile();
        profile.name = results.getString(1);
        profile.icon = results.getString(2);
        profile.phone = results.getString(3);
        profile.lightmode = results.getInt(4) == 1;
        profile.email = username;

        stmt.close();
        return profile;
    }


    /**
     * Updates the user profile when they change a setting
     * @param user User profile to update
     * @throws SQLException throws exception on failed update
     */
    public void insertUserData(UserProfile user) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.UPDATE_USER_PROFILE);
        stmt.setString(1, user.name);
        stmt.setString(2, user.phone);
        stmt.setString(3, user.icon);
        stmt.setInt(4, user.lightmode ? 1 : 0);
        stmt.setString(5, user.email);

        stmt.executeUpdate();
        stmt.close();
    }

    /**
     * Initializes database tables if they don't already exist. Runs on every start
     * @return true on success
     * @throws SQLException throws on table creation failure
     */
    private boolean createTables() throws SQLException {
        Statement stmt = this.connection.createStatement();
        boolean success = stmt.execute(Constants.CREATE_TABLE);
        boolean success2 = stmt.execute(Constants.CREATE_PETS_TABLE);
        boolean success3 = stmt.execute(Constants.CREATE_LOGS_TABLE);
        stmt.close();
        return success && success2 && success3;
    }

    /**
     * Retrieves all of the pet logs for the given pet_id. Pet_id corresponds to Pet.id
     * @param pet_id Internal database id to lookup the pet
     * @return PetLogData
     * @throws SQLException throws if pet logs were unable to be fetched
     */
    public PetLogData getPetLogs(int pet_id) throws SQLException {
        PetLog diet = new PetLog(PetLogType.Diet, new ArrayList<>());
        PetLog medicine = new PetLog(PetLogType.Medicine, new ArrayList<>());
        PetLog poop = new PetLog(PetLogType.Exercise, new ArrayList<>());

        // prep query & dispatch
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.GET_PET_LOGS);
        stmt.setInt(1, pet_id);
        ResultSet results = stmt.executeQuery();

        // for every single pet log entry in the database
        while (results.next()) {
            // java-ize mysql data
            LocalDateTime date = DateUtils.epochMilliToDate(results.getLong(1));
            String text = results.getString(2);
            PetLogType type = PetLogType.fromString(results.getString(3));
            // store based on type
            switch (type) {
                case Diet:
                    diet.addEntry(new LogEntry(date, text));
                    break;
                case Medicine:
                    medicine.addEntry(new LogEntry(date, text));
                    break;
                case Exercise:
                    poop.addEntry(new LogEntry(date, text));
                    break;
            }
        }
        // free our mem and ret
        stmt.close();
        results.close();
        return new PetLogData(diet, poop, medicine);
    }

    /**
     * Updates information about a pet in the database
     * @param pet Pet data to be updated
     * @throws SQLException throws exception on failed update
     */
    public void updatePet(Pet pet) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.UPDATE_PET_PROFILE);
        stmt.setString(1, pet.name);
        stmt.setInt(2, pet.tracking_id);
        stmt.setString(3, pet.owner);
        stmt.setLong(4, DateUtils.dateToEpochMilli(pet.petBirthday));
        stmt.setString(5, pet.breed);
        stmt.setString(6, pet.gender);
        stmt.setString(7, pet.city);
        stmt.setString(8, pet.type);
        stmt.setString(9, pet.icon);
        stmt.setInt(10, pet.id);

        stmt.executeUpdate();
        stmt.close();
    }

    /**
     * Inserts a new pet into the database
     * @param pet pet to insert, pet_id is assigned after insertion
     * @throws SQLException throws exception on failed insertion
     */
    public void insertPet(Pet pet) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.INSERT_PET);
        stmt.setString(1, pet.name);
        stmt.setInt(2, pet.tracking_id);
        stmt.setString(3, pet.owner);
        stmt.setLong(4, DateUtils.dateToEpochMilli(pet.petBirthday));
        stmt.setString(5, pet.breed);
        stmt.setString(6, pet.gender);
        stmt.setString(7, pet.city);
        stmt.setString(8, pet.type);
        stmt.setString(9, pet.icon);
        stmt.execute();

        ResultSet results = stmt.executeQuery("SELECT LAST_INSERT_ID();");
        if (results.next()) {
            int id = results.getInt(1);
            pet.id = id;
        }
        results.close();
        stmt.close();
    }

    /**
     * Retrieves all of the pets for the given user
     * @param username user to fetch pets for
     * @return A list of all of the user's pets
     * @throws SQLException throws sql exception on failed retrieval
     */
    public ArrayList<Pet> getPets(String username) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.GET_PETS);
        stmt.setString(1, username);

        ArrayList<Pet> pets = new ArrayList<>();
        ResultSet results = stmt.executeQuery();
        while (results.next()) {
            Pet p = new Pet();
            p.id = results.getInt(1);
            p.name = results.getString(2);
            p.tracking_id = results.getInt(3);
            p.owner = results.getString(4);
            p.petBirthday = DateUtils.epochMilliToDate(results.getLong(5));
            p.breed = results.getString(6);
            p.gender = results.getString(7);
            p.city = results.getString(8);
            p.type = results.getString(9);
            p.icon = results.getString(10);

            PetLogData data = this.getPetLogs(p.id);
            p.diet = data.diet;
            p.medicine = data.medicine;
            p.exercise = data.exercise;

            pets.add(p);
        }
        results.close();
        stmt.close();
        return pets;
    }

    /**
     * Removes a pet from the database and all of it's pet data. Irreversible.
     * @param pet pet to delete
     * @throws SQLException exception on failed deletion
     */
    public void deletePet(Pet pet) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.DELETE_PET);
        stmt.setInt(1, pet.id);
        stmt.executeUpdate();
        stmt.close();

        stmt = this.connection.prepareStatement(Constants.DELETE_PET_LOGS);
        stmt.setInt(1, pet.id);
        stmt.executeUpdate();
        stmt.close();
    }

    /**
     * Inserts a new pet log for a given pet
     * @param pet pet to insert log for
     * @param logType log type
     * @param entry Log entry to insert
     * @throws SQLException throws on failed insertion
     */
    public void insertPetLog(Pet pet, PetLogType logType, LogEntry entry) throws SQLException {
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.INSERT_PET_LOG);


        stmt.setString(1, pet.owner);
        stmt.setLong(2, DateUtils.dateToEpochMilli(entry.date));
        stmt.setString(3, entry.text);
        stmt.setString(4, logType.toString());
        stmt.setInt(5, pet.id);

        stmt.executeUpdate();
        stmt.close();
    }
    
     /**
     * Gets pet services data.
     * @param type  to grab data for
     * @return pet services
     * @throws SQLException throws on failed fetch
     */
    public Map<String, Integer> getPetServiceNamesByType(String type) throws SQLException {
                
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.GET_PET_SERVICE_NAMES);
        stmt.setString(1, type);

        ResultSet results = stmt.executeQuery();
        
        Map<String, Integer> serviceNameMap = new HashMap<String, Integer>();
        
        while(results.next())
        {
            serviceNameMap.put(results.getString(2), results.getInt(1));
        }

        stmt.close();
        return serviceNameMap;
    }
    
     /**
     * Gets pet service address.
     * @param id to grab data for
     * @return PetService
     * @throws SQLException throws on failed fetch
     */
    public PetService getPetServiceDetailsById(int id) throws SQLException {
                
        java.sql.PreparedStatement stmt = this.connection.prepareStatement(Constants.GET_PET_SERVICE_ADDRESS);
        stmt.setInt(1, id);

        ResultSet results = stmt.executeQuery();
        
        PetService petService = new PetService();
               
        while(results.next())
        {
            petService.setId(id);
            petService.setName(results.getString(1));
            petService.setAddress(results.getString(2));
            petService.setPhoneNumber(results.getString(3));
        }

        stmt.close();
        return petService;
    }
}
