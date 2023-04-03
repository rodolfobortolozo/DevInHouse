import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaExclusao {
    public static void main(String[] args) {
        try (Connection conn = CriaConexao.getConexao()) {
            Statement stm = conn.createStatement();

            stm.execute("DELETE FROM PRODUTOS WHERE ID > 5");

            int linhasModificadas = stm.getUpdateCount();
            System.out.println("Registros alterados: " + linhasModificadas);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
