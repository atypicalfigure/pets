package com.atypicalfigure.pets.repository;

import com.atypicalfigure.pets.domain.Pet;
import com.atypicalfigure.pets.exception.PetNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PetsSqlRepository implements PetsRepository {

    private static long currentId;
    private final Map<Long, Pet> db = new HashMap<>();

    public Pet save(Pet pet) {
        currentId++;
        pet.setId(currentId);
        db.put(pet.getId(), pet);
        return pet;
    }

    public Pet findById(long id) {
        Pet pet = db.get(id);
        throwExceptionIfNotFound(pet);
        return pet;
    }

    public void delete(long id) {
        Pet pet = db.remove(id);
        throwExceptionIfNotFound(pet);
    }

    public List<Pet> findAll() {
        return List.copyOf(db.values());
    }

    @Override
    public Pet update(Pet updatedPet) {
        db.replace(updatedPet.getId(), updatedPet);
        return updatedPet;
    }

    private void throwExceptionIfNotFound(Pet pet) {
        if (pet == null) {
            throw new PetNotFoundException();
        }
    }
}
