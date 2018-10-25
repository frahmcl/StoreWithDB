import java.sql.*;
import java.util.List;

public class Events implements EventInterface {

    @Override
    public List<EventBean> getAllEvents() {return null;}


    public void addContent() {
        final String DB_URL = "jdbc:derby:ProductDB";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO Product " +
                    "VALUES (9, 'Peanuts', 13.75, 'fresh peanuts are good for you'";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
            //Clean-up environment
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }


    public void outputDB() {
        final String DB_URL = "jdbc:derby:ProductDB";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, productName, price, description FROM Product";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                String description = rs.getString("Description");

                //Display values
                System.out.print("ID: " + id);
                System.out.print("Product: " + productName);
                System.out.print(", Price: " + price);
                System.out.println(", Description: " + description);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    @Override
    public void addProduct(int id, String productName, double price, String description) {
        Statement stmt;
        Connection conn = null;
        final String DB_URL = "jdbc:derby:ProductDB";
        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO Product VALUES ( id, productName, price, description )");
            System.out.println("Product added");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
