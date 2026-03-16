package com.atypicalfigure.pets.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Objects;

public class Pet {

    private long id;
    private @NotBlank String name;
    private @NotBlank String species;
    private @PositiveOrZero Integer age;
    private String ownerName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getSpecies() {
        return species;
    }

    public void setSpecies(@NotBlank String species) {
        this.species = species;
    }

    public @PositiveOrZero Integer getAge() {
        return age;
    }

    public void setAge(@PositiveOrZero Integer age) {
        this.age = age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet pet)) return false;

        return id == pet.id && name.equals(pet.name) && species.equals(pet.species) && Objects.equals(age, pet.age) && Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + name.hashCode();
        result = 31 * result + species.hashCode();
        result = 31 * result + Objects.hashCode(age);
        result = 31 * result + Objects.hashCode(ownerName);
        return result;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
