import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Getter
@Setter

public class DBConnection {
    private final String url = "jdbc:postgresql://localhost:5432/product_management_db";
    private final String user =  "product_manager_user";
    private final String password = "123456";

     public Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }



}
