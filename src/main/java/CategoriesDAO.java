import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriesDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skelbimu_portalas";
    private static final String PASS = "";
    private static final String USER = "root";


    //created new table in database
    public static void createTableCategories() {
        String query = "CREATE TABLE IF NOT EXISTS Categories(" +
                "category_id INT PRIMARY KEY AUTO_INCREMENT," +
                "category_name VARCHAR(255))";
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //added new category record to database
    public static void createNewCategory(Categories categories) {
        String query = "INSERT INTO Categories(category_name) VALUES(?)";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, categories.getCategoryName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateCategoryById(int id, String category){
        String query = "UPDATE Categories SET category_name = ? WHERE category_id = ?";

        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,category);
            preparedStatement.setInt(2,id);

            preparedStatement.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
