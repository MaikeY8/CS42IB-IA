
/** Required package class namespace */
package controllers;

/** Required imports */
import data.DataStructures;
import javax.swing.JTextField;
import userinterfaces.LoginUI;
import userinterfaces.MenuUI;

/**
 * LoginController.java - this class is connected to the login user interface
 * for logging in and stores all the methods and code to be run that is
 * associated with the login UI. This controller class connects to the view the
 * user has of the login user interface
 * 
 * @author Wen Pei (Michael) Yan
 * @since Feb, 2023
 */
public class LoginController {

    // Private/encapsulated class properties
    private LoginUI loginUI;
    private JTextField nameTextbox;
    private JTextField passwordTextbox;
    
    /**
     * A constructor method which sets the properties of the UI and sets class 
     * properties. Done by connecting the passed in parameters to the 
     * encapsulated properties (global variables of this class).
     * 
     * @param loginUI the user interface for the user to login with
     * @param nameTextbox the text box field for the user's name
     * @param passwordTextbox the text box field for the password
     */
    public LoginController(
            LoginUI    loginUI,
            JTextField nameTextbox,
            JTextField passwordTextbox) {
        this.loginUI         = loginUI;
        this.nameTextbox     = nameTextbox;
        this.passwordTextbox = passwordTextbox;
        // Sets the title of the frame
        loginUI.setTitle(DataStructures.TITLE);
        // Sets the icon image of the frame
        loginUI.setIconImage(DataStructures.iconImage);
        // Sets the size of the frame
        loginUI.setSize(207, 250);
        // Sets the location to show up in the middle
        loginUI.setLocationRelativeTo(null);
        // Sets the frame to be visible
        loginUI.setVisible(true);
        // Sets the frame resizable property to false
        loginUI.setResizable(false);
    }

    /**
     * The user clicks the login button and it checks if all required fields are
     * filled in. If all fields are not filled in then it will prompt the user
     * to fill in the required field(s) by outputting a dialog box. If all the
     * fields are filled then the login user interface will close, the user's
     * name will be stored and the menu user interface will be opened
     *
     * @param userName the inputted name from the user
     * @param userPassword the inputted password from the user
     */
    public void login(String userName, String userPassword) {
        // Checks if the user's name field has been filled
        if (userName == null
                || userName.equals("")) {
            // Prompts the user to enter their name
            DataStructures.dialogs.output("Please enter your name!");
            nameTextbox.requestFocus();
            return;         // Exits the method early
        }
        // Checks if the password field has been filled
        if (userPassword == null
                || userPassword.equals("")) {
            // Prompts the user to enter the password
            DataStructures.dialogs.output("Please enter the password!");
            passwordTextbox.requestFocus();
            return;         // Exits the method early
        }
        // Checks if the password sent by the user is equal to the real password
        if (userPassword.equals(DataStructures.PASSWORD)) {
            // Calls menu method
            menu();
            // Calls closing method
            closing();
            // Saves cashier name
            DataStructures.cashierName = userName;
        } else {
            // Outputs a message saying the password is incorrect
            DataStructures.dialogs.output("Incorrect password!");
            // Prompts the user to re-enter the password
            passwordTextbox.setText("");
            passwordTextbox.requestFocus();
        }
    }

    /**
     * Instantiates the menu user interface
     */
    private void menu() {
        new MenuUI();
    }

    /**
     * Closes the login user interface
     */
    public void closing() {
        loginUI.dispose();
    }

}
