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
                updatetData(connection);
            } else if (select == 3) {
                deleteData(connection);
            } else if (select == 4) {
                break;
            }
        }
    }

    private void insertData (Connection connection) throws IOException {
        bw.write("\nInput your table name: ");
        bw.flush();
        String TABLE_NAME = br.readLine();

        //테이블 칼럼명 호출
        String sql = "SELECT column_name FROM information_schema.columns WHERE table_name = ' "+ TABLE_NAME +"';";
        String sql2 = "SELECT udt_name FROM information_schema.columns WHERE table_name = ' "+ TABLE_NAME +"';";
        String sql3 = "SELECT character_maximum_length FROM information_schema.columns WHERE table_name = ' "+ TABLE_NAME +"';";
    }
    private void updatetData (Connection connection) {
        String  TABLE_NAME;
    }
    private void deleteData (Connection connection) {
        String  TABLE_NAME;
    }
}
