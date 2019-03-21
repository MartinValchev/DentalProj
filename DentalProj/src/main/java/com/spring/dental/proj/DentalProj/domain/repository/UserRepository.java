package com.spring.dental.proj.DentalProj.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(name = "SELECT e from User e where e.id =:id")
	User getUserById(@Param(value = "id") Long id);
}
