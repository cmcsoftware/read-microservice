package com.microservice.read.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.read.test.model.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {

	Users getByName(String name);


}
