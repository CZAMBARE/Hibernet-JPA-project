package com.pluralsight.conference.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.repository.RegistrationRepo;

@Service
public class RegistrationServiceImpl implements RegistartionService {
	
	@Autowired
	private RegistrationRepo registartionRepository;
	
	
	
	
	@Override
	@Transactional
	public Registration addRegistration(Registration registration) {
		return registartionRepository.save(registration);
	}

}
