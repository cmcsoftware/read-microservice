package com.microservice.read.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.read.test.model.Users;
import com.microservice.read.test.repository.UsersRepository;

@Component
public class QueueConsumer {
	
	@Autowired
	UsersRepository usersRepo;
	
	@Autowired
	ObjectMapper mapper;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	public void receiveMessage(String message) {
		logger.info("Received (String) " + message);
		processMessage(message);
	}

	public void receiveMessage(byte[] message) {
		String strMessage = new String(message);
		logger.info("Received (No String) " + strMessage);
		processMessage(strMessage);
	}

	private void processMessage(String message) {
		try {
			logger.info("Message received:"+message);
			Users user = mapper.readValue(message, Users.class);
			usersRepo.save(user);
			logger.info("Saved in DB");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}