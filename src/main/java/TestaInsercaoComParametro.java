import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
               ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();
        connection.setAutoCommit(false);

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            adicionarVariavel("SmartTV", "45 polegadas", statement);
            adicionarVariavel("Radio", "Radio de bateria", statement);

            connection.commit();

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ROLLBACK EXECUTADO");
            connection.rollback();
        }

    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement) throws SQLException {
        statement.setString(1, nome);
        statement.setString(2, descricao);


        if(nome.equals("Radio")){
            throw new RuntimeException("Não foi possivel adicionar o produto");
        }

        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();

        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado é: " + id);
        }
    }
}
