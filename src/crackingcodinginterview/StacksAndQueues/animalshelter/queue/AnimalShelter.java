package crackingcodinginterview.StacksAndQueues.animalshelter.queue;

import crackingcodinginterview.StacksAndQueues.animalshelter.model.Animal;
import crackingcodinginterview.StacksAndQueues.animalshelter.model.Cat;
import crackingcodinginterview.StacksAndQueues.animalshelter.model.Dog;

public interface AnimalShelter {

    void enqueue(Animal animal);

    Animal dequeueAny();

    Dog dequeueDog();

    Cat dequeueCat();
}