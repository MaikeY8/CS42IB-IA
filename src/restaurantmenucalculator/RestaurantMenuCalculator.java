
/** Required package class namespace */
package restaurantmenucalculator;

/** Required imports */
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import data.DataStructures;
import userinterfaces.LoginUI;

/**
 * RestaurantMenuCalculator - the main class for this application
 * 
 * @author Wen Pei (Michael) Yan
 * @since Feb, 2023
 */
public class RestaurantMenuCalculator {

    /**
     * The main method of the application that instantiates the DataStructures
     * class and instantiates the login UI
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instantiates the DataStructures class
        new DataStructures();
        // Try catch for an Exception error
        try {
            // Sets the colour palette for all JFrames (UI)
            FlatArcOrangeIJTheme.setup();
        } catch (Exception e) {
        }
        /* Creates and displays the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Instantiates the Login UI
                new LoginUI();
            }
        });
    }
    
}
