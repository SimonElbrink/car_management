package se.lexicon.simon.car_management.entity;

import java.util.Objects;


public class Address {

    private int addressId;
    private String street;
    private String zipCode;
    private String city;

    public Address(int addressId, String street, String zipCode, String city) {
        this.addressId = addressId;
        setStreet(street);
        setZipCode(zipCode);
        setCity(city);
    }

    public Address(String street, String zipCode, String city) {
        this(0,street,zipCode,city);
    }

    public int getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if(street == null) throw new IllegalArgumentException("street was " + null);
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if(zipCode == null) throw new IllegalArgumentException("zipCode was " + null);
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city == null) throw new IllegalArgumentException("city was " + null);
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId &&
                Objects.equals(street, address.street) &&
                Objects.equals(zipCode, address.zipCode) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, street, zipCode, city);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("addressId=").append(addressId);
        sb.append(", street='").append(street).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
