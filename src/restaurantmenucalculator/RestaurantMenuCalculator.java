
/** Required package class namespace */
package restaurantmenucalculator;

/** Required imports */
import data.DataStructures;
import userinterfaces.LoginUI;

/**
 * RestaurantMenuCalculator - the main class for this application
 * 
 * @author mikex
 */
public class RestaurantMenuCalculator {

    /**
     * The main method of the application that instantiates the DataStructures
     * class and instantiates the login UI
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new DataStructures();
        new LoginUI();
    }
    
}
