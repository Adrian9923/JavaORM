package org.example.Single;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Basic
    @Column(insertable = false, updatable = false)
    private String type;

    public Vehicle() {
    }

    public Vehicle(String type) {
        this.type = type;
    }
}
