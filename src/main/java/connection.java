import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static Connection connection;
    private static String IP;
    private static String PORT;
    private static String DB;
    private static String USER;
    private static String PASSWORD;

    public void createConnection() throws IOException {
        while (true) {
            bw.write("Enter IP: ");
            bw.flush();
            IP = br.readLine();

            bw.write("Enter PORT: ");
            bw.flush();
            PORT = br.readLine();

            bw.write("Enter DB: ");
            bw.flush();
            DB = br.readLine();

            bw.write("Enter USER: ");
            bw.flush();
            USER = br.readLine();

            bw.write("Enter PASSWORD: ");
            bw.flush();
            PASSWORD = br.readLine();

            try {
                String URL = "jdbc:postgresql://" + IP + ":" + PORT + "/" + DB;
                connection = DriverManager.getConnection(URL, USER, PASSWORD);

                bw.write("Connect!\n");
                bw.flush();


                break;
            } catch (SQLException | IOException e) {
                bw.write("Error!\n");
                bw.flush();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
