package com.atypicalfigure.pets.controller;

import com.atypicalfigure.pets.domain.Pet;
import com.atypicalfigure.pets.service.PetsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/pets")
public class PetsController {

    private final PetsService service;

    public PetsController(PetsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@Valid @RequestBody Pet pet) {
        Pet created = service.createPet(pet);
        return ResponseEntity.status(CREATED).body(created);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable long id, @Valid @RequestBody Pet pet) {
        Pet updatedPet = service.updatePet(id, pet);
        return ResponseEntity.ok().body(updatedPet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable long id) {
        service.deletePet(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable long id) {
        Pet pet = service.getPet(id);
        return ResponseEntity.ok().body(pet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> allPets = service.getAllPets();
        return ResponseEntity.ok().body(allPets);
    }
}
