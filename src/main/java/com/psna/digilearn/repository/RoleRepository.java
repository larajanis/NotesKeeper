package com.psna.digilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psna.digilearn.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findById(int id);
}