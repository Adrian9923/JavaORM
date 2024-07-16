package relations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "plate_numbers")
public class PlateNumber extends BaseEntity{
    private String number;
    private Car car;

    public PlateNumber() {
    }

    @Column
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToOne(mappedBy = "plateNumber")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
