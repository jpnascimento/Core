package br.com.fisiofit.vendas.spring.service.interfaces;

import java.util.List;

import br.com.fisiofit.vendas.spring.entity.Person;

public interface IPersonService {

	void save(Person entity);
	
	List<Person> list();
}
