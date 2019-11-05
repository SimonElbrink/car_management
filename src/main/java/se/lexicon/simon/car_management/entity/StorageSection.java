package se.lexicon.simon.car_management.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StorageSection {

    private int id;

    //example A_01
    private String section;
    private Address address;
    private List<Car> car;

    public StorageSection(int id, String section, Address address, List<Car> car) {
        this.id = id;
        setSection(section);
        setAddress(address);
        setCar(car);
    }

    public StorageSection(String section, Address address) {
        this(0, section, address, new ArrayList<>());
    }

    public StorageSection() {}

    public void addCar(Car car){
        if (this.car == null){
            this.car = new ArrayList<>();
        }
        this.car.add(car);
        car.setStorageSection(this);
    }

    public void removeCar(Car car){
        if (this.car == null){
            this.car = new ArrayList<>();
        }
        car.setStorageSection(null);
        this.car.remove(car);
    }


    public int getId() {
        return id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        StorageSection that = (StorageSection) o;
        return getId() == that.getId() &&
                Objects.equals(getSection(), that.getSection()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getCar(), that.getCar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSection(), getAddress(), getCar());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StorageSection{");
        sb.append("id=").append(id);
        sb.append(", section='").append(section).append('\'');
        sb.append(", address=").append(address);
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
