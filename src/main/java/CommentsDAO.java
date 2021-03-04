import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentsDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/skelbimu_portalas";
    private static final String PASS = "";
    private static final String USER = "root";

    public static void createNewTableComments(){
        String query = "CREATE TABLE IF NOT EXISTS Comments(" +
                "comment_id INT PRIMARY KEY AUTO_INCREMENT," +
                "user_id INT," +
                "advertisement_id INT," +
                "comment TEXT," +
                "FOREIGN KEY (user_id) REFERENCES User(user_id)," +
                "FOREIGN KEY (advertisement_id) REFERENCES Advertisements(advertisement_id))";

        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void createNewComment(Comments comments){
        String query ="INSERT INTO Comments(user_id, advertisement_id, comment) VALUES (?,?,?)";

        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,comments.getUserId());
            preparedStatement.setInt(2,comments.getAdvertisementId());
            preparedStatement.setString(3,comments.getComment());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateCommentById(int id, String comment){
        String query = "UPDATE Comments SET comment = ? WHERE comment_id = ?";

        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,comment);
            preparedStatement.setInt(2,id);

            preparedStatement.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
