package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaSQL {
	public static Connection geraConexao() {
		Connection conexao = null;
		try {
			// carrega o drive de comunicação com o banco de dados
			Class.forName("org.postgresql.Driver");
			// Não esqueca de mudar o usuario e senha do banco de dados.
			String url = "jdbc:postgresql://localhost:5432/trabalho";
			String usuario = "postgres";
			String senha = "daixz";
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException("Ocorreu um erro de SQL. Erro: " + e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return conexao;
	}
}
