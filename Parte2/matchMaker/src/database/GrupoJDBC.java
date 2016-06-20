package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Grupo;

public class GrupoJDBC {
	/*
	 * Objetivo: M�todo que salva um usuario no banco de dados
	 */
	public void salvar(Grupo grupo) {
		Connection conexao = ConectaSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inser��o
		String sql = "insert into grupo(nome) values(?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o par�mtros do SQL insert
			insereSt.setString(1, grupo.getNome());
			// executa SQL insert
			insereSt.executeUpdate();
		} catch (SQLException  e) {
			throw new RuntimeException("Erro ao incluir cliente. mensagem:" + e);
		} finally {
			try {
				// fecha conexao com o banco
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				throw new RuntimeException("Erro ao fechar a opera��o de inser��o" + e);
			}
		}
	}
}
