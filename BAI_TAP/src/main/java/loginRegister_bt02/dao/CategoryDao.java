package loginRegister_bt02.dao;
import java.util.List;
import loginRegister_bt02.model.Category;

public interface CategoryDao {
    void insert(Category category);
    void update(Category category);
    void delete(int id);
    Category findById(int id);
    List<Category> findAll();
}
