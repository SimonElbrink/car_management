package se.lexicon.simon.car_management.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.simon.car_management.entity.Car;

import java.util.Optional;


public interface CarRepo extends CrudRepository<Car, Integer> {

    Optional<Car> findByRegNumber(String regNumber);

    Optional<Car> findByServiceHistoryHistory(String history);










}
