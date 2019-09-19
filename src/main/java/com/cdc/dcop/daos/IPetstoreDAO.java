package com.cdc.dcop.daos;

import com.cdc.dcop.entity.Pet;

public interface IPetstoreDAO {
	
	Pet findById(Long id);
	
	Pet findByStatus(String status);

}
