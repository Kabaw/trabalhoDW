package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Mensagem;

public class MensagemDAO {
	public void salvar(Mensagem mensagem){
		Connection conexao = ConectaSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into mensagem(conteudo,remetente,destinatario,dataMensagem,titulo) values(?,?,?,?,?)";
		try {
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setString(1, mensagem.getConteudo());
			insereSt.setInt(2, mensagem.getRemetente().getIdUsuario().intValue());
			insereSt.setInt(3, mensagem.getDestinatario().getIdUsuario().intValue());
			insereSt.setTimestamp(4, new Timestamp(mensagem.getDataMensagem().getTime()));
			insereSt.setString(5, mensagem.getTitulo());
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
