package com.cdc.dcop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdc.dcop.daos.IPetstoreDAO;
import com.cdc.dcop.models.Pet;

@Service
public class PetstoreService implements IPetstoreService {

	@Autowired
	private IPetstoreDAO petstoreDAO;

	@Override
	public Pet findById(int id) {
		return petstoreDAO.findById(id);
	}
	
	@Override
	public Pet findByStatus(String status) {
		return petstoreDAO.findByStatus(status);
	}

}
