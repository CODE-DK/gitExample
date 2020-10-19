package root.lesson_4.storage;

import root.lesson_4.dto.Pet;
import root.lesson_4.exceptions.IllegalOperationException;

import java.util.UUID;

public interface Storage<T extends Pet> {

    void addUnique(T pet) throws IllegalOperationException;

    T findByName(String name) throws IllegalOperationException;

    UUID update(T oldPet, T newPet) throws IllegalOperationException;
}
