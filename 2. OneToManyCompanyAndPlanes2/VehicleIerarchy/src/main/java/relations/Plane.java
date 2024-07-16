package relations;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class Plane extends BaseEntity{
    private String fuelType;
    private String model;
    private BigDecimal price;
    private String type;
    private String airline;
    private int passengerCapacity;
    private Company company;

    public Plane() {
    }

    @Column(name = "fuel_type")
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Column
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Column(name = "passenger_capacity")
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
