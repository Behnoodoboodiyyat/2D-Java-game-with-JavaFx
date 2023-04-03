package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mySQL {
    String URL = "jdbc:mysql://localhost:3306/game";
    String Username = "root";
    String Password = "behnood4228";

    public void executeSQL(String sqlCommand) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, Username, Password);

            Statement statement = connection.prepareStatement(sqlCommand);
            statement.execute(sqlCommand);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sqlCommand) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, Username, Password);

            Statement statement = connection.prepareStatement(sqlCommand);
            ResultSet resultSet = statement.executeQuery(sqlCommand);

            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
