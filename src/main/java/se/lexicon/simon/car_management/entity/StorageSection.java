package se.lexicon.simon.car_management.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class StorageSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String section;

    @ManyToOne (cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.LAZY,
            mappedBy = "storageSection")
    private List<Car> cars;

    public StorageSection(int id, String section, Address address, List<Car> car) {
        this.id = id;
        setSection(section);
        setAddress(address);
        setCars(car);
    }

    public StorageSection(String section, Address address) {
        this(0, section, address, new ArrayList<>());
    }

    public StorageSection() {}

    public void addCar(Car car){
        if (cars == null){
            cars = new ArrayList<>();
        }

        if(car == null) throw new IllegalArgumentException("car was " + null);

        if (!cars.contains(car)){
            cars.add(car);
            car.setStorageSection(this);
        }
    }

    public void removeCar(Car car){
        if (cars == null){
            cars = new ArrayList<>();
        }

        if(car == null) throw new IllegalArgumentException("car was " + null);

        if (cars.contains(car)){
            car.setStorageSection(null);
            cars.remove(car);
        }
    }


    public int getId() {
        return id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        if (section == null){
            getCars().forEach(c -> c.setStorageSection(null));
        }
        this.section = section;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        StorageSection that = (StorageSection) o;
        return getId() == that.getId() &&
                Objects.equals(getSection(), that.getSection()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getCars(), that.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSection(), getAddress(), getCars());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StorageSection{");
        sb.append("id=").append(id);
        sb.append(", section='").append(section).append('\'');
        sb.append(", address=").append(address);
        sb.append(", cars=").append(cars);
        sb.append('}');
        return sb.toString();
    }
}
