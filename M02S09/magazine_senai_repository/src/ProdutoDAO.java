import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Produto produto) {
        try {
            String sql = "INSERT INTO produtos (nome, descricao) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Ocorreu um erro ao tentar inserir produto. %s", e.getMessage()));
        }
    }
}
