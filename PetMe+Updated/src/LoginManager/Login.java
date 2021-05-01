package LoginManager;

import org.mindrot.jbcrypt.BCrypt;
import sql.DatabaseManager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;

public class Login {
    public String email;
    public String password;
    public String salt;
    public String hash;

    /**
     * constructor
     * @param email user's email
     * @param password user's password
     */
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Creates a fully null Login creds
     */
    public Login() {
        this.email = null;
        this.password = null;
        this.salt = null;
        this.hash = null;
    }



    public void loadCreds()
    {
        File creds = new File("data");
        try (FileReader fr = new FileReader(creds)) {
            char[] chars = new char[(int) creds.length()];
            fr.read(chars);

            String[] fileContent = new String(chars).split("\\n");
            this.hash = fileContent[1].trim();
            this.email = fileContent[0].trim();
        } catch (Exception e) {
            // silence - exceptions here are normal if not remember me
        }
    }

    public void saveCreds()
    {
        try {
            File creds = new File("data");
            FileWriter w = new FileWriter(creds, false);
            w.write(email + '\n' + getHash());
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean loginManager(DatabaseManager man) throws SQLException
    {
        String sqlhash = man.getHashForUser(this.email);

        String hash = this.hash;
        if (hash == null) {
            hash = getHash();
        }

        if (sqlhash.equals(hash)) {
            man.registerAuthenticated(this.email);
            return true;
        }
        else {
            return false;
        }


    }

    public String getHash()
    {
        if (hash == null)
            return BCrypt.hashpw(password, salt).replace(salt, "");
        else
            return hash; //need to fix add bcrypt.JAR file
    }

    public void generateSalt()
    {
        this.salt = BCrypt.gensalt(12); //bCrypt.JAR
    }
}
