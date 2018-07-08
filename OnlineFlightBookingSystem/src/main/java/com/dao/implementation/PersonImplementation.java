package com.dao.implementation;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PersonDAO;
import com.model.Person;

@Repository
@Transactional
public class PersonImplementation implements PersonDAO   {

	@Autowired
	private SessionFactory factory;

	public boolean addPerson(Person person) {
		Session session = factory.getCurrentSession();
		try {
			System.out.println("dwasfwfd");
			session.save(person);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	public boolean modifyPersonDetails(Person person) {
		Session session = factory.getCurrentSession();
		try {
			session.update(person);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	public Person getUser(String emailAddress) {
		Session session = factory.getCurrentSession();
		System.out.println(session.hashCode());
		Person person = new Person();
		try {
			Criteria criteria = session.createCriteria(Person.class);
			criteria.add(Restrictions.eq("emailAddress", emailAddress));
			person = (Person) criteria.uniqueResult();
			System.out.println("entered");
			return person;
		} catch (RuntimeException e) {
			return person;
		}
	}

	public boolean deletePerson(String emailAddress) {
		Session session = factory.getCurrentSession();
		try {

			Query delete_query = session
					.createQuery("delete from Person where emailAddress=:id");
			delete_query.setParameter("id", emailAddress);
			delete_query.executeUpdate();

			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
}
