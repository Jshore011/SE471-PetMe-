package PetManager;

import sql.DatabaseManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Internal pet manager that holds all pets
 */
public class PetManager {
    public ArrayList<Pet> pets;

    /**
     * Creates a PetMananger and retrieves pets from DatabaseMananger
     * @param sql DatabaseMananger to fetch pets from
     * @throws SQLException
     */
    public PetManager(DatabaseManager sql) throws SQLException {
        this.pets = sql.getPets(sql.getUser());
    }
}
