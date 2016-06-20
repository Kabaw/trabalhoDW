package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/* A responsabilidade da classe � instanciar o SessionFactory, que
 * cont�m todas configura��es do arquivo hibernate.cfg.xml
*/
public class HibernateUtil {
	
	private static SessionFactory buildSessionFactory() {
		try {
			// objeto que armazena configura��es do hibernate.cfg.xml
			Configuration configuration = new Configuration();

			// m�todo que l� e valida as configura��es em hibernate.cfg.xml
			configuration.configure();
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

			// aplica e carrega as configura��es no objeto serviceRegistry

			serviceRegistryBuilder.applySettings(configuration.getProperties());
			// objeto respons�vel pela configura��es do hibernate.cfg.xml
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			// cria uma ou mais inst�ncias de sess�o da configura��o.
			// Geralmente uma aplica��o tem uma �nica inst�ncia de sess�o e
			// threads servindo pedidos
			// de clientes obtendo inst�ncias da sess�o do factory (f�brica)
			// fabrica uma ou mais inst�ncia de sess�es de acesso ao banco a
			// partir da configura��es do objeto serviceRegistry
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
