import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {

    private final static String url = "jdbc:oracle:thin:@localhost:1521/dihphilips";
    private final static String user = "admin";
    private final static String password = "root";

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
