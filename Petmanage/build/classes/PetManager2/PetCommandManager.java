package PetManager2;

import PetManager2.Pet;
import sql.DatabaseManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Internal pet manager that holds all pets
 */
public class PetCommandManager {
    public ArrayList<Pet> pets;

    /**
     * Creates a PetMananger and retrieves pets from DatabaseMananger
     * @param sql DatabaseMananger to fetch pets from
     * @throws SQLException
     */
    public PetCommandManager(DatabaseManager sql) throws SQLException {
        this.pets = sql.getPets(sql.getUser());
    }
}
