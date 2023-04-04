/** Required package class namespace */
package data;

/**
 * Required imports
 */
import collections.LinkedList;
import java.awt.List;
import java.io.Serializable;
import userinterfaces.ViewReceiptUI;

/**
 * Receipts.java - a collection of receipt objects and methods to organize the
 * receipts in conjunction with the relevant user interfaces that the user
 * interacts with when using the application
 *
 * @author mikex
 */
public class Receipts implements Serializable {

    // Encalsulated list object
    private LinkedList<Receipt> list;

    /**
     * Default constructor method that instantiates the class
     */
    public Receipts() {
        list = new LinkedList<Receipt>();
    }

    /**
     * Determines if the database is empty or not
     *
     * @return empty (true), not empty (false)
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds the passed receipt object to the collection (LinkedList) of receipts
     *
     * @param receipt the receipt object to add
     */
    public void addToLinkedList(Receipt receipt) {
        list.add(receipt);
    }

    /**
     * Adds the passed receipt object to the listbox on the receipts UI
     *
     * @param receipt the receipt object to add
     * @param receiptList the listbox field on the receipts UI
     */
    public void add(Receipt receipt, List receiptList) {
        receiptList.add(receipt.toString());
    }

    /**
     * Displays all the receipts in the database (LinkedList) in the passed
     * listbox from the receipts UI
     *
     * @param receiptList the listbox field on the receipts UI
     */
    public void displayAll(List receiptList) {
        receiptList.removeAll();        // Clears the entire listbox of anything
        // Loops through entire database (LinkedList) and adds each receipt in
        for (int i = 0; i < list.size(); i++) {
            Receipt receipt = list.get(i);
            receiptList.add(receipt.toString());
        }
    }

    /**
     * Display the selected receipt in a instantiated view receipt UI
     *
     * @param index the selected index of the receipt from the listbox
     */
    public void displaySelected(int index) {
        Receipt receipt = list.get(index);
        String content = receipt.getContent();
        new ViewReceiptUI(content);
    }

    /**
     * Deletes the selected receipt from the database (LinkedList) and the
     * listbox in the receipts UI
     *
     * @param index the selected index of the receipt from the listbox
     * @param receiptList the listbox field on the receipts UI
     */
    public void deleteSelected(int index, List receiptList) {
        if (index != -1) {
            list.remove(index);
            receiptList.remove(index);
        }
    }

    /**
     * Checks if required fields were filled before calling the search method
     * to search through the list with the search type and text to search for,
     * then displaying it results in the list
     *
     * @param receiptList the list the receipts are displayed in
     * @param choice the type of search to conduct
     * @param text the text to search for
     */
    public void search(List receiptList, String choice, String text) {
        // Displays all receipts in list
        DataStructures.receipts.displayAll(receiptList);
        // If no search type then prompts user to select one
        if (choice.equals("") || choice == null) {
            DataStructures.dialogs.output("Please select a search type");
            return;         // Ends method early
        }
        // If no text to search then prompts user to type one in
        if (text.equals("") || choice == null) {
            DataStructures.dialogs.output("Please enter text to search for");
            return;         // Ends method early
        }
        // Gets type of search then searches for the text with the search method
        if (choice.equals("Name")) {
            DataStructures.type = DataStructures.BY_NAME;
            searchMethod(receiptList, choice, text);
        } else if (choice.equals("Number")) {
            DataStructures.type = DataStructures.BY_NUMBER;
            searchMethod(receiptList, choice, text);
        } else if (choice.equals("Address")) {
            DataStructures.type = DataStructures.BY_ADDRESS;
            searchMethod(receiptList, choice, text);
        }
    }

    /**
     * Searches through the list of receipts for any matching receipts to what 
     * is being searched for and displays all results in the list
     * 
     * @param receiptList the list the receipts are displayed in
     * @param choice the type of search to conduct
     * @param text the text to search for
     */
    private void searchMethod(List receiptList, String choice, String text) {
        // Creates a new temporary receipt object
        Receipt receipt = null;
        // Checks for search type and creates a temporary array with text
        if (choice.equals("Name")) {
            // Sets the text to search for in the temp receipt
            receipt = new Receipt(text, null, null, null, null);
        } else if (choice.equals("Number")) {
            // Sets the text to search for in the temp receipt
            receipt = new Receipt(null, null, text, null, null);
        } else if (choice.equals("Address")) {
            // Sets the text to search for in the temp receipt
            receipt = new Receipt(null, null, null, text, null);
        }
        // Creates an array of integers with all indices receipts that match
        // the text to search for
        int[] indices = list.allIndices(receipt);
        // If there are no indices then tell user there are no matching receipts
        if (indices == null) {
            DataStructures.dialogs.output("No receipt with that " + choice);
            return;         // End method early
        }
        receiptList.removeAll();// Clears the entire listbox of anything
        // Loops through all matching indices and displays them on the list
        for (int i = 0; i < indices.length; i++) {
            Receipt newReceipt = list.get(indices[i]);
            receiptList.add(newReceipt.toString());
        }
    }

    /**
     * Saves the receipts data to a permanent file
     */
    public void closing() {
        DataStructures.fileHandler.saveObject(this, DataStructures.receiptData);
    }

}
