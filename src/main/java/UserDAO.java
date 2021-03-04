import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/skelbimu_portalas";
    private static final String PASS = "";
    private static final String USER = "root";


    //created new table in database
    public static void createTableUser() {
        String query = "CREATE TABLE IF NOT EXISTS User(" +
                "user_id INT PRIMARY KEY AUTO_INCREMENT," +
                "first_name VARCHAR(255)," +
                "last_name varchar(255)" +
                ")";
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //added new user record to database
    public static void createNewUser(User user) {
        String query = "INSERT INTO User(first_name, last_name) VALUES(?,?)";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUserById(int id, String firstname, String lastname){
        String query = "UPDATE User SET first_name = ?, last_name = ? WHERE user_id = ?";
        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,firstname);
            preparedStatement.setString(2,lastname);
            preparedStatement.setInt(3,id);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
