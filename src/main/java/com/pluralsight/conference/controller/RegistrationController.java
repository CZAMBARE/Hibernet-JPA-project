package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;
import com.pluralsight.conference.service.RegistartionService;
import com.pluralsight.conference.service.RegistrationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.validation.Valid;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistartionService registrationService;

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute ("registration")Registration registration) {
        return "registration";
    }
    
    @GetMapping("registrations")
    public @ResponseBody
    List<Registration>
    getRegistrations (){
    	List<Registration> registrations = registrationService.findAll();
    	System.out.print("Registrations is called");
    	return registrations;
    }
    
    @GetMapping("registration-reports")
    public @ResponseBody
    List<RegistrationReport>
    getRegistrationsReports(){
    	List<RegistrationReport> registrationsReports = registrationService.findAllReport();
    	System.out.print("Registrations Report is called");
    	return registrationsReports;
    }

    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute ("registration")
                                              Registration registration,
                                  BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("There were errors");
            return "registration";
        }else {
        	registrationService.addRegistration(registration);
        }
        System.out.println("Registration: " + registration.getName());

        return "redirect:registration";
    }
    
    @PostMapping("registration/update")
    public @ResponseBody Registration updateRegistration(@Valid @ModelAttribute("registration")
                                                         Registration registration,
                                                         BindingResult result) {
    	System.out.println("Update Method Called");
    	return registrationService.addRegistration(registration);
    }

}
