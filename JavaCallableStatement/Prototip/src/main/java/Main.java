import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username default (root): ");
        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.print("Enter password default (empty): ");
        String password = sc.nextLine().trim();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo_access_to_jdbc", props);


        String sql = "{CALL udp_user_games(?)}";
        CallableStatement stmt = connection.prepareCall(sql);


        String username = sc.nextLine();
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (!rs.isBeforeFirst()){
            System.out.println("No such user exists");
        }else {
            while (rs.next()) {
                System.out.printf("%s has played %s games%n",
                        rs.getString("full_name"),
                        rs.getInt("count_played_games"));

            }
        }
    }
}
