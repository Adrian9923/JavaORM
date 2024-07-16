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

        String sql = "SELECT name " +
                "FROM towns " +
                "WHERE country = ?;";
        PreparedStatement stmt = connection.prepareStatement
                (sql);

        String country = sc.nextLine();
        stmt.setString(1, country);
        ResultSet rs = stmt.executeQuery();


        if (!rs.isBeforeFirst()){
            System.out.println("No town names were affected.");
        }else {
            while (rs.next()) {

                String townName = rs.getString("name");

                if (!townMinionsMap.containsKey(country)) {
                    townMinionsMap.put(country, new ArrayList<>());
                    townMinionsMap.get(country).add(townName);
                } else {
                    townMinionsMap.get(country).add(townName);
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : townMinionsMap.entrySet()) {
            List<String> townsList = entry.getValue();


            System.out.printf("%d town names were affected\n", townsList.size());
            for (String town : townsList) {
                System.out.printf("%s ", town.toUpperCase());
            }

        }

    }
}
