package com.cdc.dcop.services;

import com.cdc.dcop.dto.PetDTO;
import com.cdc.dcop.entity.Pet;

public interface IPetstoreService {

    Pet findById(Long id);

    Pet findByStatus(String status);

    Pet update(Pet pet, Long id);

    PetDTO save(PetDTO pet);

}
