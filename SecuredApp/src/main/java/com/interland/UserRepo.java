package com.interland;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Person, Integer> {
	Person findByUsername(String username);

}
