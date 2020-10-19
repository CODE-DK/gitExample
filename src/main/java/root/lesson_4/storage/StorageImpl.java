package root.lesson_4.storage;

import root.lesson_4.dto.Pet;
import root.lesson_4.exceptions.IllegalOperationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.Collections.sort;

public class StorageImpl<T extends Pet> implements Storage<T> {

    private final List<T> pets = new ArrayList<>();

    @Override
    public void addUnique(T pet) throws IllegalOperationException {
        if (pets.contains(pet)) {
            throw new IllegalOperationException("This pet is already exist");
        }
        pets.add(pet);
    }

    @Override
    public T findByName(String name) {
        if (indexOf(name) == -1) {
            throw new IllegalOperationException("Unknown pet name=" + name);
        }
        return pets.get(indexOf(name));
    }

    @Override
    public UUID update(T oldPet, T newPet) {
        if (indexOf(oldPet) == -1) {
            throw new IllegalOperationException("Pet not exist " + oldPet);
        }
        pets.remove(indexOf(oldPet));
        pets.add(newPet);
        return newPet.getId();
    }

    private int indexOf(String name) {
        int index = 0;
        for (T xPet : pets) {
            if (Objects.equals(xPet.getName(), name)) {
                return index;
            }
            index += 1;
        }
        return -1;
    }

    private int indexOf(T pet) {
        int index = 0;
        for (T xPet : pets) {
            if (Objects.equals(xPet, pet)) {
                return index;
            }
            index += 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        sort(pets);
        return "StorageImpl{" +
                "pets=" + pets +
                '}';
    }
}
