package se.lexicon.simon.car_management.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String regNumber;

    private LocalDate regDate;
    private String brandName;

    @OneToOne(cascade =
            CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "service_history_id")
    private ServiceHistory serviceHistory;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinTable(name = "car_car_status",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "car_status_id")
    )
    private List<CarStatus> carStatuses;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    private StorageSection storageSection;


    public Car(int id, String regNumber, LocalDate regDate, String brandName, ServiceHistory serviceHistory, List<CarStatus> carStatus, StorageSection storageSection) {
        this.id = id;
        setRegNumber(regNumber);
        setRegDate(regDate);
        setBrandName(brandName);
        setServiceHistory(serviceHistory);
        setCarStatuses(carStatus);
        setStorageSection(storageSection);
    }

    public Car(String regNumber, LocalDate regDate, String brandName, ServiceHistory serviceHistory, StorageSection storageSection) {
        this(0, regNumber, regDate, brandName, serviceHistory, new ArrayList<>(), storageSection);
    }

    public Car() {}


    public void addCarStatus(CarStatus carStatus){
        if (carStatuses == null){
            carStatuses = new ArrayList<>();
        }
        if (!carStatuses.contains(carStatus)){
            carStatuses.add(carStatus);
        }
    }

    public void removeCarStatus(CarStatus carStatus){
        if (carStatuses == null){
            carStatuses = new ArrayList<>();
        }
        if (carStatuses.contains(carStatus)){
            carStatuses.remove(carStatus);
        }
    }


    public int getId() {
        return id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public ServiceHistory getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(ServiceHistory serviceHistory) {
        this.serviceHistory = serviceHistory;
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }

    public void setCarStatuses(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public StorageSection getStorageSection() {
        return storageSection;
    }

    public void setStorageSection(StorageSection storageSection) {
        this.storageSection = storageSection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getId() == car.getId() &&
                Objects.equals(getRegNumber(), car.getRegNumber()) &&
                Objects.equals(getRegDate(), car.getRegDate()) &&
                Objects.equals(getBrandName(), car.getBrandName()) &&
                Objects.equals(getServiceHistory(), car.getServiceHistory()) &&
                Objects.equals(getCarStatuses(), car.getCarStatuses()) &&
                Objects.equals(getStorageSection(), car.getStorageSection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRegNumber(), getRegDate(), getBrandName(), getServiceHistory(), getCarStatuses(), getStorageSection());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", regNumber='").append(regNumber).append('\'');
        sb.append(", regDate=").append(regDate);
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", serviceHistory=").append(serviceHistory);
        sb.append(", carStatuses=").append(carStatuses);
        sb.append(", storageSection=").append(storageSection);
        sb.append('}');
        return sb.toString();
    }
}
