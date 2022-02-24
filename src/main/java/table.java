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
    private static ResultSet rs;

    public void selectMenu (Connection connection) throws IOException, SQLException {
        while (true) {
            bw.write("\n1. Create Table   2. Select Table   3. Delete Table   4. Exit\n");
            bw.flush();

            int select = Integer.parseInt(br.readLine());
            if (select == 1) {
                createTable(connection);
            } else if (select == 2) {
                
            } else if (select == 3) {

            } else if (select == 4) {
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

        bw.write("\nIf you want to end, enter \"exit\".\n");

        while (true) {
            bw.write("Field" + count + " name: ");
            bw.flush();
            fields.add(br.readLine());

            bw.write("Field" + count + " type: ");
            bw.flush();
            type.add(br.readLine());

            bw.write("\n");
            bw.flush();

            if (fields.get(count-1).equals("exit") || type.get(count-1).equals("exit")) {  //
                if (count == 1) {
                    break;
                } else {
                    pstmt = connection.prepareStatement("CREATE TABLE " + TABLE_NAME + "(" + sql + ")");
                    pstmt.executeUpdate();

                    bw.write("Create Table " + TABLE_NAME + "!\n\n");
                    bw.flush();
                    break;
                }
            } else if (count == 1/* && (!fields.get(0).equals("exit") || !type.get(0).equals("exit"))*/) {     //처음 field가 추가 될 때, 입력값이 exit 가 아닌 경우
                sql = fields.get(count - 1) + " " + type.get(count - 1);
                count++;
            } else {
                sql = sql + "," + fields.get(count-1) + " " + type.get(count-1);
                count++;
            }
        }
    }
}
