package com.estudo.filhotarciso.userdpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.filhotarciso.userdpt.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
