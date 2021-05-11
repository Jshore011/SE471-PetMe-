package utils;

/**
 * A list of all of our constants that interact with MySQL.
 */
public class Constants {
    // New table creation (ignored if tables already exist)
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            "`profile_data` ( " +
                "`id` int(20) NOT NULL AUTO_INCREMENT, " +
                "`name` varchar(32), " +
                "`email` varchar(32) NOT NULL UNIQUE, " +
                "`icon` varchar(512), " +
                "`phone` varchar(32), " +
                "`lightmode` int(20), " +
                "`salt` varchar(32) NOT NULL, " +
                "`hash` varchar(256) NOT NULL, " +
                "PRIMARY KEY (`id`)" +
            ") " +
            "DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1";
    public static final String CREATE_PETS_TABLE = "CREATE TABLE IF NOT EXISTS " +
            "`pet_data` ( " +
                "`id` int(20) NOT NULL AUTO_INCREMENT, " +
                "`name` varchar(32), " +
                "`tracking_id` int(20), " +
                "`owner` varchar(32) NOT NULL, " +
                "`age` BigInt, " +
                "`breed` varchar(32), " +
                "`gender` varchar(32), " +
                "`city` varchar(32), " +
                "`type` varchar(32), " +
                "`icon` varchar(512), " +
                "PRIMARY KEY (`id`)" +
            ") " +
            "DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1";
    public static final String CREATE_LOGS_TABLE = "CREATE TABLE IF NOT EXISTS " +
            "`pet_logs` ( " +
                "`id` int(20) NOT NULL AUTO_INCREMENT, " +
                "`pet_id` int(20) NOT NULL, " +
                "`owner` varchar(32) NOT NULL, " +
                "`date` BigInt NOT NULL, " +
                "`text` MEDIUMTEXT, " +
                "`type` varchar(32) NOT NULL," +
                "PRIMARY KEY (`id`)" +
            ") " +
            "DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1";

    // Profile deletion
    public static final String DELETE_USER_PETS = "DELETE FROM `pet_data` WHERE owner = ?;";
    public static final String DELETE_USER_LOGS = "DELETE FROM `pet_logs` WHERE owner = ?;";
    public static final String DELETE_USER_PROFILE = "DELETE FROM `profile_data` WHERE email = ?;";

    // Data deletion
    public static final String DELETE_PET_LOGS = "DELETE FROM `pet_logs` WHERE pet_id = ?;";
    public static final String DELETE_PET = "DELETE FROM `pet_data` WHERE id = ?;";

    // Login
    public static final String GET_SALT = "SELECT `salt` FROM `profile_data` where `email` = ?";
    public static final String GET_HASH = "SELECT `hash` FROM `profile_data` where `email` = ?";

    // Data fetching
    public static final String GET_PROFILE = "SELECT name,icon,phone,lightmode FROM `profile_data` where `email` = ?";
    public static final String GET_PETS = "SELECT id,name,tracking_id,owner,age,breed,gender,city,type,icon FROM `pet_data` WHERE owner = ?;";
    public static final String GET_PET_LOGS = "SELECT date,text,type FROM `pet_logs` WHERE pet_id = ? ORDER BY date ASC;";

    // Information updates
    public static final String UPDATE_USER_PROFILE = "UPDATE `profile_data` SET name=?,phone=?, icon=?, lightmode=? WHERE email = ?";
    public static final String UPDATE_PET_PROFILE = "UPDATE `pet_data` SET name=?,tracking_id=?,owner=?,age=?,breed=?,gender=?,city=?,type=?,icon=? WHERE id=?";

    // New data
    public static final String INSERT_NEW_USER = "INSERT INTO `profile_data` (email, name, hash, salt, lightmode) VALUES(?, ?, ?, ?, 1)";
    public static final String INSERT_PET = "INSERT INTO `pet_data` (name, tracking_id, owner, age, breed, gender, city, type, icon) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String INSERT_PET_LOG = "INSERT INTO `pet_logs` (owner, date, text, type, pet_id) VALUES(?, ?, ?, ?, ?)";
    
    //Pet services
    public static final String GET_PET_SERVICE_NAMES = "SELECT id, servicename FROM `pet_services` where `type` = ?";
    public static final String GET_PET_SERVICE_ADDRESS = "SELECT servicename, address, phonenumber FROM `pet_services` where `id` = ?";
    
}


