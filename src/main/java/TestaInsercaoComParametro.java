import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        String nome = "";
        String descricao = "";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, nome);
        statement.setString(2, descricao);

        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();

        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado é: " + id);
        }
    }
}
