/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginManager;

import java.sql.SQLException;
import sql.DatabaseManager;

/**
 *
 * @author Owner
 */
public interface LoginIF {
    public boolean loginUser(DatabaseManager man);
    
}
