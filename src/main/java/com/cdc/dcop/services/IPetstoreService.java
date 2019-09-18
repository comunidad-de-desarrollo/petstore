package com.cdc.dcop.services;

import com.cdc.dcop.models.Pet;

public interface IPetstoreService {

    public Pet findById(int id);

    public Pet findByStatus(String status);

}
