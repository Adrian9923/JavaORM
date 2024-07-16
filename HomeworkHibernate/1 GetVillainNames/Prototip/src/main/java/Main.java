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

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db_access_to_jdbc", props);


        String sql = "SELECT v.name, COUNT(mv.minion_id) AS count_minions " +
                "FROM villains AS v " +
                "JOIN minions_villains AS mv ON mv.villain_id = v.id " +
                "JOIN minions AS m ON m.id = mv.minion_id " +
                "GROUP BY mv.villain_id " +
                "HAVING count_minions > 15 " +
                "ORDER BY count_minions DESC;";
        Statement stmt = connection.createStatement();



        ResultSet rs = stmt.executeQuery(sql);


        while (rs.next()) {
            System.out.printf("%s %s%n",
                    rs.getString("v.name"),
                    rs.getInt("count_minions"));

            }

    }
}
