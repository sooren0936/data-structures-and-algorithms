package crackingcodinginterview.StacksAndQueues.animalshelter.model;

import java.time.Instant;

public abstract class Animal {

    private Instant placedInShelterTime;
    private final String name;

    protected Animal(final String name) {
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