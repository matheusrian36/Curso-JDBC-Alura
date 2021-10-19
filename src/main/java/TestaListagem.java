import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement statement = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

        statement.execute();

        ResultSet resultSet = statement.getResultSet();

        while(resultSet.next()){
            Integer id = resultSet.getInt("ID");
            String nome = resultSet.getString("NOME");
            String descricao = resultSet.getString("DESCRICAO");

            System.out.println("Id: " + id + " Nome: " + nome + " Descrição: " + descricao);
        }

        connection.close();
    }
}
