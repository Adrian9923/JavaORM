package vehicle_hierarchy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle{
    private double loadCapacity;

    public Truck() {
    }

    @Column(name = "load_capacity")
    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
