import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) {
        try (Connection conn = CriaConexao.getConexao()) {
            Statement stm = conn.createStatement();
            stm.execute("INSERT INTO PRODUTOS (nome, descricao, preco) " +
                    "VALUES ('Curso Java', 'Curso introdutório de Java', 1000)",
                    Statement.RETURN_GENERATED_KEYS);

            ResultSet result = stm.getGeneratedKeys();

            while (result.next()) {
                System.out.println("ID inserido: " + result.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
