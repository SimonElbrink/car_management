package se.lexicon.simon.car_management.dto;

import java.time.LocalDate;

public class CarDTO {
    private int id;
    private String regNumber;
    private LocalDate regDate;
    private String brandName;

    public CarDTO(int id, String regNumber, LocalDate regDate, String brandName) {
        this.id = id;
        this.regNumber = regNumber;
        this.regDate = regDate;
        this.brandName = brandName;
    }

    public CarDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
