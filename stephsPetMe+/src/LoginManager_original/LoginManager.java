package LoginManager_original;

import sql.DatabaseManager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;

/**
 * A Login Manager that handles all login functions
 */
public class LoginManager {
    public PasswordHasher hasher;


    /**
     * Creates a login mananger
     * @param email user's email
     * @param password user's password
     * @param salt the user's salt
     */
    public LoginManager(String email, String password, String salt) {
        this.hasher = new PasswordHasher(email, password, salt);
    }

    /**
     * Creates a login mananger from a pre-cached credential file
     */
    public LoginManager() {
        this.hasher = new PasswordHasher();
        this.loadCreds();
    }

    /**
     * Loads the credentials from the credential file, called if remember me was previously selected
     */
    public void loadCreds() {
        File creds = new File("data");
        try (FileReader fr = new FileReader(creds)) {
            char[] chars = new char[(int) creds.length()];
            fr.read(chars);

            String[] fileContent = new String(chars).split("\\n");
            this.hasher.hash = fileContent[1].trim();
            this.hasher.email = fileContent[0].trim();
        } catch (Exception e) {
            // silence - exceptions here are normal if not remember me
        }
    }

    /**
     * Saves the credentials to the credential file
     */
    public void saveCreds() {
        try {
            File creds = new File("data");
            FileWriter w = new FileWriter(creds, false);
            w.write(hasher.email + '\n' + hasher.getHash());
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Logs in a user and validates the hash
     * @param man Database mananger to request hash from
     * @return true if user is validated
     * @throws SQLException exception on unsuccessful hash fetch
     */
    public boolean loginUser(DatabaseManager man) throws SQLException {
        String sqlhash = man.getHashForUser(this.hasher.email);

        String hash = this.hasher.hash;
        if (hash == null) {
            hash = this.hasher.getHash();
        }

        if (sqlhash.equals(hash)) {
            man.registerAuthenticated(this.hasher.email);
            return true;
        }
        else {
            return false;
        }
    }
}
