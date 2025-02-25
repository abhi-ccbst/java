package animals;

import enums.AnimalType;

public class Cat implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void move() {
        System.out.println("The cat walks gracefully on four legs.");
    }

    public void print() {
        System.out.println(AnimalType.CAT);
    }
}
