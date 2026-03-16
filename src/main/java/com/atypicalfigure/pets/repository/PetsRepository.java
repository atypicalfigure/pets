package com.atypicalfigure.pets.repository;

import com.atypicalfigure.pets.domain.Pet;

import java.util.List;

public interface PetsRepository {

    Pet save(Pet pet);

    Pet findById(long id);

    void delete(long id);

    List<Pet> findAll();

    Pet update(Pet updatedPet);
}
