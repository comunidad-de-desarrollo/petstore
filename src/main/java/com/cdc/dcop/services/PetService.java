package com.cdc.dcop.services;

import com.cdc.dcop.dto.PetDTO;
import com.cdc.dcop.entity.Pet;
import com.cdc.dcop.repository.PetRepository;
import com.cdc.dcop.utils.PetstoreValidation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PetService {

    @Autowired
    PetRepository petRepository;

    ModelMapper mapper = new ModelMapper();

    public PetDTO findById(Long petId) {
        Pet pet = petRepository.findById(petId).orElse(null);
        if (pet == null) {
            PetstoreValidation.notFound("Not found", "Pet not found").lanzar();
        }
        return mapper.map(pet, PetDTO.class);
    }
}
