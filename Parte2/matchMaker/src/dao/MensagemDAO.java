package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Mensagem;
import util.HibernateUtil;

public class MensagemDAO {
	private Session sessao;
	private Transaction transacao;
	
	public void salvar(Mensagem mensagem){
		sessao = null;
		transacao = null;
		try {
			// abre um sessão com o banco de dados.
			sessao = HibernateUtil.getSessionFactory().openSession();
			// inicia um transacao
			transacao = sessao.beginTransaction();
			// salva o usuário
			sessao.saveOrUpdate(mensagem);
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
