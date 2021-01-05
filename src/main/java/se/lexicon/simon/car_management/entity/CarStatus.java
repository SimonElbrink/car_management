package se.lexicon.simon.car_management.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class CarStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinTable(name = "car_car_status",
            joinColumns = @JoinColumn(name = "car_status_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car> cars;

    public CarStatus(int id, String status, List<Car> cars) {
        this.id = id;
        setStatus(status);
        setCars(cars);
    }

    public CarStatus(String status) {
        this(0, status, new ArrayList<>());
    }

    public CarStatus() {}

    public void addCar(Car car){
        if (this.cars == null){
            this.cars = new ArrayList<>();
        }

        if(car == null) throw new IllegalArgumentException("car was " + null);

        if (!this.cars.contains(car)){
            this.cars.add(car);
        }
    }

    public void removeCar(Car car){
        if (this.cars == null){
            this.cars = new ArrayList<>();
        }

        if(car == null) throw new IllegalArgumentException("car was " + null);

        if (this.cars.contains(car)){
            this.cars.remove(car);
        }
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarStatus carStatus = (CarStatus) o;
        return getId() == carStatus.getId() &&
                Objects.equals(getStatus(), carStatus.getStatus()) &&
                Objects.equals(getCars(), carStatus.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus(), getCars());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarStatus{");
        sb.append("id=").append(id);
        sb.append(", status='").append(status).append('\'');
        sb.append(", cars=").append(cars);
        sb.append('}');
        return sb.toString();
    }
}
