package root.lesson_4.storage;

import org.junit.Before;
import org.junit.Test;
import root.lesson_2.Person;
import root.lesson_2.Sex;
import root.lesson_4.dto.Pet;
import root.lesson_4.exceptions.IllegalOperationException;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StorageImplTest {

    private Storage<Pet> petStorage;
    private Pet jack;

    @Before
    public void setUp() {
        petStorage = new StorageImpl<>();

        jack = Pet.builder()
                .withId(UUID.randomUUID())
                .withMaster(Person.builder()
                        .withSex(Sex.MAN)
                        .withAge(23)
                        .withName("John")
                        .build())
                .withName("Jack")
                .withWeight(56.3)
                .build();

        petStorage.addUnique(jack);
    }

    @Test(expected = IllegalOperationException.class)
    public void addUnique() {
        petStorage.addUnique(jack);
    }

    @Test(expected = IllegalOperationException.class)
    public void findByName() {
        Pet jack = petStorage.findByName("Jack");
        assertEquals(this.jack, jack);

        petStorage.findByName("unknown");
    }

    @Test(expected = IllegalOperationException.class)
    public void update() {
        UUID newId = petStorage.update(this.jack, Pet.builder()
                .withId(UUID.randomUUID())
                .withMaster(Person.builder()
                        .withSex(Sex.MAN)
                        .withAge(23)
                        .withName("John")
                        .build())
                .withName("Jack")
                .withWeight(56.3)
                .build());

        assertNotEquals(this.jack.getId(), newId);

        petStorage.update(null, jack);
    }
}