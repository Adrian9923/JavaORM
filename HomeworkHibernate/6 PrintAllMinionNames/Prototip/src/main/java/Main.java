import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        List<String> minionNames = new ArrayList<>();

        System.out.print("Enter username default (root): ");
        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.print("Enter password default (empty): ");
        String password = sc.nextLine().trim();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db_access_to_jdbc", props);

        String sql = "SELECT name " +
                "FROM minions";
        PreparedStatement stmt = connection.prepareStatement
                (sql);

        ResultSet rs = stmt.executeQuery(sql);



        while (rs.next()) {

            minionNames.add(rs.getString("name"));
        }

        int n = minionNames.size();

        for (int i = 0; i < n / 2; i++) {
            System.out.println(minionNames.get(i));
            System.out.println(minionNames.get(n - i - 1));
        }
    }
}
