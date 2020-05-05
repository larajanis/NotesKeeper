package com.psna.digilearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psna.digilearn.model.Role;
import com.psna.digilearn.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role getRole(int id) {
		return roleRepository.findById(id);
	}
	
	

}
