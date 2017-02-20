package br.com.fisiofit.vendas.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe DAO base
 * 
 * @author nascimento
 *
 */
public abstract class BasicDao {

	/**
	 * Objeto fábrica
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Recuperar sessão atual
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Persiste entidade
	 * 
	 * @param entity
	 */
	public void persist(Object entity) {
		getSession().save(entity);
	}

	/**
	 * Atualiza entidade
	 * 
	 * @param entity
	 */
	public void update(Object entity) {
		getSession().update(entity);
	}

}
