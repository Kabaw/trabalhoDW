package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/* A responsabilidade da classe é instanciar o SessionFactory, que
 * contém todas configuraçÕes do arquivo hibernate.cfg.xml
*/
public class HibernateUtil {
	
	private static SessionFactory buildSessionFactory() {
		try {
			// objeto que armazena configurações do hibernate.cfg.xml
			Configuration configuration = new Configuration();

			// método que lê e valida as configurações em hibernate.cfg.xml
			configuration.configure();
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

			// aplica e carrega as configurações no objeto serviceRegistry

			serviceRegistryBuilder.applySettings(configuration.getProperties());
			// objeto responsável pela configurações do hibernate.cfg.xml
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			// cria uma ou mais instâncias de sessão da configuração.
			// Geralmente uma aplicação tem uma única instância de sessão e
			// threads servindo pedidos
			// de clientes obtendo instâncias da sessão do factory (fábrica)
			// fabrica uma ou mais instância de sessões de acesso ao banco a
			// partir da configurações do objeto serviceRegistry
			return configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable e) {
			throw new ExceptionInInitializerError("Criacao do objeto falhou: " + e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return buildSessionFactory();
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
