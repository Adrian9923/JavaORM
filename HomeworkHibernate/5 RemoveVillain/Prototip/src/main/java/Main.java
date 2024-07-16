import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> townMinionsMap = new LinkedHashMap<>();

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
                "WHERE v.id = ? " +
                "GROUP BY mv.villain_id " +
                "ORDER BY count_minions DESC;";
        PreparedStatement stmt = connection.prepareStatement
                (sql);

        String id = sc.nextLine();
        stmt.setInt(1, Integer.parseInt(id));
        ResultSet rs = stmt.executeQuery();


        if (!rs.isBeforeFirst()){
            System.out.println("No such villain was found");
        }else {
            while (rs.next()) {

                String villainName = rs.getString("v.name");
                int minionsReleased = rs.getInt("count_minions");

                System.out.printf("%s has deleted\n", villainName);
                System.out.printf("%d minions released", minionsReleased);
            }
        }


    }
}
