package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Jogo;

public class JogoDAO {
	/*
	 * Objetivo: Método que salva um usuario no banco de dados
	 */
	public void salvar(Jogo jogo) {
		Connection conexao = ConectaSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into grupo(nome) values(?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setString(1, jogo.getNome());
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
				throw new RuntimeException("Erro ao fechar a operação de inserção" + e);
			}
		}
	}
}
