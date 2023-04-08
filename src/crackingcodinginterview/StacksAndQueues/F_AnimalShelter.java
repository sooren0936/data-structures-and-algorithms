package crackingcodinginterview.StacksAndQueues;

import crackingcodinginterview.StacksAndQueues.animalshelter.model.Cat;
import crackingcodinginterview.StacksAndQueues.animalshelter.model.Dog;
import crackingcodinginterview.StacksAndQueues.animalshelter.queue.AnimalShelter;
import crackingcodinginterview.StacksAndQueues.animalshelter.queue.impl.AnimalShelterImpl;

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
}
