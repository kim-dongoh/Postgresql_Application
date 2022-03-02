import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class data {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static PreparedStatement pstmt;
    private static ResultSet rs;

    public void selectMenu (Connection connection) throws IOException, SQLException {
        while (true) {
            bw.write("\n1. Insert Data   2. Update Data   3. Delete Data   4. Exit\n");
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

    private void insertData (Connection connection) throws IOException, SQLException {
        String TABLE_NAME;
        String sql;
        StringTokenizer token;
        ArrayList<String> data = new ArrayList<>();
        ArrayList<String> type = new ArrayList<>();
        int count = 1;

        bw.write("\nInput your table name: ");
        bw.flush();
        TABLE_NAME = br.readLine();

        //테이블 칼럼 정보 호출
        bw.write("\nTable " + TABLE_NAME + "'s column Information\n");
        bw.flush();

        sql = "SELECT column_name, udt_name, character_maximum_length FROM information_schema.columns WHERE table_name = '" + TABLE_NAME + "';";

        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            bw.write(rs.getString(1) + " " + rs.getString(2) + "(" + rs.getString(3) + ")" + "   ");
            bw.flush();

            type.add(rs.getString(2));
            count++;
        }
        bw.write("\n\n");
        bw.flush();

        while (true) {
            bw.write("(If you want to end, enter \"exit\".)\nInput your data (Data split by \"Space\")\n");
            bw.flush();
            //Input할 Data를 입력받는 부분
            token = new StringTokenizer(br.readLine());
            while (token.hasMoreTokens()) {
                data.add(token.nextToken());
            }


            ////이 부분 ㅈㄴ 이해안가고 이상함.
            if (data.get(count).equals("exit")) {
                data.clear();
                rs.close();
                pstmt.close();
                break;
            }



            pstmt = connection.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?)");

            pstmt.setString(1, data.get(0));
            pstmt.setString(2, data.get(1));
            pstmt.setString(3, data.get(2));
            pstmt.setString(4, data.get(3));

            pstmt.executeUpdate();

            bw.write("The data has been entered!\n\n");
            bw.flush();

            data.clear();
            rs.close();
            pstmt.close();
        }

    }
    private void updatetData (Connection connection) {
        String  TABLE_NAME;
    }
    private void deleteData (Connection connection) {
        String  TABLE_NAME;
    }
}
