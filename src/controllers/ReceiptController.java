
/** Required package class namespace */
package controllers;

/** Required imports */
import data.DataStructures;
import data.Receipt;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import userinterfaces.MenuUI;
import userinterfaces.ViewReceiptUI;

/**
 * ReceiptController.java - this class is connected to the view receipt and 
 * receipts user interface for viewing all the receipts and the contents of each
 * receipt. This controller class stores all the methods and code to be run that
 * is associated with the view receipt UI and the receipts UI. This controller 
 * class connects to the view the user has of the view receipt user interface
 * and the receipts user interface
 * 
 * @author Wen Pei (Michael) Yan
 * @since Feb, 2023
 */
public class ReceiptController {
    
    // Private/encapsulated property of this class
    private ViewReceiptUI viewReceiptUI;
    private List receiptList;
    private JComboBox jComboBoxSearch;
    private JTextField jTextSearch;
    private JTextArea jTextArea;
    private String receiptContent;

    /**
     * Constructor method that adds the passed receipt to the collection
     * 
     * @param receipt the receipt object 
     */
    public ReceiptController(Receipt receipt) {
        DataStructures.receipts.addToLinkedList(receipt);
    }
    
    /**
     * A constructor method which sets the properties of the UI and sets class 
     * properties.Done by connecting the passed in parameters to the 
 encapsulated properties (global variables of this class).
     * 
     * @param viewReceiptUI the viewReceiptUI user interface
     * @param jTextArea the text area for the receipt content
     * @param receiptContent the receipt content
     */
    public ReceiptController(
            ViewReceiptUI viewReceiptUI,
            JTextArea     jTextArea,
            String        receiptContent) {
        this.viewReceiptUI = viewReceiptUI;
        this.jTextArea     = jTextArea;
        // Displays the receipt contents
        jTextArea.setText(receiptContent);
        // Sets the title of the frame
        viewReceiptUI.setTitle(DataStructures.TITLE);
        // Sets the icon image of the frame
        viewReceiptUI.setIconImage(DataStructures.iconImage);
        // Sets the size of the frame
        viewReceiptUI.setSize(387, 740);
        // Sets the location to show up in the middle
        viewReceiptUI.setLocationRelativeTo(null);
        // Sets the frame to be visible
        viewReceiptUI.setVisible(true);
        // Sets the frame resizable property to false
        viewReceiptUI.setResizable(false);
    }
    
    /**
     * A constructor method which sets the class properties. Done by connecting 
     * the passed in parameters to the encapsulated properties (global variables
     * of this class).
     * 
     * @param receiptList the list that displays all the receipts in receipts UI
     * @param jComboBoxSearch the search combo box
     * @param jTextSearch the search text box field
     */
    public ReceiptController(List receiptList, JComboBox jComboBoxSearch,
            JTextField jTextSearch) {
        this.receiptList = receiptList;
        this.jComboBoxSearch = jComboBoxSearch;
        this.jTextSearch = jTextSearch;
    }
    
    /**
     * Displays all the receipts that are stored in the data base (if there are
     * any) and error checks the listbox
     */
    public void displayAllReceipts() {
        // If there are no receipts collection (database)
        if (DataStructures.receipts.isEmpty() == true) {
            // Outputs there are no receipts collection (database
            DataStructures.dialogs.output("There are no receipts");
            return;         // Exits the method early
        }
        // Displays all receipts in the listbox
        DataStructures.receipts.displayAll(receiptList);
    }
    
    /**
     * Displays the contents of the receipt by instantiating a new view receipt
     * UI and error checks to make sure that a receipt was selected
     */
    public void displaySelectedReceipt() {
        // Gets the selected index of the listbox
        int index = receiptList.getSelectedIndex();
        // If nothing is selected (no index)
        if (index == -1) {
            // Prompts the user to select a receipt
            DataStructures.dialogs.output("Please select a receipt");
            return;         // Exits the method early
        }
        // Displays the contents of the selected receipt
        DataStructures.receipts.displaySelected(index);
    }
    
    /**
     * Deletes the selected receipt from the database and the listbox and error
     * checks to make sure that an receipt was selected
     */
    public void deleteSelectedReceipt() {
        // Gets the selected index of the listbox
        int index = receiptList.getSelectedIndex();
        // If nothing is selected (no index)
        if (index == -1) {
            // Prompts the user to select a receipt
            DataStructures.dialogs.output("Please select a receipt");
            return;         // Exits the method early
        }
        // Deletes the selected receipt from listbox and database
        DataStructures.receipts.deleteSelected(index, receiptList);
    }
    
    /**
     * When button is pressed, searches through all receipts for matching search
     * results based on the type of search and the text to search for after
     * checking to make sure list is not empty
     */
    public void searchAllReceipts() {
        // If the collection is empty then informs user the list is empty
        if (DataStructures.receipts.isEmpty() == true) {
            DataStructures.dialogs.output("There are no receipts");
            return;         // Ends method early
        }
        // If no search type then prompts user to select one
        if (jComboBoxSearch.getSelectedItem() == null) {
            DataStructures.dialogs.output("Please select a search type");
            return;         // Ends method early
        }
        // Gets the search type from the combo box
        String choice = jComboBoxSearch.getSelectedItem().toString();
        // Gets the text to search for from the text field
        String text = jTextSearch.getText();
        // Calls the search method
        DataStructures.receipts.search(receiptList, choice, text);
    }
    
    /**
     * Closes the a receipt UI and saves the receipt data to a permanent file
     * 
     * @param frame the JFrame to be disposed of
     */
    public void closing(JFrame frame) {
        DataStructures.receipts.closing();
        frame.dispose();
    }
    
    /**
     * When menu button is pressed, confirms the menu with the user before
     * proceeding to go to the menu
     */
    public void menu(JFrame frame) {
        // Asks the user if he wishes to proceed to the menu
        boolean input = DataStructures.dialogs.yesNo("Go back to the menu?");
        // If user replies with yes
        if (input == true) {
            new MenuUI();           // Instantiates the menu UI
            closing(frame);         // Closes the order UI
        }
    }
}
