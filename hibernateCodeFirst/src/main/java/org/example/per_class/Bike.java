package org.example.per_class;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle{
    private final static String type = "BIKE";

    public Bike() {
        super(type);
    }
}
