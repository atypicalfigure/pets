package com.atypicalfigure.pets.service;

import com.atypicalfigure.pets.domain.Pet;
import com.atypicalfigure.pets.repository.PetsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetsService {

    private final PetsRepository repo;

    public PetsService(PetsRepository repo) {
        this.repo = repo;
    }

    public Pet createPet(Pet pet) {
        return repo.save(pet);
    }

    public Pet updatePet(Long id, Pet pet) {
        Pet existingPet = repo.findById(id);

        Optional.ofNullable(pet.getAge()).ifPresent(existingPet::setAge);
        Optional.ofNullable(pet.getName()).ifPresent(existingPet::setName);
        Optional.ofNullable(pet.getSpecies()).ifPresent(existingPet::setSpecies);
        Optional.ofNullable(pet.getOwnerName()).ifPresent(existingPet::setOwnerName);

        return repo.update(existingPet);
    }

    public void deletePet(Long id) {
        repo.delete(id);
    }

    public Pet getPet(Long id) {
        return repo.findById(id);
    }

    public List<Pet> getAllPets() {
        return repo.findAll();
    }
}
