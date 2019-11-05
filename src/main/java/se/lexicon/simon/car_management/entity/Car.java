package se.lexicon.simon.car_management.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {

    private int id;
    private String regNumber;
    private LocalDate regDate;
    private String brandName;

    private ServiceHistory serviceHistory;
    private List<CarStatus> carStatus;
    private StorageSection storageSection;


    public Car(int id, String regNumber, LocalDate regDate, String brandName, ServiceHistory serviceHistory, List<CarStatus> carStatus, StorageSection storageSection) {
        this.id = id;
        setRegNumber(regNumber);
        setRegDate(regDate);
        setBrandName(brandName);
        setServiceHistory(serviceHistory);
        setCarStatus(carStatus);
        setStorageSection(storageSection);
    }

    public Car(String regNumber, LocalDate regDate, String brandName, ServiceHistory serviceHistory, StorageSection storageSection) {
        this(0, regNumber, regDate, brandName, serviceHistory, new ArrayList<>(), storageSection);
    }

    public Car() {}


    public void addCarStatus(CarStatus carStatus){
        if (this.carStatus == null){
            this.carStatus = new ArrayList<>();
        }
        if (!this.carStatus.contains(carStatus)){
            this.carStatus.add(carStatus);
        }
    }

    public void removeCarStatus(CarStatus carStatus){
        if (this.carStatus == null){
            this.carStatus = new ArrayList<>();
        }
        if (this.carStatus.contains(carStatus)){
            this.carStatus.remove(carStatus);
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

    public List<CarStatus> getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(List<CarStatus> carStatus) {
        this.carStatus = carStatus;
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
                Objects.equals(getCarStatus(), car.getCarStatus()) &&
                Objects.equals(getStorageSection(), car.getStorageSection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRegNumber(), getRegDate(), getBrandName(), getServiceHistory(), getCarStatus(), getStorageSection());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", regNumber='").append(regNumber).append('\'');
        sb.append(", regDate=").append(regDate);
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", serviceHistory=").append(serviceHistory);
        sb.append(", carStatus=").append(carStatus);
        sb.append(", storageSection=").append(storageSection);
        sb.append('}');
        return sb.toString();
    }
}
