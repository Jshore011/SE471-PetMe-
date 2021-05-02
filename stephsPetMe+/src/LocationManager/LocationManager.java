/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocationManager;

import PetManager.PetService;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.DatabaseManager;


public class LocationManager {
    String API_Key = "AIzaSyDIwkqxovZzUtbmj-ZKvEyO6LvUxDmvJMg";
    String URL = "https://maps.googleapis.com/maps/api/staticmap?center=40.714%2c%20-73.998&zoom=12&size=400x400&key=AIzaSyDIwkqxovZzUtbmj-ZKvEyO6LvUxDmvJMg";
    private static LocationManager object = null;
    private DatabaseManager databaseManager = new DatabaseManager();
    
    private LocationManager() {
    }

    public static LocationManager newInstanace() {
        if (object == null) {

            synchronized (LocationManager.class) {
                if (object == null) {
                    object = new LocationManager();//It's lazy loading of Location Manager. Object will only be created once you call this method.
                }
            }
        }
        return object;
    }
   
    public Map<String, Integer> getNearPalcesByType(String type) {
        try {
            return databaseManager.getPetServiceNamesByType(type);
        } catch (SQLException ex) {
            Logger.getLogger(LocationManager.class.getName()).log(Level.SEVERE, "Unable to get pet services.", ex);
        }
        return null;
    }

    public PetService getPetServiceDetailsById(int id) {
        try {
            return databaseManager.getPetServiceDetailsById(id);
        } catch (SQLException ex) {
            Logger.getLogger(LocationManager.class.getName()).log(Level.SEVERE, "Unable to get pet service details.", ex);
        }
        return null;

    }
}
