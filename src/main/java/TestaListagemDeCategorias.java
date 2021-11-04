import dao.CategoriaDAO;
import dao.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionFactory().recuperarConexao();

        CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
        List<Categoria> listaDeCategoria = categoriaDAO.listar();
        listaDeCategoria.stream().forEach(ct -> {
            System.out.println(ct.getNome());
            try {
                for (Produto produto : new ProdutoDAO(connection).buscar(ct)) {
                    System.out.println(ct.getNome() + " - " + produto.getNome());
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}
