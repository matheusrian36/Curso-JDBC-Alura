import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse sem fio')", statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();

        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado é: " + id);
        }
    }
}
