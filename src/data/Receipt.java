
/** Required package class namespace */
package data;

/** Required imports */
import java.io.Serializable;

/**
 * Receipt.java - represents an electronic receipt that stores the contents of
 * a receipt (details of an order) and other important details to be stored
 * for records and viewing
 * 
 * @author mikex
 */
public class Receipt implements Serializable {
    
    /** the global properties of this receipt object */
    private final String customerName;
    private final String orderType;
    private final String number;
    private final String address;
    private final String content;

    /**
     * A constructor method which sets the class properties. Done by connecting 
     * the passed in parameters to the encapsulated properties (global variables
     * of this class)
     * 
     * @param customerName the name of the customer of the receipt
     * @param orderType the type of order on the receipt
     * @param number the customer's number on the receipt
     * @param address the customer's address on the receipt
     * @param content the contents of the receipt object
     */
    public Receipt(String customerName, String orderType, String number,
            String address, String content) {
        this.customerName = customerName;
        this.orderType    = orderType;
        this.number       = number;
        this.address      = address;
        this.content      = content;
    }
    
    /**
     * An Accessor method for the encapsulated class property
     * @return the name of the customer for this receipt
     */
    public String getName() {
        return customerName;
    }
    
    /**
     * An Accessor method for the encapsulated class property
     * @return the type of order for this receipt object
     */
    public String getOrderType() {
        return orderType;
    }
    
    /**
     * An Accessor method for the encapsulated class property
     * @return the customer's number for this receipt object
     */
    public String getNumber() {
        return number;
    }
    
    /**
     * An Accessor method for the encapsulated class property
     * @return the customer's address for this receipt object
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * An Accessor method for the encapsulated class property
     * @return the contents of the actual receipt object
     */
    public String getContent() {
        return content;
    }
    
    /**
     * String representation of this object
     * 
     * @return the object represented as a String
     */
    @Override
    public String toString() {
        return customerName + " | " + number + " | " + address;
    }
    
    
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     * 
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        // Gets the generated receipt to compare with
        Receipt that = (Receipt)object;
        // If name search then checks if receipt has same name
        if (DataStructures.type == DataStructures.BY_NAME) {
            return this.getName().equalsIgnoreCase(that.getName());
        }
        // If number search then checks if receipt has same name
        else if (DataStructures.type == DataStructures.BY_NUMBER) {
            return this.getNumber().equalsIgnoreCase(that.getNumber());
        }
        // If address search then checks if receipt has same name
        else if (DataStructures.type == DataStructures.BY_ADDRESS) {
            return this.getAddress().equalsIgnoreCase(that.getAddress());
        }
        // No matches return false
        return false;
    }
}
