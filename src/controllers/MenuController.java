
/** Required package class namespace */
package controllers;

/** Required imports */
import data.DataStructures;
import userinterfaces.LoginUI;
import userinterfaces.MenuUI;
import userinterfaces.OrderUI;
import userinterfaces.ReceiptUI;

/**
 * MenuController.java - this class is connected to the menu user interface for
 * accessing and using the main user interfaces of this program. This controller
 * class stores all the methods and code to be run that is associated with the 
 * menu UI. This controller class connects to the view the user has of the menu
 * user interface
 * 
 * @author Wen Pei (Michael) Yan
 * @since Feb, 2023
 */
public class MenuController {

    // Private/encapsulated property of this class
    private MenuUI menuUI;

    /**
     * A constructor method which sets the properties of the UI and sets the 
     * menuUI class property. Done by connecting the passed in parameters to the 
     * encapsulated properties (global variables of this class).
     * 
     * @param menuUI the menu user interface
     */
    public MenuController(MenuUI menuUI) {
        this.menuUI = menuUI;
        // Sets the title of the frame
        menuUI.setTitle(DataStructures.TITLE);
        // Sets the icon image of the frame
        menuUI.setIconImage(DataStructures.iconImage);
        // Sets the size of the frame
        menuUI.setSize(267, 260);
        // Sets the location to show up in the middle
        menuUI.setLocationRelativeTo(null);
        // Sets the frame to be visible
        menuUI.setVisible(true);
        // Sets the frame resizable property to false
        menuUI.setResizable(false);
    }
    
    /**
     * Instantiates the order user interface and closes the menu UI
     */
    public void order() {
        new OrderUI();
        closing();
    }
    
    /**
     * Instantiates the receipt user interface and closes the menu UI
     */
    public void receipt() {
        new ReceiptUI();
        closing();
    }
    
    /**
     * Instantiates the login user interface and closes the menu UI
     */
    public void logout() {
        new LoginUI();
        closing();
    }
    
    /**
     * Closes the menu user interface
     */
    public void closing() {
        menuUI.dispose();
    }
}
