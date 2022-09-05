package com.pluralsight.conference.service;

import org.springframework.stereotype.Service;

import com.pluralsight.conference.model.User;



public interface UserService {

	User save(User user);

}