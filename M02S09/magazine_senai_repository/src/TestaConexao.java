import java.sql.*;

public class TestaConexao {
    public static void main(String[] args) {

        try (Connection connection = CriaConexao.getConexao()) {
            //System.out.println(connection.getSchema());
            Statement stm = connection.createStatement();
            boolean ehSelect = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTOS");
            //boolean ehSelect =  stm.execute("UPDATE PRODUTOS SET NOME = 'LIVRO DE JAVA' WHERE ID = 1");
            System.out.println("o comando executado foi um select? " + ehSelect);

            if (ehSelect) {
                ResultSet result = stm.getResultSet();
                while (result.next()) {
                    int id = result.getInt("ID");
                    String nome = result.getString("NOME");
                    String descricao = result.getString("DESCRICAO");

                    System.out.printf("ID: %d, Nome: %s, Descrição: %s.%n", id, nome, descricao);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um problema ao conectar com o BD." + e.getMessage());
        }
    }
}
