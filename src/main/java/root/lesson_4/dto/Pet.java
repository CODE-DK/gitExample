package root.lesson_4.dto;

import root.lesson_2.Person;

import java.util.Objects;
import java.util.UUID;

import static java.util.Comparator.comparing;

public class Pet implements Comparable<Pet> {
    private UUID id;
    private String name;
    private Double weight;
    private Person master;

    public Pet() {
    }

    public Pet(UUID id, String name, Double weight, Person master) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.master = master;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Person getMaster() {
        return master;
    }

    public void setMaster(Person master) {
        this.master = master;
    }

    @Override
    public int compareTo(Pet o) {
        return comparing(Pet::getMaster)
                .thenComparing(Pet::getName)
                .thenComparing(Pet::getWeight).compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(weight, pet.weight) &&
                Objects.equals(master, pet.master);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, master);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", master=" + master +
                '}';
    }

    public static PetBuilder builder() {
        return new PetBuilder();
    }

    public static class PetBuilder {
        private UUID id;
        private String name;
        private Double weight;
        private Person master;

        public PetBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public PetBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder withWeight(Double weight) {
            this.weight = weight;
            return this;
        }

        public PetBuilder withMaster(Person master) {
            this.master = master;
            return this;
        }

        public Pet build() {
            return new Pet(id, name, weight, master);
        }
    }
}
