import java.sql.Connection;

public class ProdutoService {
    private ProdutoDAO dao;

    public ProdutoService(ProdutoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Produto produto) {
        this.dao.cadastrar(produto);
    }
}
