package se.lexicon.simon.car_management.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private Car testCar;
    private String regNumberTest = "ABC123";
    private LocalDate regDateTest = LocalDate.parse("2020-01-20");
    private String brandNameTest = "Volvo";

    private ServiceHistory serviceHistoryTest = new ServiceHistory("New Tires");

    private Address addressTest = new Address("Nygatan 1", "123 45", "Växjö");
    private StorageSection storageSectionTest = new StorageSection("A_01", addressTest);

    CarStatus carStatusTest = new CarStatus("New car");


    @BeforeEach
    public void setUp(){

        testCar = new Car(regNumberTest, regDateTest, brandNameTest, serviceHistoryTest, storageSectionTest);
        testCar.addCarStatus(carStatusTest);
    }

    @Test
    public void testCar_successfully_created(){

        assertEquals(0, testCar.getId());
        assertEquals(regNumberTest, testCar.getRegNumber());
        assertEquals(regDateTest, testCar.getRegDate());
        assertEquals(brandNameTest, testCar.getBrandName());

        assertEquals(serviceHistoryTest, testCar.getServiceHistory());
        assertEquals(storageSectionTest, testCar.getStorageSection());
        assertTrue(testCar.getCarStatuses().contains(carStatusTest));
    }

    @Test
    public void copyOf_testCar_equals_is_true(){
        Car testCarCopy = new Car(regNumberTest, regDateTest, brandNameTest, serviceHistoryTest, storageSectionTest);
        testCarCopy.addCarStatus(carStatusTest);
        assertTrue(testCarCopy.equals(testCar));
        assertEquals(testCarCopy.hashCode(), testCar.hashCode());
    }

    @Test
    public void toString_contains_correct_information(){
        String toString = testCar.toString();

        assertTrue(toString.contains("0"));
        assertTrue(toString.contains("ABC123"));
        assertTrue(toString.contains("2020-01-20"));
        assertTrue(toString.contains("Volvo"));
        assertTrue(toString.contains("New Tires"));
        assertTrue(toString.contains("Nygatan 1"));
        assertTrue(toString.contains("123 45"));
        assertTrue(toString.contains("Växjö"));
        assertTrue(toString.contains("A_01"));
        assertTrue(toString.contains("New car"));
    }



    @Test
    public void addCarStatus_should_add_correct_information(){

        testCar.setCarStatuses(null);

        testCar.addCarStatus(carStatusTest);

        assertTrue(testCar.getCarStatuses().contains(carStatusTest));
    }


    /*
    JUnit 5 is needed for this.
    "org.junit.jupiter.api"
     */
    @Test
    public void addCarStatus_should_throw_exception_when_param_is_null(){

        assertThrows(IllegalArgumentException.class, () -> { testCar.addCarStatus(null); });
        assertTrue(testCar.getCarStatuses().contains(carStatusTest));

    }

    @Test
    public void removeCarStatus_should_remove_correct_information(){

        testCar.removeCarStatus(carStatusTest);

        assertTrue(testCar.getCarStatuses().isEmpty());
    }


    /*
    JUnit 5 is needed for this.
    "org.junit.jupiter.api"
     */
    @Test
    public void removeCarStatus_should_throw_exception_when_param_is_null(){

        assertThrows(IllegalArgumentException.class, () -> { testCar.removeCarStatus(null); });
        assertTrue(testCar.getCarStatuses().contains(carStatusTest));

    }

    @Test
    public void removeCarStatus_should_create_new_arrayList_if_carStatus_is_null(){

        assertTrue(carStatusTest != null);

        testCar.setCarStatuses(null);

        testCar.removeCarStatus(carStatusTest);

        assertTrue(carStatusTest != null);


    }
}
