package com.cdc.dcop.repository;

import com.cdc.dcop.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findById(Long id);
}
