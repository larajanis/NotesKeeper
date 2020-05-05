package com.psna.digilearn.service;

import java.util.List;

import com.psna.digilearn.model.Request;

public interface RequestService {
	
	void save(Request req);
	
	List<Request> getRequests(Long id);

}
