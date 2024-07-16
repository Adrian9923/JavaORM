package org.join;

import jakarta.persistence.Entity;

@Entity
public class Car extends PassengerVehicle{
    private static final String type = "CAR";

    public Car() {
    }

    public Car(int numberOfPassengers) {
        super(type, numberOfPassengers);
    }


}
