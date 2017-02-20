package br.com.fisiofit.vendas.spring.dao.interfaces;

import java.util.List;

import br.com.fisiofit.vendas.spring.entity.Person;

public interface IPersonDao {

	/**
	 * Lista todas as entidades persistidas
	 * 
	 * @param id
	 * @return
	 */
	List<Person> listAll();

	/**
	 * Persiste entidade
	 * 
	 * @param entity
	 */
	void persist(Person entity);

	/**
	 * Atualiza entidade
	 * 
	 * @param entity
	 */
	void update(Person entity);

}
