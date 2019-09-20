package com.cdc.dcop.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdc.dcop.entity.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

	public Pet savePet(Pet pet);
	
	public Pet updatePet(Pet pet);

	public Pet findById(long id);

	public Pet findByStatus(String status);

}
