/** Required package class namespace */
package data;

/** Required imports */
import io.Dialogs;
import io.FileHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * DataStrcutures.java - a shared class of properties (static) across this
 * application of the main database data structure and other useful tools
 *
 * @author Wen Pei (Michael) Yan
 * @since Feb, 2023
 */
public class DataStructures {

    // Private/encapsulated constants for this class
    private static final Font FONT         = new Font("Brittanica Bold",
                                                      Font.PLAIN, 14);
    private static final Color  BACKGROUND = new Color(242, 242, 242);
    private static final Color  FOREGROUND = new Color(0, 0, 0);
    private static final String USER       = System.getProperty("user.name");
    private static final String PATH       = "C:\\Users\\" + USER
                                           + "\\Documents\\ReceiptsFile\\";
    private static final String FILE_PATH  = PATH + "receiptsData.txt";
    private static final String ICON_FILE  = "/media/panda.png";
    
    // Public properties for all the classes to share and use
    public static final String TITLE       = "Panda";
    public static final String PASSWORD    = "Panda123";
    public static final double TAX         = 0.12;
    
    public static final int     BY_NAME    = 1;
    public static final int     BY_NUMBER  = 2;
    public static final int     BY_ADDRESS = 3;
    
    public static Icon icon;
    public static Image iconImage;
    
    public static File                  receiptData;
    public static String                cashierName;
    public static Dialogs               dialogs;
    public static Receipts              receipts;
    public static FileHandler<Receipts> fileHandler;
    
    public static int                   type;

    /**
     * Constructor method that initializes the startup of the application and
     * loads the permanent storage into the data structures, while also
     * instantiating any other relevant classes
     */
    public DataStructures() {    
        // Instantiates receiptData as a File class
        receiptData = new File(FILE_PATH);
        // Instantiates the fileHandler class
        fileHandler = new FileHandler<>();
        // If receiptData file does not exist
        if (!receiptData.exists()) {
            // Creates a file path called foler
            File folder = new File(PATH);
            // Makes a directory to folder
            folder.mkdir();
            // Creates a file with no receipts in the folder
            fileHandler.saveObject(receipts, receiptData);
        }
        // Sets the icon for dialog boxes
        icon = new ImageIcon(getClass().getResource(ICON_FILE));
        // Sets the image icon for all frames
        iconImage = ((ImageIcon)icon).getImage();
        // Instantiates the dialogs class
        dialogs = new Dialogs(TITLE, null, FONT, BACKGROUND, FOREGROUND,
                              JOptionPane.PLAIN_MESSAGE, icon);
        // Gets all the receipts from the receiptData witht he fileHandler
        receipts = fileHandler.openObject(receiptData);
        // If there are no receipts creates a new collection
        if (receipts == null) {
            receipts = new Receipts();
        }
    }
}
