package se.lexicon.simon.car_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.simon.car_management.entity.*;
import se.lexicon.simon.car_management.repository.CarRepo;

import java.time.LocalDate;

@Component
public class CommandLine implements CommandLineRunner {

    CarRepo carRepo;

    @Autowired
    public CommandLine(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    /*
        I made this to show what it may look like when the table is populated.
        This should NOT be considered a test.
        Just for demonstration.
     */
    @Override
    public void run(String... args) throws Exception {

        ServiceHistory serviceHistory = new ServiceHistory("New tires");

        Address address = new Address("Nygatan 1", "123 45", "Växjö");
        StorageSection storageSection = new StorageSection("A_01", address);

        Car car = new Car("ABC123", LocalDate.parse("2020-10-01"),"VOLVO", serviceHistory, storageSection);


        CarStatus carStatusNew = new CarStatus("New");
        CarStatus carStatusRusty = new CarStatus("Rusty");

        car.addCarStatus(carStatusNew);
        car.addCarStatus(carStatusRusty);

        carRepo.save(car);







    }




}
