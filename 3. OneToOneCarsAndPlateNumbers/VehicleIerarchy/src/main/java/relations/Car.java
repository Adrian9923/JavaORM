package relations;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity{
    private String fuelType;
    private String model;
    private BigDecimal price;
    private String type;
    private int seats;
    private PlateNumber plateNumber;

    public Car() {
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
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @OneToOne
    @JoinColumn(name = "plate_number_id", referencedColumnName = "id")
    public PlateNumber getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }
}
