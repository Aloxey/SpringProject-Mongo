package com.p.SpringProject;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepository extends MongoRepository<User, String> {

    public User findById(Integer id);

    public User deleteById(Integer id);

}