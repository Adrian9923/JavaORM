package relations;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver extends BaseEntity{
    private String fullName;
    private Set<Truck> trucks;

    public Driver() {
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @ManyToMany
    @JoinTable(
            name = "drivers_trucks",
            joinColumns = {@JoinColumn(name = "driver_id")},
            inverseJoinColumns = {@JoinColumn(name = "truck_id")}
    )
    public Set<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(Set<Truck> trucks) {
        this.trucks = trucks;
    }
}
