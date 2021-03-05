import java.sql.*;
import java.util.ArrayList;

public class ActionsDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/skelbimu_portalas";
    private static final String PASS = "";
    private static final String USER = "root";


    public static void selectAdvertisementsById(int id) {

        String query = "SELECT User.first_name, advertisements.description FROM advertisements" +
                "                          JOIN User ON User.user_id = Advertisements.user_id " +
                "                          JOIN Categories ON Categories.category_id = Advertisements.category_id" +
                "                          WHERE user.user_id = ?";

        ArrayList<Advertisement> advertisements = new ArrayList<Advertisement>();
        Advertisement advertisement = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                do {
                    System.out.println("Name: " + resultSet.getString(1)
                            + " | Advertisement: " + resultSet.getString(2));

                } while (resultSet.next());
            } else {
                System.err.println("Theres are no record");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void selectCommentByAdId(int ad_id){
        String query = "SELECT advertisements.description, Comments.comment FROM Comments " +
                "                                   JOIN advertisements ON advertisements.advertisement_id = Comments.advertisement_id" +
                "                                   JOIN Categories ON Categories.category_id = advertisements.category_id " +
                "                                   WHERE advertisements.advertisement_id = ?";

        ArrayList<Advertisement> advertisements = new ArrayList<Advertisement>();
        Advertisement advertisement = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ad_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println();
            if (resultSet.next()) {
                do {
                    System.out.println("Advertisement: " + resultSet.getString(1)
                            + " | Comment: " + resultSet.getString(2));

                } while (resultSet.next());
            } else {
                System.err.println("Theres are no record");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
