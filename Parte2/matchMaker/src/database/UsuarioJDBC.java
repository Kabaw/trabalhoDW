package database;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import model.Usuario;
import util.Utils;

public class UsuarioJDBC {
	/*
	 * Objetivo: Método que salva um usuario no banco de dados
	 */
	public void salvar(Usuario usuario) {
		Connection conexao = ConectaSQL.geraConexao();
		// Objeto para executar o SQL insert
		PreparedStatement insereSt = null;
		// SQL de inserção
		String sql = "insert into usuario(nome,sobrenome,email,sexo,dataNascimento,login,senha) values(?,?,?,?,?,?,?)";
		try {
			System.out.println(usuario.getDataNascimento());
			// recebe o SQL insert
			insereSt = conexao.prepareStatement(sql);
			// recebe o parâmtros do SQL insert
			insereSt.setString(1, usuario.getNome());
			insereSt.setString(2, usuario.getSobrenome());
			insereSt.setString(3, usuario.getEmail());
			insereSt.setString(4, usuario.getSexo());
			insereSt.setTimestamp(5, new Timestamp(usuario.getDataNascimento().getTime()));
			insereSt.setString(6, usuario.getLogin());
			insereSt.setString(7, Utils.geraMD5(usuario.getSenha()));
			// executa SQL insert
			insereSt.executeUpdate();
		} catch (SQLException | NoSuchAlgorithmException e) {
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

	public Usuario login(Usuario usuario) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		Usuario retorno = null;
		
		
		try {
			String sql = "select * from usuario where login = '" + usuario.getLogin().trim() + "' and senha='"+Utils.geraMD5(usuario.getSenha())+"'";
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			
			// Usuario
			resultado = consulta.executeQuery(sql);
			// Lê cada usuario
			while (resultado.next()) {
				retorno = new Usuario();
				retorno.setId(resultado.getLong("id"));
				retorno.setNome(resultado.getString("nome"));
				retorno.setDataNascimento(resultado.getTimestamp("datanascimento"));
				retorno.setSenha(resultado.getString("senha"));
				retorno.setLogin(resultado.getString("login"));
				retorno.setEmail(resultado.getString("email"));
				retorno.setSexo(resultado.getString("sexo"));
				retorno.setSobrenome(resultado.getString("sobrenome"));
				
				
				break;
			}
			consulta.close();
			resultado.close();
			conexao.close();
			return retorno;
		} catch (SQLException | NoSuchAlgorithmException e) {
			throw new RuntimeException("Erro ao buscar um usuario: " + e);
		}
		
	}
	
	public Usuario buscarPorLogin(String login) {
		// abre conexao com o banco de dados
		Connection conexao = ConectaSQL.geraConexao();
		// executa o SQL no banco de dados
		Statement consulta = null;
		// contém os dados consultado da tabela
		ResultSet resultado = null;
		Usuario retorno = null;
		
		
		try {
			String sql = "select * from usuario where login = '" + login.trim() + "'";
			// consulta => objeto que executa o SQL no banco de dados
			consulta = conexao.createStatement();
			
			// Usuario
			resultado = consulta.executeQuery(sql);
			// Lê cada usuario
			while (resultado.next()) {
				retorno = new Usuario();
				retorno.setId(resultado.getLong("id"));
				retorno.setNome(resultado.getString("nome"));
				retorno.setDataNascimento(resultado.getTimestamp("datanascimento"));
				retorno.setSenha(resultado.getString("senha"));
				retorno.setLogin(resultado.getString("login"));
				retorno.setEmail(resultado.getString("email"));
				retorno.setSexo(resultado.getString("sexo"));
				retorno.setSobrenome(resultado.getString("sobrenome"));
				
				
				break;
			}
			consulta.close();
			resultado.close();
			conexao.close();
			return retorno;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar um usuario: " + e);
		}
		
	}
}
