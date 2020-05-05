package com.psna.digilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psna.digilearn.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
	
	List<Request> findByUserId(Long id);

}
