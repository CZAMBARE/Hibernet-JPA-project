package com.pluralsight.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;

public interface RegistartionService {

	Registration addRegistration(Registration registration);

	List<Registration> findAll();

	List<RegistrationReport> findAllReport();

}