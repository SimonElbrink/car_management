package se.lexicon.simon.car_management.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.simon.car_management.entity.*;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CarRepoTest {

    @Autowired
    private CarRepo carRepoTest;

    int carId;
    private Car testCarWithId;
    private String regNumberTest = "ABC123";
    private LocalDate regDateTest = LocalDate.parse("2020-01-20");
    private String brandNameTest = "Volvo";

    private ServiceHistory serviceHistoryTest = new ServiceHistory("New Tires");

    private Address addressTest = new Address("Nygatan 1", "123 45", "Växjö");
    private StorageSection storageSectionTest = new StorageSection("A_01", addressTest);

    CarStatus carStatusTest = new CarStatus("New car");


    @BeforeEach
    public void setUp(){

        Car testCar = new Car(regNumberTest, regDateTest, brandNameTest, serviceHistoryTest, storageSectionTest);
        testCar.addCarStatus(carStatusTest);

        testCarWithId = carRepoTest.save(testCar);
        carId = testCarWithId.getId();
    }

    @Test
    public void testCar_successfully_created(){

        Optional<Car> foundCar = carRepoTest.findById(carId);

        assertEquals(foundCar.get(), testCarWithId);
    }

    @Test
    public void successfully_findByRegNumber(){

       Optional<Car> foundCar = carRepoTest.findByRegNumber(regNumberTest);

       assertEquals(foundCar.get(), testCarWithId);
    }

    @Test
    public void successfully_findByServiceHistoryHistory(){

        Optional<Car> foundCar = carRepoTest.findByServiceHistoryHistory("New Tires");

        assertEquals(foundCar.get(), testCarWithId);
    }




}
