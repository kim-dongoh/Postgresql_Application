import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class table {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static PreparedStatement pstmt;

    public void selectMenu (Connection connection) throws IOException, SQLException {
        while (true) {
            bw.write("\n1. Create Table   2. Delete Table   3. Exit\n");
            bw.flush();

            int select = Integer.parseInt(br.readLine());
            if (select == 1) {
                createTable(connection);
            } else if (select == 2) {
                deleteTable(connection);
            } else if (select == 3) {
                break;
            }
        }
    }

    private void createTable (Connection connection) throws IOException, SQLException {
        String TABLE_NAME;
        String sql = "";
        ArrayList<String> fields = new ArrayList<>();
        ArrayList<String> type = new ArrayList<>();
        int count=1;

        bw.write("\nInput your table name: ");
        bw.flush();
        TABLE_NAME = br.readLine();

        bw.write("\n(If you want to end, enter \"exit\".)\n");

        while (true) {
            bw.write("Field" + count + " name: ");
            bw.flush();
            fields.add(br.readLine());

            bw.write("Field" + count + " type: ");
            bw.flush();
            type.add(br.readLine());

            bw.write("\n");
            bw.flush();

            if (fields.get(count-1).equals("exit") || type.get(count-1).equals("exit")) {
                if (count == 1) {
                    break;
                } else {
                    pstmt = connection.prepareStatement("CREATE TABLE " + TABLE_NAME + "(" + sql + ")");
                    pstmt.executeUpdate();

                    bw.write("<Create Table " + TABLE_NAME + "!>\n\n");
                    bw.flush();
                    break;
                }
            } else if (count == 1) {
                sql = fields.get(count - 1) + " " + type.get(count - 1);
                count++;
            } else {
                sql = sql + "," + fields.get(count-1) + " " + type.get(count-1);
                count++;
            }
        }
    }

    private void deleteTable (Connection connection) throws IOException, SQLException {
        String TABLE_NAME;

        bw.write("Input your table name: ");
        bw.flush();
        TABLE_NAME = br.readLine();

        pstmt = connection.prepareStatement("DROP TABLE " + TABLE_NAME);
        pstmt.executeUpdate();

        bw.write("<Delete Table " + TABLE_NAME + "!>\n");
        bw.flush();
    }
}
