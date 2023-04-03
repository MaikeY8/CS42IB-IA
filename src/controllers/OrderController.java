/** Required package class namespace */
package controllers;

/**
 * Required imports
 */
import data.DataStructures;
import data.Receipt;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import userinterfaces.LoginUI;
import userinterfaces.MenuUI;
import userinterfaces.OrderUI;
import userinterfaces.ViewReceiptUI;

/**
 * OrderController.java - this class is connected to the order user interface
 * for creating a order and generating a receipt from that order. This
 * controller class stores all the methods and code to be run that is associated
 * with the order UI. This controller class connects to the view the user has of
 * the order user interface
 *
 * @author mikex
 */
public class OrderController {

    // Private/encapsulated constant for this class
    private final static double TAX = 0.12;

    // Private/encapsulated properties of this class
    private BigDecimal[] itemCostsArray = new BigDecimal[6];
    private OrderUI orderUI;
    private ViewReceiptUI viewReceiptUI;
    private JTable jTableOrder;
    private JTextField jTextSubTotal;
    private JTextField jTextTax;
    private JTextField jTextTotal;
    private JComboBox jComboBoxPayment;
    private JTextField jTextAmount;
    private JTextField jTextChange;
    private JLabel jLabelItems;
    private JButton jButtonItem1;
    private JButton jButtonItem2;
    private JButton jButtonItem3;
    private JButton jButtonItem4;
    private JButton jButtonItem5;
    private JButton jButtonItem6;
    private JTextField jTextFieldCustomerName;
    private JTextField jTextFieldNumber;
    private JTextField jTextFieldAddress;
    private JComboBox jComboBoxOrderType;

    /**
     * A constructor method which sets the class properties. Done by connecting
     * the passed in parameters to the encapsulated properties (global variables
     * of this class)
     *
     * @param orderUI the UI for creating a new order and generating a receipt
     * @param jTableOrder the table where all the ordered items are displayed
     * @param jTextSubTotal the text box field where the subtotal is displayed
     * @param jTextTax the text box field where the tax is displayed
     * @param jTextTotal the text box field where the total is displayed
     * @param jComboBoxPayment the combo box where payment method is selected
     * @param jTextAmount the text box field where the customer's pay is entered
     * @param jTextChange the text box field where the change is displayed
     * @param jLabelItems the label where the category of items is labeled
     * @param jButtonItem1 the first item button
     * @param jButtonItem2 the second item button
     * @param jButtonItem3 the third item button
     * @param jButtonItem4 the fourth item button
     * @param jButtonItem5 the fifth item button
     * @param jButtonItem6 the sixth item button
     * @param jTextFieldCustomerName the text box where customer name is entered
     * @param jTextFieldNumber the text box where customer's number is entered
     * @param jTextFieldAddress the text box where customer's address is entered
     * @param jComboBoxOrderType the combo box where the order type is selected
     */
    public OrderController(
            OrderUI orderUI,
            JTable jTableOrder,
            JTextField jTextSubTotal,
            JTextField jTextTax,
            JTextField jTextTotal,
            JComboBox jComboBoxPayment,
            JTextField jTextAmount,
            JTextField jTextChange,
            JLabel jLabelItems,
            JButton jButtonItem1,
            JButton jButtonItem2,
            JButton jButtonItem3,
            JButton jButtonItem4,
            JButton jButtonItem5,
            JButton jButtonItem6,
            JTextField jTextFieldCustomerName,
            JTextField jTextFieldNumber,
            JTextField jTextFieldAddress,
            JComboBox jComboBoxOrderType) {
        this.orderUI = orderUI;
        this.jTableOrder = jTableOrder;
        this.jTextSubTotal = jTextSubTotal;
        this.jTextTax = jTextTax;
        this.jTextTotal = jTextTotal;
        this.jComboBoxPayment = jComboBoxPayment;
        this.jTextAmount = jTextAmount;
        this.jTextChange = jTextChange;
        this.jLabelItems = jLabelItems;
        this.jButtonItem1 = jButtonItem1;
        this.jButtonItem2 = jButtonItem2;
        this.jButtonItem3 = jButtonItem3;
        this.jButtonItem4 = jButtonItem4;
        this.jButtonItem5 = jButtonItem5;
        this.jButtonItem6 = jButtonItem6;
        this.jTextFieldCustomerName = jTextFieldCustomerName;
        this.jTextFieldNumber = jTextFieldNumber;
        this.jTextFieldAddress = jTextFieldAddress;
        this.jComboBoxOrderType = jComboBoxOrderType;
        Arrays.fill(itemCostsArray, BigDecimal.ZERO);
    }

    /**
     * A constructor method which sets a class property. Done by connecting the
     * passed in parameter to the encapsulated property (global variable of this
     * class)
     *
     * @param viewReceiptUI the UI for viewing the contents of a receipt object
     */
    public OrderController(ViewReceiptUI viewReceiptUI) {
        this.viewReceiptUI = viewReceiptUI;
    }

    /**
     * Sets up the item buttons used for adding items to the order and assigns
     * prices to each button based on the passed parameters
     *
     * @param buttonName the text of each button
     * @param names the array of names of each dish/item for the buttons
     * @param prices the array of prices of each dish/item for the buttons
     */
    public void setItems(String buttonName, String[] names, BigDecimal[] prices)
    {
        jLabelItems.setText(buttonName);
        resetButtons();
        setButtonNames(names);
        setButtons(prices.length);
        changeItemPrices(prices);
    }

    /**
     * Sets the name of all the item buttons to a specific dish/item from the
     * passed names of dishes
     *
     * @param names the array of names for each dish (based on category)
     */
    private void setButtonNames(String[] names) {
        JButton[] buttons = {jButtonItem1, jButtonItem2, jButtonItem3,
            jButtonItem4, jButtonItem5, jButtonItem6};
        // Loops through all the array of names
        for (int i = 0; i <= names.length - 1; i++) {
            // Sets the button to the name with same index
            buttons[i].setText(names[i]);
        }
    }

    /**
     * Sets the number of buttons required from the passed number of buttons
     *
     * @param buttonNum the number of buttons based on the names array length
     */
    private void setButtons(int buttonNum) {
        // Checks if there is an invalid amount of buttons (no buttons)
        if (buttonNum <= 0) {
            return;         // Exits the method early
        }
        // Checks if there is an invalid amount of buttons (too many buttons)
        if (buttonNum >= 6) {
            return;         // Exits the method early
        }
        // Checks for the right amount of buttons
        if (buttonNum < 6) {
            // Create an array of the buttons on the order UI
            JButton[] buttons = {jButtonItem1, jButtonItem2, jButtonItem3,
                jButtonItem4, jButtonItem5, jButtonItem6};
            // Loops through the unneeded buttons in the array
            for (int i = buttonNum; i <= 5; i++) {
                // Turn button invisible and disabled based on the index
                buttons[i].setVisible(false);
                buttons[i].setEnabled(false);
            }
        }
    }

    /**
     * Resets all the buttons to have no text, invisible, and disabled
     */
    private void resetButtons() {
        // Create an array of the buttons on the order UI
        JButton[] buttons = {jButtonItem1, jButtonItem2, jButtonItem3,
            jButtonItem4, jButtonItem5, jButtonItem6};
        // Loops through all the buttons in the array
        for (int i = 0; i <= 5; i++) {
            // Reset button, no text, disabled, and invisible
            buttons[i].setText(null);
            buttons[i].setVisible(true);
            buttons[i].setEnabled(true);
        }
    }

    /**
     * Adds up all the item prices on the table and returns that value
     *
     * @return all the prices on the table added up
     */
    private double checkTableCost() {
        double allCost = 0;
        // Loops for each row in the table
        for (int i = 0; i < jTableOrder.getRowCount(); i++) {
            // Gets value of row in column 2 (amount) and converts to String
            String value = jTableOrder.getValueAt(i, 2).toString();
            // Converts the string value to double
            double amount = Double.parseDouble(value);
            // Adds the amount to all the cost
            allCost += amount;
        }
        return allCost;
    }

    /**
     * Sets the text box fields with the subtotal, tax, and total with the
     * correct amount for the order based on the total price of the table
     */
    public void cost() {
        // Gets total cost of items on the table by calling checkTableCost
        double allCost = checkTableCost();
        // Converts all the cost to String with 2 decimal places
        String stringSubTotal = String.format("%.2f", allCost);
        // Changes the text field to have the subtotal inside
        jTextSubTotal.setText(stringSubTotal);
        // Calculates the tax
        double tax = (allCost * TAX);
        // Converts the tax to a String
        String stringTax = String.format("%.2f", tax);
        // Changes the text field to have the tax inside
        jTextTax.setText(stringTax);
        // Calculates the total
        double total = (allCost + tax);
        // Converts the total to a String
        String stringTotal = String.format("%.2f", total);
        // Changes the text field to have the total inside
        jTextTotal.setText(stringTotal);
    }

    /**
     * Calculates the change that is needed to give back to the customer based
     * on the customer amount inputted by the user and displays the change in
     * the change text box field
     * 
     * @return true or false depending on if customer is paying enough
     */
    public boolean change() {
        // Gets total cost of items on the table by calling checkTableCost
        double allCost = checkTableCost();
        // Gets the amount the customer is paying with
        String stringCustomerAmount = jTextAmount.getText();
        // Converts the amount to a double
        double customerAmount = Double.parseDouble(stringCustomerAmount);
        // Calculates the tax
        double tax = (allCost * TAX);
        // Calculates the total for the order
        double total = allCost + tax;
        // If the total price of the order is more than what customer is paying
        if (total > customerAmount) {
            return false;
        }
        // If the total is the same as the amount the customer is paying
        if (total == customerAmount) {
            // Sets the change text box to have no change
            jTextChange.setText("0.00");
            return true;
        }
        else {
            // Calculates the change
            double change = customerAmount - total;
            // Format the change amount and sets the textbox
            String stringChange = String.format("%.2f", change);
            jTextChange.setText(stringChange);
            return true;
        }
    }

    /**
     * Closes the order user interface
     */
    public void closing() {
        orderUI.dispose();
    }

    /**
     * Changes the item prices for each item button based on the inputted array
     * of prices
     *
     * @param prices the array of prices based on a category of item
     */
    private void changeItemPrices(BigDecimal[] prices) {
        // Loops through the length of the prices array
        for (int i = 0; i < prices.length; i++) {
            // Sets itemCost array index the same as the price array index
            itemCostsArray[i] = prices[i];
        }
    }

    /**
     * On a item button press, adds an item to the table depending on the button
     * press of any item button based on the passed data from each button
     *
     * @param buttonName the text on the item button
     * @param amount the amount to add per item
     * @param buttonNum the button number depending on the item button
     */
    public void addItem(String buttonName, int amount, int buttonNum) {
        // Sets the table model
        DefaultTableModel table = (DefaultTableModel) jTableOrder.getModel();
        // Loops through all rows of the table
        for (int i = 0; i < table.getRowCount(); i++) {
            // Checks when the text on the button is same as item name on table
            if (buttonName == table.getValueAt(i, 0)) {
                // Gets the amount of items in the row (item)
                int itemAmount = (int) table.getValueAt(i, 1);
                // Adds to the amount of items in the row (item)
                itemAmount++;
                // Sets the new amount onto the table
                jTableOrder.setValueAt(itemAmount, i, 1);
                // Converts the item amount to BigDecimal to calculate with
                BigDecimal tableAmount = new BigDecimal(itemAmount);
                // Calculates the new total cost of the row (item(s)) on table
                BigDecimal newCost
                        = tableAmount.multiply(itemCostsArray[buttonNum]);
                // Sets the new cost onto the table
                jTableOrder.setValueAt(newCost, i, 2);
                cost();         // Calculates the new cost of the order
                return;         // Exits the method early
            }
        }

        // Creates a new vector
        Vector data = new Vector();
        // Adds the required data for the vector
        data.add(buttonName);
        data.add(amount);
        data.add(itemCostsArray[buttonNum]);
        // Adds the new row (item) with the created vector data
        table.addRow(data);
        cost();                 // Calculates the new cost of the order
    }

    /**
     * When logout button is pressed, confirms the logout with the user before
     * proceeding to logout
     */
    public void logout() {
        // Asks the user if he wishes to proceed with logging out
        boolean input = DataStructures.dialogs.yesNo("Proceed to logout?");
        // If user replies with yes
        if (input == true) {
            new LoginUI();      // Instantiates the login UI
            closing();          // Closes the order UI
        }
    }

    /**
     * When reset button is pressed, asks the user if they wish to proceed with
     * resetting the order before resetting all the data of the order on the
     * order menu for a new order
     */
    public void reset() {
        // Asks the user if he wishes to proceed with order reset
        boolean input = DataStructures.dialogs.yesNo("Reset the order?");
        // If user replies with yes
        if (input == true) {
            // Sets the itemCostArray values to 0 (each item button price value)
            Arrays.fill(itemCostsArray, BigDecimal.ZERO);
            // Sets the table model
            DefaultTableModel tableModel
                    = (DefaultTableModel) jTableOrder.getModel();
            // Removes all the rows (items) in the table
            tableModel.setRowCount(0);
            // Sets all the textbox fields to be empty
            jTextFieldCustomerName.setText("");
            jTextFieldNumber.setText("");
            jTextFieldAddress.setText("");
            jTextAmount.setText("");
            // Sets all the combo box selections to nothing
            jComboBoxOrderType.setSelectedIndex(-1);
            jComboBoxPayment.setSelectedIndex(-1);
            cost();            // Calculates the new cost of the order (nothing)
        }
    }

    /**
     * When menu button is pressed, confirms the menu with the user before
     * proceeding to go to the menu
     */
    public void menu() {
        // Asks the user if he wishes to proceed to the menu
        boolean input = DataStructures.dialogs.yesNo("Go back to the menu?");
        // If user replies with yes
        if (input == true) {
            new MenuUI();           // Instantiates the menu UI
            closing();              // Closes the order UI
        }
    }

    /**
     * When remove button is pressed, checks for the selected index before
     * proceeding to remove the row (item) from the table
     */
    public void removeItem() {
        // Sets the table model
        DefaultTableModel table = (DefaultTableModel) jTableOrder.getModel();
        // Gets the selected row on the table
        int selectedRow = jTableOrder.getSelectedRow();
        // Checks if no row was selected
        if (selectedRow == -1) {
            // Asks user to select an item to remove
            DataStructures.dialogs.output("Please select an item to remove");
        } else {
            // Removes the selected row from the table
            table.removeRow(selectedRow);
            cost();             // Calculates the new cost of the order
        }
    }

    /**
     * When the pay button is pressed, checks to make sure that all required
     * fields for the order are filled before calculating the change needed to
     * give back to the customer, then generates the receipt, displays it and
     * saves it to the database
     */
    public void pay() {
        // Checks if customer's name isn't filled
        if (jTextFieldCustomerName.getText() == null
                || jTextFieldCustomerName.getText().equals("")) {
            // Prompts user to fill in the customer's name
            DataStructures.dialogs.output("Please enter the customer's name");
            return;         // Exits the method early
        }
        // Checks if order type isn't selected
        if (jComboBoxOrderType.getSelectedIndex() == -1
                || jComboBoxOrderType.getSelectedItem() == null) {
            // Prompts user to select an order type
            DataStructures.dialogs.output("Please select the order type");
            return;         // Exits the method early
        }
        // Checks if the customer's number isn't filled
        if (jTextFieldNumber.getText() == null
                || jTextFieldNumber.getText().equals("")) {
            // Prompts user to fill in the customer's number
            DataStructures.dialogs.output("Please enter the customer's number");
            return;         // Exits the method early
        }
        // Checks if the customer's address isn't filled
        if (jTextFieldAddress.getText() == null
                || jTextFieldAddress.getText().equals("")) {
            // Prompts user to fill in the customer's address
            DataStructures.dialogs.output("Please enter customer's address");
            return;         // Exits the method early
        }
        // Checks if the table is empty (no items added to order)
        if (jTableOrder.getRowCount() == 0) {
            // Prompts user to add items to the order
            DataStructures.dialogs.output("Please add items to the order");
            return;         // Exits the method early
        }
        // Checks if the payment method isn't selected
        if (jComboBoxPayment.getSelectedIndex() == -1
                || jComboBoxPayment.getSelectedItem() == null) {
            // Prompts the user to select a payment method
            DataStructures.dialogs.output("Please select the payment method");
            return;         // Exits the method early
        }
        // Checks if the user inputted the amount the customer is paying with
        if (jTextAmount.getText() == null
                || jTextAmount.getText().equals("")) {
            // Prompts the user to fill in the amount
            DataStructures.dialogs.output("Please fill in the amount the "
                    + "customer is paying with");
            return;         // Exits the method early
        }
        // Passed all the tests order data tests...
        boolean check = change();      // Calculates the change for the customer
        // If didn't pass the check in the order
        if (check == false) { // Exits the method early
            // Tells user the customer is not paying enough
            DataStructures.dialogs.output("Customer is not paying enough");
            return;
        }
        // Gets all required cost data needed for the receipt
        double allCost = checkTableCost();  // Total cost of items on table
        String stringSubTotal = String.format("%.2f", allCost);
        double tax = (allCost * TAX);       // Calculates the tax
        String stringTax = String.format("%.2f", tax);
        double total = (allCost + tax);     // Calculates the total
        String stringTotal = String.format("%.2f", total);
        // Gets all the customer's data on the order for the receipt
        String customerName = jTextFieldCustomerName.getText(); // Gets name
        Object object = jComboBoxOrderType.getSelectedItem();
        String orderType = object.toString();          // Gets order type
        Object object1 = jComboBoxPayment.getSelectedItem();
        String payment = object1.toString();           // Gets payment method
        String number = jTextFieldNumber.getText();    // Gets customer's number
        String address = jTextFieldAddress.getText();  // Gets customer address
        // Generates the content of the receipt
        String receiptContent = receiptContent(customerName, orderType, number,
                address, payment, stringTotal, stringTax, stringSubTotal);
        // Instantiates a Receipt object (create an instance of a Receipt)
        Receipt receipt = new Receipt(
                customerName, orderType, number, receiptContent);
        // Adds the receipt to the collection (Receipts)
        new ViewReceiptController(receipt);
        // Displays the receipt in the viewReceipt UI
        new ViewReceiptUI(receiptContent);
    }

    /**
     * Generates the contents of a receipt with the proper receipt format
     * including all the purchased items and details of the order based on the
     * passed in parameters
     *
     * @param customerName the name of the customer
     * @param orderType the type of order
     * @param number the customer's number
     * @param address the customer's address
     * @param payment the method of payment
     * @param total the total cost of the order
     * @param tax the price of tax of the order
     * @param subTotal the subtotal of the order
     * @return the completed contents of the receipt
     */
    private String receiptContent(String customerName, String orderType,
            String number, String address, String payment, String total,
            String tax, String subTotal) {
        // Sets the table model
        DefaultTableModel table = (DefaultTableModel) jTableOrder.getModel();
        // Formats the top portion of the receipt with customer data as a String
        String content = "\tRestaurant\n"
                + "\tAddress\n"
                + "\t204-000-0000"
                + "\nCashier: " + DataStructures.cashierName
                + "\nCustomer: " + customerName
                + "\nOrder Type: " + orderType
                + "\nNumber: " + number
                + "\nAddress: " + address
                + "\n-------------------------------------------------------"
                + "---------"
                + "\nItem\t\tAmount\tPrice"
                + "\n-------------------------------------------------------"
                + "---------\n";
        // Loops through all the rows (items) on the table
        for (int i = 0; i < jTableOrder.getRowCount(); i++) {
            // Gets name of row (item)
            String itemName = table.getValueAt(i, 0).toString();
            // Gets amount of the item of the row
            String itemAmount = table.getValueAt(i, 1).toString();
            // Gets the total price of the item(s) in the row
            String itemPrice = table.getValueAt(i, 2).toString();
            // If the item name is long then...
            if (itemName.length() <= 15) {
                // Give two indents for spacing when makeing new receipt line
                content += itemName + "\t\t" + itemAmount + "\t" + itemPrice
                        + "\n";
            } else {
                // Give one indent for spacing when makeing new receipt line
                content += itemName + "\t" + itemAmount + "\t" + itemPrice
                        + "\n";
            }
        }
        // Formats the bottom portion of the receipt with the costs of the order
        content += "--------------------------------------------------------"
                + "--------"
                + "\nPayment Method: " + payment
                + "\nSub-Total:\t\t\t" + subTotal
                + "\nTax:\t\t\t" + tax
                + "\nTOTAL:\t\t\t" + total;
        return content;      // Returns the formatted contents of the receipt
    }
}
