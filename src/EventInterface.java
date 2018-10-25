import java.util.List;

public interface EventInterface {
    List<EventBean> getAllEvents();
    void addContent();
    void outputDB();
    void addProduct(int id, String productName, double price, String description);
}
