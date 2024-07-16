package vehicle_hierarchy;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle{

    public Bike() {
    }
}
