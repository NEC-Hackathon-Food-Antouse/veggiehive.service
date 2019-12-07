package com.nec.foodstorage.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nec.foodstorage.models.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
