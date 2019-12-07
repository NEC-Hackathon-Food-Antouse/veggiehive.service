package com.nec.foodstorage.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nec.foodstorage.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
}
