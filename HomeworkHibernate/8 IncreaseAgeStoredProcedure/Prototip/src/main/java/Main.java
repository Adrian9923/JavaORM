import java.sql.*;
import java.util.*;

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

        String sql = "{CALL usp_get_older(?)}";
        /* MySql WorkBench usp:
        DELIMITER &&
                CREATE PROCEDURE `usp_get_older`(`minion_id` INT)
        BEGIN
        UPDATE `minions`
        SET `age` = `age` + 1
        WHERE `id` = `minion_id`;

        SELECT `name`, `age` FROM `minions`
        WHERE `id` = `minion_id`;

        END; &&

        CALL usp_get_older(1); && */
        CallableStatement stmt = connection.prepareCall(sql);


        String id = sc.nextLine();
        stmt.setInt(1, Integer.parseInt(id));
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.printf("%s %d", name, age);
        }
    }
}
