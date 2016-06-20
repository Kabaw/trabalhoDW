package dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.Usuario;
import util.HibernateUtil;
import util.Utils;

/*
 * Classe responsável por realizar as operações CRUD no objeto Usuario
 * 
 */
public class UsuarioDAO {
	private Session sessao;
	private Transaction transacao;

	/*
	 * Método que salva um usuário no banco de dados
	 */
	public void salvar(Usuario usuario) {
		sessao = null;
		transacao = null;
		try {
			// abre um sessão com o banco de dados.
			sessao = HibernateUtil.getSessionFactory().openSession();
			// inicia um transacao
			transacao = sessao.beginTransaction();
			usuario.setSenha(Utils.geraMD5(usuario.getSenha()));
			usuario.setLogin(usuario.getLogin().trim());
			// salva o usuário
			sessao.saveOrUpdate(usuario);
			// confirma a transacao
			transacao.commit();
		} catch (HibernateException | NoSuchAlgorithmException e) {
			throw new ExceptionInInitializerError("Não foi possível inserir um usuario. Erro:" + e.getMessage());
		} finally {
			try {
				// fecha a sessao com o banco de dados
				sessao.close();
			} catch (Throwable e) {
				throw new ExceptionInInitializerError("Erro ao fechar a operacao de usuario. Erro:" + e.getMessage());
			}
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 *
	 * @return List<Usuario>
	 *
	 *         Método retorna uma lista de usuarios
	 */
	public List<Usuario> listar() {
		sessao = null;
		transacao = null;
		List<Usuario> resultado = null;
		try {
			// Abre uma sessao no banco de dados
			sessao = HibernateUtil.getSessionFactory().openSession();
			// Inicia uma transacao
			transacao = sessao.beginTransaction();
			Criteria criteria = sessao.createCriteria(Usuario.class);

			// Retorna lista de contatos
			resultado = criteria.list();
			// Confirma a transacao
			transacao.commit();
			// retona a lista de usuarios
			return resultado;
		} catch (HibernateException e) {
			throw new ExceptionInInitializerError("Não foi possível selecionar os usuarios. Erro:" + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				throw new ExceptionInInitializerError("Erro ao fechar a operação consulta. Erro:" + e.getMessage());
			}
		}
	}

	public Usuario login(Usuario usuario){
		sessao = null;
		transacao = null;
		Usuario retorno = null;
		try{
			// Abre uma sessao no banco de dados
			sessao = HibernateUtil.getSessionFactory().openSession();
			// Inicia uma transacao
			transacao = sessao.beginTransaction();
			
			Criteria criteria = sessao.createCriteria(Usuario.class);
			criteria.add(Restrictions.and(Restrictions.eq("login", usuario.getLogin()),
					Restrictions.eq("senha", Utils.geraMD5(usuario.getSenha()))));
			
			retorno = (Usuario) criteria.uniqueResult();
			transacao.commit();
			return retorno;
		}catch (HibernateException | NoSuchAlgorithmException e) {
			throw new ExceptionInInitializerError("Não foi possível selecionar os usuarios. Erro:" + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				throw new ExceptionInInitializerError("Erro ao fechar a operação consulta. Erro:" + e.getMessage());
			}
		}
	}
	
	public Usuario buscarPorLogin(String login){
		sessao = null;
		transacao = null;
		Usuario retorno = null;
		try{
			// Abre uma sessao no banco de dados
			sessao = HibernateUtil.getSessionFactory().openSession();
			// Inicia uma transacao
			transacao = sessao.beginTransaction();
			
			Criteria criteria = sessao.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("login", login));
			
			retorno = (Usuario) criteria.uniqueResult();
			transacao.commit();
			return retorno;
		}catch (HibernateException  e) {
			throw new ExceptionInInitializerError("Não foi possível selecionar os usuarios. Erro:" + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				throw new ExceptionInInitializerError("Erro ao fechar a operação consulta. Erro:" + e.getMessage());
			}
		}
	}
}