package com.cdc.dcop.daos;

import com.cdc.dcop.models.Pet;

public interface IPetstoreDAO {

    public Pet findById(int id);

    public Pet findByStatus(String status);

}
