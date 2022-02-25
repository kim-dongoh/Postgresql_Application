import java.io.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        connection connection = new connection();
        table table = new table();
        data data = new data();


        connection.createConnection();

        while (true) {
            bw.write("\n1. Table   2. Data   3. Exit\n");
            bw.flush();

            int select = Integer.parseInt(br.readLine());
            if (select == 1) {
                table.selectMenu(connection.getConnection());
            } else if (select == 2) {
                data.selectMenu(connection.getConnection());
            } else if (select == 3) {
                break;
            }
        }

        bw.close();
    }
}
