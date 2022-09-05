package com.pluralsight.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.conference.model.Course;
import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.repository.CourseRepository;
import com.pluralsight.conference.repository.RegistrationRepo;

@Service
public class RegistrationServiceImpl implements RegistartionService {
	
	@Autowired
	private RegistrationRepo registartionRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	
	
	@Override
	@Transactional
	public Registration addRegistration(Registration registration) {
		registration = registartionRepository.save(registration);
		
		Course course = new Course();
		course.setName("Intro");
		course.setDescription("EveryOne should attend this mandatory Course");
		course.setRegistration(registration);
		
		courseRepository.save(course);
		
		return registration;
	}





	@Override
	public List<Registration> findAll() {
		// TODO Auto-generated method stub
		return registartionRepository.findAll();
	}

}
