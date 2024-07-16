import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        List<String> minionNames = new ArrayList<>();
        List<Integer> minionAges = new ArrayList<>();

        System.out.print("Enter username default (root): ");
        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.print("Enter password default (empty): ");
        String password = sc.nextLine().trim();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db_access_to_jdbc", props);

        String sql = "UPDATE minions " +
                "SET age = age + 1, name = LOWER(name) " +
                "WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);


        int[] ids = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int id : ids) {
            stmt.setInt(1, id);
            stmt.addBatch();
        }


        int[] updatedRows = stmt.executeBatch();

        stmt.close();

        sql = "SELECT name, age FROM minions";
        Statement selectStmt = connection.createStatement();
        ResultSet rs = selectStmt.executeQuery(sql);

        while (rs.next()) {
            minionNames.add(rs.getString("name"));
            minionAges.add(rs.getInt("age"));
        }

        selectStmt.close();
        connection.close();

        int n = minionNames.size();

        for (int i = 0; i < n; i++) {
            System.out.print(minionNames.get(i) + " ");
            System.out.println(minionAges.get(i));
        }
    }
}
