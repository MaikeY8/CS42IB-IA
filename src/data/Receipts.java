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
     *
     *
     * @param receiptList
     * @param choice
     * @param text
     */
    public void search(List receiptList, String choice, String text) {
        DataStructures.receipts.displayAll(receiptList);
        if (choice.equals("") || choice == null) {
            DataStructures.dialogs.output("Please select a search type");
            return;
        }
        if (text.equals("") || choice == null) {
            DataStructures.dialogs.output("Please enter text to search for");
            return;
        }
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

    private void searchMethod(List receiptList, String choice, String text) {
        Receipt receipt = new Receipt(text, null, null, null, null);
        int[] indices = list.allIndices(receipt);
        if (indices == null) {
            DataStructures.dialogs.output("No receipt with that " + choice);
            return;
        }
        receiptList.removeAll();// Clears the entire listbox of anything
        for (int i = 0; i < indices.length; i++) {
            Receipt newReceipt = list.get(indices[i]);
            receiptList.add(newReceipt.toString());
        }
    }

    /**
     *
     *
     * @param receiptList
     * @param option
     */
    public void sort(List receiptList, String option) {
        DataStructures.receipts.displayAll(receiptList);
    }

    /**
     * Saves the receipts data to a permanent file
     */
    public void closing() {
        DataStructures.fileHandler.saveObject(this, DataStructures.receiptData);
    }

}
