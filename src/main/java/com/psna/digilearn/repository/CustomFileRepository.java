package com.psna.digilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psna.digilearn.model.CustomFile;

public interface CustomFileRepository extends JpaRepository<CustomFile, Long> {

}
