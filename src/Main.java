import java.sql.*;

public class Main {
    public static void main(String[] args) {

        CreateProductDB db = new CreateProductDB();
        EventInterface ei = new Events();
        ei.outputDB();
        ei.addContent();
        ei.addProduct(11, "tomato soup", 99.99, "Good for eyesight");
        System.out.println("==========================");
        ei.outputDB();

    }

}
