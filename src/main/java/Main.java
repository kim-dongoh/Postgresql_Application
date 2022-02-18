import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        connection connection = new connection();
        Scanner scanner = new Scanner(System.in);

        String IP;
        String DB;
        String USER;
        String PASSWORD;

        //Postgresql Connection
        while (true) {
            while (true) {
                System.out.print("Enter IP: ");
                IP = scanner.nextLine();

                if (!IP.isEmpty()) {
                    break;
                }
            }

            while (true) {
                System.out.print("Enter DB: ");
                DB = scanner.nextLine();

                if (!DB.isEmpty()) {
                    break;
                }
            }

            while (true) {
                System.out.print("Enter USER: ");
                USER = scanner.nextLine();

                if (!USER.isEmpty()) {
                    break;
                }
            }

            while (true) {
                System.out.print("Enter PASSWORD: ");
                PASSWORD = scanner.nextLine();

                if (!PASSWORD.isEmpty()) {
                    break;
                }
            }

            connection.createConnection(IP, DB, USER, PASSWORD);
            break;
        }
    }
}
