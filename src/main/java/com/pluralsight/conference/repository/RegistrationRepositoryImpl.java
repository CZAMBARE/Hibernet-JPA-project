package com.pluralsight.conference.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Registration save(Registration registration) {
		entityManager.persist(registration);
		return registration;
	}

	@Override
	public List<Registration> findAll() {
		List<Registration> registrations = entityManager.createQuery("Select r from Registration r").getResultList();
		
		return registrations;
	}

	@Override
	public List<RegistrationReport> findAllReports() {
		String jpql = "Select new com.pluralsight.conference.model.RegistrationReport" + 
	                     "(r.name, c.name, c.description) "+ 
				         "from Registration r, Course c " + 
	                     "where r.id= c.registration.id";
        List<RegistrationReport> registrationsReports = entityManager.createQuery(jpql).getResultList();
		
		return registrationsReports;
	}

}
