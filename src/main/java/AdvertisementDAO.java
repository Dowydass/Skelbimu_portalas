import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdvertisementDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/skelbimu_portalas";
    private static final String PASS = "";
    private static final String USER = "root";

    public static void createNewTableAdvertisement(){
        String query = "CREATE TABLE IF NOT EXISTS Advertisements(" +
                "advertisemet_id INT PRIMARY KEY AUTO_INCREMENT," +
                "category_id INT," +
                "user_id INT," +
                "description TEXT," +
                "FOREIGN KEY (category_id) REFERENCES Categories(category_id)," +
                "FOREIGN KEY (user_id) REFERENCES User(user_id)" +
                ")";
        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void createNewAdvertisement(Advertisement advertisement){
            String query = "INSERT INTO Advertisements(category_id, user_id, description) VALUES (?,?,?)";
        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1,advertisement.getCategoryId());
            preparedStatement.setInt(2,advertisement.getUserId());
            preparedStatement.setString(3,advertisement.getDescription());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
