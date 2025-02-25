package animals;

public class Dog implements Animal, Pet {

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void move() {
        System.out.println("The dog runs on four legs.");
    }

    @Override
    public void play() {
        System.out.println("The dog is playing fetch.");
    }

    @Override
    public void sleep() {
        System.out.println("The dog is sleeping on its bed.");
    }
}
