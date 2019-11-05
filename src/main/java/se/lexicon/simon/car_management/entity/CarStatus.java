package se.lexicon.simon.car_management.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarStatus {

    private int id;
    private String status;
    private List<Car> car;

    public CarStatus(int id, String status, List<Car> car) {
        this.id = id;
        this.status = status;
        this.car = car;
    }

    public CarStatus(String status) {
        this(0, status, new ArrayList<>());
    }

    public CarStatus() {}

    public void addCar(Car car){
        if (this.car == null){
            this.car = new ArrayList<>();
        }
        if (!this.car.contains(car)){
            this.car.add(car);
        }
    }

    public void removeCar(Car car){
        if (this.car == null){
            this.car = new ArrayList<>();
        }
        if (this.car.contains(car)){
            this.car.remove(car);
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

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarStatus carStatus = (CarStatus) o;
        return getId() == carStatus.getId() &&
                Objects.equals(getStatus(), carStatus.getStatus()) &&
                Objects.equals(getCar(), carStatus.getCar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus(), getCar());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarStatus{");
        sb.append("id=").append(id);
        sb.append(", status='").append(status).append('\'');
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
