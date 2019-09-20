package com.cdc.dcop.services;

import com.cdc.dcop.daos.IPetstoreDAO;
import com.cdc.dcop.dto.PetDTO;
import com.cdc.dcop.dto.TagDTO;
import com.cdc.dcop.entity.Pet;
import com.cdc.dcop.entity.Tag;
import com.cdc.dcop.repository.CategoryRepository;
import com.cdc.dcop.repository.PetRepository;
import com.cdc.dcop.repository.TagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetstoreService {

    @Autowired
    private PetRepository petRepository;
    

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Pet findById(Long id) {
        return petstoreDAO.findById(id);
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

    public Pet update(Pet pet, Long id) {
        Pet petDB = findById(id);
        if ( petDB != null) {
            // TODO: mapeamos el objeto
            petDB.setName(pet.getName());
            petDB.setStatus(pet.getStatus());

            petRepository.save(petDB);
        }
        return petDB;
    }

    public PetDTO save(PetDTO pet) {
        Pet petSaved = petRepository.save(mapPetDtoToEntity(pet));
        return mapPetToDto(petSaved);
    }

    private Pet mapPetDtoToEntity(PetDTO petDTO) {
        if (petDTO == null) {
            return null;
        }
        List<Tag> tags = new ArrayList<>();
        Pet pet = mapper.map(petDTO, Pet.class);
        pet.setCategory(categoryRepository.findById(petDTO.getCategory().getId()).orElse(null));

        for (TagDTO tagDTO: petDTO.getTags()) {
            tags.add(tagRepository.findById(tagDTO.getId()).orElse(null));
        }
        pet.setTags(tags);
        return pet;
    }

    private PetDTO mapPetToDto(Pet pet) {
        return (pet != null) ? mapper.map(pet, PetDTO.class): null;
    }

}
