package root.lesson_2;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {

    private int age;
    private Sex sex;
    private String name;

    @Override
    public int compareTo(Person o) {
        Comparator<Person> comparing = Comparator
                .comparing(Person::getSex)
                .thenComparing(Person::getAge)
                .thenComparing(Person::getName);

        return comparing.compare(this, o);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                sex == person.sex &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, sex, name);
    }

    public Person() {
    }

    public Person(int age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
