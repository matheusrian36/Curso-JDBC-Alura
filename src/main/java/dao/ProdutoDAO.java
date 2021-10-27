package dao;

import modelo.Produto;

import java.sql.*;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection){
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());

            statement.execute();

            try(ResultSet resultSet = statement.getGeneratedKeys()){
                while(resultSet.next()){
                    produto.setId(resultSet.getInt(1));
                }
            }
        }
    }
}
