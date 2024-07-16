package org.example.Single;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PassengerVehicle extends Vehicle{
    private int numberOfPassengers;

    public PassengerVehicle() {
    }

    public PassengerVehicle(String type, int numberOfPassengers) {
        super(type);
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public PassengerVehicle setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
        return this;
    }
}
