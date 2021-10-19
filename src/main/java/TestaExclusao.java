import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaExclusao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        statement.setInt(1, 2);
        statement.execute();

        Integer linhasModificadas = statement.getUpdateCount();
        System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
    }
}
