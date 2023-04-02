
/** Required package class namespace */
package controllers;

/** Required imports */
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
 * @author mikex
 */
public class MenuController {

    // Private/encapsulated property of this class
    private MenuUI menuUI;

    /**
     * A constructor method which sets the class property. Done by connecting 
     * the passed in parameter to the encapsulated property (global variable
     * of this class).
     * @param menuUI 
     */
    public MenuController(MenuUI menuUI) {
        this.menuUI = menuUI;
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
