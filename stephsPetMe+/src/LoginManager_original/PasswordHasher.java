package LoginManager_original;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Utility that handles all password hashing
 */
public class PasswordHasher {
    public String email;
    public String password;
    public String salt;
    public String hash;

    /**
     * Constructs a new PasswordHasher
     * @param email User's email
     * @param password password to hash
     * @param salt Salt retrieved by DatabaseManager
     */
    public PasswordHasher(String email, String password, String salt) {
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.hash = null;
    }

    /**
     * Creates a fully null password hasher
     */
    public PasswordHasher() {
        this.email = null;
        this.password = null;
        this.salt = null;
        this.hash = null;
    }

    /**
     * Calculates the hash for the given password. Password and salt must be supplied.
     * @return
     */
    public String getHash() {
        if (hash == null)
            return BCrypt.hashpw(password, salt).replace(salt, "");
        else
            return hash;
    }

    /**
     * Generates a new salt for a user
     */
    public void generateSalt() {
        this.salt = BCrypt.gensalt(12);
    }
}