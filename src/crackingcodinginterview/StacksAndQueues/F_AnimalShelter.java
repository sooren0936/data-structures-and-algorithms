package crackingcodinginterview.StacksAndQueues;

import java.time.Instant;
import java.util.LinkedList;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 * that type). They cannot select which specific animal they would like. Create the data structures to
 * maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 * and dequeueCat. You may use the built-in Linkedlist data structure.
 */
public class F_AnimalShelter {

    public static void main(String[] args) {
        animalShelter();
    }

    public static void animalShelter() {
        final AnimalShelter animalShelter = new AnimalShelterImpl();

        animalShelter.enqueue(new Dog("Pes"));
        animalShelter.enqueue(new Cat("Cat"));
        animalShelter.enqueue(new Dog("Sharik"));
        animalShelter.enqueue(new Cat("Cotofei"));
        animalShelter.enqueue(new Dog("Sobaka"));

        animalShelter.dequeueAny();
        animalShelter.dequeueAny();
        animalShelter.dequeueCat();
        animalShelter.dequeueDog();
    }

    public abstract static class Animal {

        private Instant placedInShelterTime;
        private final String name;

        public Animal(final String name) {
            this.name = name;
        }

        public Instant getPlacedInShelterTime() {
            return this.placedInShelterTime;
        }

        public void setPlacedInShelterTime(Instant getPlacedInShelterTime) {
            this.placedInShelterTime = getPlacedInShelterTime;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }

    public static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }

    public interface AnimalShelter {

        void enqueue(Animal animal);

        Animal dequeueAny();

        Dog dequeueDog();

        Cat dequeueCat();
    }

    public static class AnimalShelterImpl implements AnimalShelter {

        final LinkedList<Cat> cats = new LinkedList<>();
        final LinkedList<Dog> dogs = new LinkedList<>();

        @Override
        public void enqueue(Animal animal) {
            if (animal instanceof Cat cat) {
                cat.setPlacedInShelterTime(Instant.now());
                cats.offer(cat);

            } else if (animal instanceof Dog dog) {
                dog.setPlacedInShelterTime(Instant.now());
                dogs.offer(dog);

            } else {
                throw new IllegalArgumentException("Not supported animal for shelter with type: " + animal);
            }
        }

        @Override
        public Animal dequeueAny() {
            final Dog dog = dogs.peek();
            final Cat cat = cats.peek();

            if (dog.getPlacedInShelterTime().isAfter(cat.getPlacedInShelterTime())) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }

        @Override
        public Dog dequeueDog() {
            final Dog dog = dogs.remove();
            dog.setPlacedInShelterTime(null);

            return dog;
        }

        @Override
        public Cat dequeueCat() {
            final Cat cat = cats.remove();
            cat.setPlacedInShelterTime(null);

            return cat;
        }
    }
}
