package ui;

import LoginManager.LoginManager;
import PetManager.Pet;
import PetManager.PetManager;
import sql.DatabaseManager;
import ProfileManager.UserProfile;

import javax.swing.*;
import java.io.File;
import ProfileManager.UserProfileBuilder;

// Here's the entry point & setup for the main  UI
public class Main {
    public static JFrame loginWindow = null;
    public static JFrame registrationWindow = null;
    public static JFrame petWindow = null;
    public static JFrame userProfileWindow = null;
    public static JFrame dietPopUpWindow = null;
    public static JFrame exercisePopUpWindow = null;
    public static JFrame medicationPopUpWindow = null;
    public static JFrame addPetWindow = null;
    public static JFrame dashboardWindow = null;
    public static JFrame petServicesWindow = null;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        }
            catch (Exception ex) {
            ex.printStackTrace();
        }

        // try to log in on saved creds
        try {
            File creds = new File("data");
            if (creds.exists()) {
                DatabaseManager sql = new DatabaseManager();
                LoginManager loginManager = new LoginManager();
                boolean res = loginManager.loginUser(sql);
                if (res) {
                    Main.openDashboardWindow(sql);
                    return;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        openLoginWindow(null);
    }

    public static void updateAllWindowsLookAndFeel() {
        if (Main.dashboardWindow != null)
            SwingUtilities.updateComponentTreeUI(Main.dashboardWindow);
        if (Main.userProfileWindow != null)
            SwingUtilities.updateComponentTreeUI(Main.userProfileWindow);
        if (Main.exercisePopUpWindow != null)
            SwingUtilities.updateComponentTreeUI(Main.exercisePopUpWindow);
        if (Main.dietPopUpWindow != null)
            SwingUtilities.updateComponentTreeUI(Main.dietPopUpWindow);
        if (Main.medicationPopUpWindow != null)
            SwingUtilities.updateComponentTreeUI(Main.medicationPopUpWindow);
        if (Main.petWindow != null)
            SwingUtilities.updateComponentTreeUI(Main.petWindow);
        if (Main.petServicesWindow != null)
            SwingUtilities.updateComponentTreeUI(Main.petServicesWindow);
    }

    public static void openRegistrationWindow(DatabaseManager sql) {
        registrationWindow = RegistrationWindow.spawn(sql);
    }

    public static void openLoginWindow(DatabaseManager sql) {
        loginWindow = LoginWindow.spawn(sql);
    }

    public static void openPetWindow(DatabaseManager sql, Pet p) {
        petWindow = PetWindow.spawn(sql, p);
    }

    public static void openUserProfileWindow(DatabaseManager sql, UserProfile user, DashboardWindow dash) {
        userProfileWindow = UserProfileWindow.spawn(sql, user, dash);
    }

    public static void openDashboardWindow(DatabaseManager sql) {
        dashboardWindow = DashboardWindow.spawn(sql);
    }

    public static void openDietPopUpWindow(DatabaseManager sql, Pet pet) {
        dietPopUpWindow = DietPopUpWindow.spawn(sql, pet);
    }

    public static void openExercisePopUpWindow(DatabaseManager sql, Pet pet) {
        exercisePopUpWindow = ExercisePopUpWindow.spawn(sql, pet);
    }

    public static void openMedicationPopUpWindow(DatabaseManager sql, Pet pet) {
        medicationPopUpWindow = MedicationPopUpWindow.spawn(sql, pet);
    }

    public static void openAddPetWindow(DatabaseManager sql, DashboardWindow dash, PetManager pm) {
        addPetWindow = AddPetWindow.spawn(sql, dash, pm);
    }
    
    public static void openLocatePetServicesWindow(DatabaseManager sql, DashboardWindow dash, PetManager pm) {
        petServicesWindow = PetServicesWindow.spawn(sql, dash, pm);
    }
}
