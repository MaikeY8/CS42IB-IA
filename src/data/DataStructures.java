
/** Required package class namespace */
package data;

/** Required imports */
import io.Dialogs;
import io.FileHandler;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * DataStrcutures.java - a shared class of properties (static) across this 
 * application of the main database data structure and other useful tools
 *
 * @author mikex
 */
public class DataStructures {
    
    // Private/encapsulated constants for this class
    private static final String TITLE      = "Restaurant";
    private static final Font   FONT       = new Font("Brittanica Bold",
            Font.PLAIN, 14);
    private static final Color  BACKGROUND = new Color(242, 242, 242);
    private static final Color  FOREGROUND = new Color(0, 0, 0);
    private static final String FILE_NAME  = "/media/receiptsData.txt";
    
    // Public properties for all the classes to share and use
    public static File receiptData;
    public static String cashierName;
    public static Dialogs  dialogs;
    public static Receipts receipts;
    public static FileHandler<Receipts> fileHandler;

    /**
     * Constructor method that initializes the startup of the application and
     * loads the permanent storage into the data structures, while also
     * instantiating any other relevant classes
     */
    public DataStructures() {
        // Try catch block for any error with the receipt file
        try {
            // Creates a url from the file name
            URL url = getClass().getResource(FILE_NAME);
            // Creates a uri from the url
            URI uri = url.toURI();
            // Creates the receiptData from the file based on the uri
            receiptData = new File(uri);
            // instantiates the dialogs class
            dialogs = new Dialogs(TITLE, null, FONT, BACKGROUND, FOREGROUND);
            // instantiates the fileHandler class
            fileHandler = new FileHandler<>();
            // Gets all the receipts from the receiptData witht he fileHandler
            receipts = fileHandler.openObject(receiptData);
            // If there are no receipts creates a new collection
            if (receipts == null) receipts = new Receipts();
        } 
        catch (URISyntaxException ex) {
            // Outputs error if there is one
            System.out.println("Error with receipt file URISyntaxException");
        }
    }
}
