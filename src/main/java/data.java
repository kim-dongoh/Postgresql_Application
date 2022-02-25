import java.io.*;
import java.sql.Connection;

public class data {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void selectMenu (Connection connection) throws IOException {
        while (true) {
            bw.write("\n1. Insert Data   2. Update Data   3. Delete Data   4. Exit");
            bw.flush();

            int select = Integer.parseInt(br.readLine());
            if (select == 1) {
                insertData(connection);
            } else if (select == 2) {

            } else if (select == 3) {

            } else if (select == 4) {
                break;
            }
        }
    }

    private void insertData (Connection connection) {
        String  TABLE_NAME;
    }
}
