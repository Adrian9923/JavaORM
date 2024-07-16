package org.example.Single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "truck")
public class Truck extends TransportationVehicle{
    private static final String type = "TRUCK";

    private int numberOfContainers;

    public Truck() {
    }

    public Truck(int loadCapacity, int numberOfContainers) {
        super(type, loadCapacity);
        this.numberOfContainers = numberOfContainers;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

    public Truck setNumberOfContainers(int numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
        return this;
    }
}
