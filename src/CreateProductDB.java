import java.sql.*;

public class CreateProductDB
{
    public CreateProductDB()
    {

        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:ProductDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Product table.
            buildproductTable(conn);

            // Build the Customer table.
            buildCartTable(conn);

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the Prouduct Table");
            System.out.println(e.getMessage());
        }

    }

    /**
     * The dropTables method drops any existing
     * in case the database already exists.
     */
    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the Customer table.
                stmt.execute("DROP TABLE Product");
                System.out.println("Product table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }

            try
            {
                // Drop the Coffee table.
                stmt.execute("DROP TABLE Cart");
                System.out.println("Cart table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The buildCoffeeTable method creates the
     * Coffee table and adds some rows to it.
     */
    public static void buildproductTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Product (" +
                    "id int , " +
                    "productName CHAR(10) NOT NULL PRIMARY KEY, " +
                    "price DOUBLE, " +
                    "description CHAR(250)" +
                    ")");

            stmt.execute("INSERT INTO Product VALUES ( 1, 'Bread', 1.99, 'Bread is good' )");
            stmt.execute("INSERT INTO Product VALUES ( 2, 'Salt', 4.99, 'Salt is good' )");
            stmt.execute("INSERT INTO Product VALUES ( 3, 'Bananas', 5.99, 'Bananas are good' )");
            stmt.execute("INSERT INTO Product VALUES ( 4, 'Apples', 1.99, 'Apples are good' )");
            stmt.execute("INSERT INTO Product VALUES ( 5, 'Steak', 9.99, 'Steak is good' )");
            stmt.execute("INSERT INTO Product VALUES ( 6, 'Grapes', 6.99, 'Grapes are good' )");
            stmt.execute("INSERT INTO Product VALUES ( 7, 'Carrots', 0.99, 'Carrots are good' )");
            stmt.execute("INSERT INTO Product VALUES ( 8, 'Pineapple', 5.55, 'Pineapple is good' )");

            System.out.println("Product table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildCartTable method creates the
     * Cart table and adds some rows to it.
     */
    public static void buildCartTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE CART" +
                    "( CustomerNumber INT NOT NULL PRIMARY KEY, " +
                    "  ProductNumber INT NOT NULL, " +
                    "  Name VARCHAR(50)," +
                    "  Date DATE," +
                    "  Price double ," +
                    " ");

            System.out.println("CART table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
        try {
            Statement stmt = conn.createStatement();
            // Add some rows to the new table.
            stmt.executeUpdate("INSERT INTO CART VALUES(101, 1, 'Bread', '10/18/2018', 1.99)");

            System.out.println("CART Table rows inserted.");
        } catch (SQLException ex)
        {
            System.out.println("CART INSERT ERROR: " + ex.getMessage());
        }
    }
}