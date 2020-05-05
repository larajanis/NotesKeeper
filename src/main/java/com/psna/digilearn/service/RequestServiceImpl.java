package com.psna.digilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psna.digilearn.model.Request;
import com.psna.digilearn.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	RequestRepository requestRepository;
	
	@Override
	public void save(Request req) {
		requestRepository.save(req);
	}
	
	@Override
	public List<Request> getRequests(Long id){
		return requestRepository.findByUserId(id);
	}

}
