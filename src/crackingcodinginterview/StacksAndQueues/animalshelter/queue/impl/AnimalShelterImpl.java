package crackingcodinginterview.StacksAndQueues.animalshelter.queue.impl;

import crackingcodinginterview.StacksAndQueues.animalshelter.model.Animal;
import crackingcodinginterview.StacksAndQueues.animalshelter.model.Cat;
import crackingcodinginterview.StacksAndQueues.animalshelter.model.Dog;
import crackingcodinginterview.StacksAndQueues.animalshelter.queue.AnimalShelter;

import java.time.Instant;
import java.util.LinkedList;

public class AnimalShelterImpl implements AnimalShelter {

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
        final Dog dog = dogs.poll();
        dog.setPlacedInShelterTime(null);

        return dog;
    }

    @Override
    public Cat dequeueCat() {
        final Cat cat = cats.poll();
        cat.setPlacedInShelterTime(null);

        return cat;
    }
}