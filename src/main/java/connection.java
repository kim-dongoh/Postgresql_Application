import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static Connection connection;

    public void createConnection(String IP, String DB, String USER, String PASSWORD) {
        String URL = "jdbc:postgresql://" + IP + "/" + DB;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connect!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
