package lesson;

import lombok.Getter;

@Getter
public class Dog {
    private final String name;
    private final int age;
    private final String breed;

    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public void bark() {
        System.out.println(this.name + " is barking! Woof! Woof!");
    }

}
