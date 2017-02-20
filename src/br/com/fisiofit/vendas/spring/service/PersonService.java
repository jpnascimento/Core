package br.com.fisiofit.vendas.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fisiofit.vendas.spring.dao.interfaces.IPersonDao;
import br.com.fisiofit.vendas.spring.entity.Person;
import br.com.fisiofit.vendas.spring.service.interfaces.IPersonService;

@Service("personService")
@Transactional
public class PersonService implements IPersonService {

	@Autowired
	private IPersonDao personDao;

	@Override
	public void save(Person entity) {
		// TODO Auto-generated method stub
		personDao.persist(entity);
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return personDao.listAll();
	}

}
