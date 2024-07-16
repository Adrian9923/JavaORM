import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> villainMinionsMap = new LinkedHashMap<>();

        System.out.print("Enter username default (root): ");
        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.print("Enter password default (empty): ");
        String password = sc.nextLine().trim();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db_access_to_jdbc", props);

        String sql = "SELECT v.name, m.name, m.age " +
                "FROM villains AS v " +
                "JOIN minions_villains AS mv ON mv.villain_id = v.id " +
                "JOIN minions AS m ON m.id = mv.minion_id " +
                "WHERE v.id = ?;";
        PreparedStatement stmt = connection.prepareStatement
                (sql);

        String id = sc.nextLine();
        stmt.setInt(1, Integer.parseInt(id));
        ResultSet rs = stmt.executeQuery();


        if (!rs.isBeforeFirst()){
            System.out.printf("No villain with ID %s exists in the database.",id);
        }else {
            while (rs.next()) {

                String villainName = rs.getString("v.name");
                String minionName = rs.getString("m.name");
                int minionAge = rs.getInt("m.age");

                if (!villainMinionsMap.containsKey(villainName)) {
                    villainMinionsMap.put(villainName, new ArrayList<>());
                    villainMinionsMap.get(villainName).add(minionName + " " + minionAge);
                } else {
                    villainMinionsMap.get(villainName).add(minionName + " " + minionAge);
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : villainMinionsMap.entrySet()) {
            String villainName = entry.getKey();
            List<String> minionsList = entry.getValue();
            System.out.println("Villain: " + villainName);

            int counter = 1;
            for (String minion : minionsList) {
                System.out.printf("%d. %s\n",counter, minion);
                counter++;
            }

        }

    }
}
