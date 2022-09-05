package com.pluralsight.conference.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pluralsight.conference.model.Registration;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Registration save(Registration registration) {
		entityManager.persist(registration);
		return registration;
	}

}
