package org.join;

import jakarta.persistence.Entity;

@Entity
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

    public void setNumberOfContainers(int numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }
}
