package com.psna.digilearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psna.digilearn.model.CustomFile;
import com.psna.digilearn.repository.CustomFileRepository;

@Service
public class CustomFileServiceImpl implements CustomFileService {
	
	@Autowired
	CustomFileRepository fileRepository;
	
	@Override
	public void save(CustomFile file) {
		fileRepository.save(file);
	}

}
