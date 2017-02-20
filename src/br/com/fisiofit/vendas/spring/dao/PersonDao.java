package br.com.fisiofit.vendas.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import br.com.fisiofit.vendas.spring.dao.interfaces.IPersonDao;
import br.com.fisiofit.vendas.spring.entity.Person;

@Repository("personDao")
public class PersonDao extends BasicDao implements IPersonDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listAll() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Person.class);
		return criteria.list();
	}

	@Override
	public void persist(Person entity) {
		// TODO Auto-generated method stub
		getSession().save(entity);
	}

	@Override
	public void update(Person entity) {
		// TODO Auto-generated method stub
		getSession().update(entity);
	}

}
