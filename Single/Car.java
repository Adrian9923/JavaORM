package org.example.Single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "car")
public class Car extends PassengerVehicle{
    private static final String type = "CAR";

    public Car() {
    }

    public Car(int numberOfPassengers) {
        super(type, numberOfPassengers);
    }

}
