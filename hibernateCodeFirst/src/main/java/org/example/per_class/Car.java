package org.example.per_class;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{
    private static final String type = "CAR";

    public Car() {
        super(type);
    }
}
