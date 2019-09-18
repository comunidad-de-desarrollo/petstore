package com.cdc.dcop.services;

import com.cdc.dcop.entity.Pet;
import com.cdc.dcop.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetstoreService {

    @Autowired
    private PetRepository petRepository;
    

	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}
	
	public Pet updatePet(Pet pet) {
		return petRepository.updatePet(pet);
	}

   
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }


    public Pet findByStatus(String status) {
        return petRepository.findByStatus(status);
    }

}
