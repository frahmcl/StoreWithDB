import java.util.List;

public interface ProductDao<T> {
    List<T> getAll();

}
