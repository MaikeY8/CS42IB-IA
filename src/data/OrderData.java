/** Required package class namespace */
package data;

/**
 * Required import
 */
import java.math.BigDecimal;

/**
 * OrderData.java - this class stores all the data for each item that can be
 * ordered in arrays depending on the category of the item. All arrays are
 * public constants and can be accessed from any class but cannot be changed
 * 
 * @author Wen Pei (Michael) Yan
 * @since Feb, 2023
 */
public class OrderData {

    // Constant prices for all menu items......................................
    // Appetizers
    public final static String[] APPETIZER_NAMES
            = {"Egg Rolls", "Crispy Wontons"};
    public final static BigDecimal[] APPETIZER_PRICES
            = {new BigDecimal("2.15"), new BigDecimal("9.95")};

    // Soups
    public final static String[] SOUP_NAMES
            = {"Consomme", "Wonton Soup", "Deluxe Wonton Soup",
                "Hot&Sour Soup"};
    public final static BigDecimal[] SOUP_PRICES
            = {new BigDecimal("4.45"), new BigDecimal("9.95"),
                new BigDecimal("11.95"), new BigDecimal("11.95")};

    // Rice
    public final static String[] RICE_NAMES
            = {"Pln Fried Rice", "Mshrm Fried Rice",
                "Chicken Fried Rice", "Pork Fried Rice",
                "Beef Fried Rice", "Shrimp Fried Rice"};
    public final static BigDecimal[] RICE_PRICES
            = {new BigDecimal("9.40"), new BigDecimal("9.75"),
                new BigDecimal("10.95"), new BigDecimal("9.90"),
                new BigDecimal("9.90"), new BigDecimal("10.85")};

    // Noodles
    public final static String[] NOODLE_NAMES
            = {"Pln Chow Mein", "Mushroom Chow Mein",
                "Chicken Chow Mein", "Fried Pork Chow Mein",
                "Fried Beef Chow Mein", "Shrimp Chow Mein"};
    public final static BigDecimal[] NOODLE_PRICES
            = {new BigDecimal("10.25"), new BigDecimal("10.45"),
                new BigDecimal("10.50"), new BigDecimal("10.50"),
                new BigDecimal("10.50"), new BigDecimal("10.75")};

    // Chicken
    public final static String[] CHICKEN_NAMES
            = {"Swt&Sour Chkn Balls", "Lemon Chicken",
                "Chicken & Almonds", "Curry Chicken",
                "Garlic Chicken", "Chicken & Brocolli"};
    public final static BigDecimal[] CHICKEN_PRICES
            = {new BigDecimal("13.25"), new BigDecimal("13.85"),
                new BigDecimal("12.45"), new BigDecimal("12.95"),
                new BigDecimal("14.50"), new BigDecimal("11.95")};

    // Pork
    public final static String[] PORK_NAMES
            = {"Swt&Sour Pork", "Swt&Sour Ribs",
                "Breaded Fried Ribs", "Honey Garlic Ribs",
                "Blk Bean & Glc Ribs", "Cantonese Steam Ribs"};
    public final static BigDecimal[] PORK_PRICES
            = {new BigDecimal("13.25"), new BigDecimal("13.25"),
                new BigDecimal("13.95"), new BigDecimal("14.25"),
                new BigDecimal("13.75"), new BigDecimal("13.95")};

    // Beef
    public final static String[] BEEF_NAMES
            = {"Honey Garlic Beef", "Beef & Curry Sauce",
                "Beef with Mushroom", "Beef and Broccoli",
                "Breaded Fried Veal", "Garlic Beef"};
    public final static BigDecimal[] BEEF_PRICES
            = {new BigDecimal("14.45"), new BigDecimal("12.95"),
                new BigDecimal("12.95"), new BigDecimal("11.95"),
                new BigDecimal("13.95"), new BigDecimal("12.95")};

    // Seafood
    public final static String[] SEAFOOD_NAMES
            = {"Fried Battered Shrimp", "Fried Breaded Shrimp",
                "Sweet&Sour Shrimp", "Pan Fried Shrimp",
                "Curry Shrimp", "Garlic Shrimp"};
    public final static BigDecimal[] SEAFOOD_PRICES
            = {new BigDecimal("14.40"), new BigDecimal("14.55"),
                new BigDecimal("14.65"), new BigDecimal("14.85"),
                new BigDecimal("14.45"), new BigDecimal("14.85")};

    // Vegetables
    public final static String[] VEGETABLE_NAMES
            = {"Plain Veges", "Chicken & Vegetables",
                "Pork & Veges", "Beef & Veges",
                "Shrimp & Veges", "Deluxe Veges"};
    public final static BigDecimal[] VEGETABLE_PRICES
            = {new BigDecimal("11.35"), new BigDecimal("11.95"),
                new BigDecimal("11.95"), new BigDecimal("11.95"),
                new BigDecimal("13.85"), new BigDecimal("13.95")};

    // Combos
    public final static String[] COMBO_NAMES
            = {"Combo A", "Combo B", "Combo C", "Combo D"};
    public final static BigDecimal[] COMBO_PRICES
            = {new BigDecimal("14.15"), new BigDecimal("14.45"),
                new BigDecimal("14.45"), new BigDecimal("14.45")};

    // Specials
    public final static String[] SPECIALS_NAMES
            = {"Kung Po Mixed Chicken", "Szechuan Chicken",
                "Szechuan Fried Shrimp", "Ginger Beef",
                "Spicy Squid", "Sesame Mixed Chicken"};
    public final static BigDecimal[] SPECIALS_PRICES
            = {new BigDecimal("14.75"), new BigDecimal("13.50"),
                new BigDecimal("14.95"), new BigDecimal("14.95"),
                new BigDecimal("14.95"), new BigDecimal("14.95")};

    // Misc
    public final static String[] MISC_NAMES
            = {"Sweet & Sour Sauce", "Honey Garlic Sauce",
                "Dry Noodles", "Steamed Rice",
                "Fortune Cookie", "Soft Drink"};
    public final static BigDecimal[] MISC_PRICES
            = {new BigDecimal("3.75"), new BigDecimal("3.75"),
                 new BigDecimal("3.35"), new BigDecimal("4.75"),
                new BigDecimal("0.40"), new BigDecimal("2.00")};
}
