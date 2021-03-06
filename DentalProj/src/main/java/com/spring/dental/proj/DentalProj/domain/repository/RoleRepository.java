package com.spring.dental.proj.DentalProj.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.domain.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	Role findByAuthority(String authority);
}
