package com.interland.SpringDataRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.interland.SpringDataRest.model.User;

@RepositoryRestResource(collectionResourceRel = "users",path = "users")
public interface UserRepo extends JpaRepository<User, Integer> {

}
