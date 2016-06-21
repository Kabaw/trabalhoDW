package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Jogo;
import util.HibernateUtil;

public class JogoDAO {
	private Session sessao;
	private Transaction transacao;
	/*
	 * Objetivo: Método que salva um usuario no banco de dados
	 */
	public void salvar(Jogo jogo) {
		sessao = null;
		transacao = null;
		try {
			// abre um sessão com o banco de dados.
			sessao = HibernateUtil.getSessionFactory().openSession();
			// inicia um transacao
			transacao = sessao.beginTransaction();
			// salva o usuário
			sessao.saveOrUpdate(jogo);
			// confirma a transacao
			transacao.commit();
		} catch (HibernateException e) {
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
}
