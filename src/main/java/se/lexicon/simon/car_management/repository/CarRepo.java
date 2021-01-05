package se.lexicon.simon.car_management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.simon.car_management.dto.CarDTO;
import se.lexicon.simon.car_management.entity.Car;

import java.util.Collection;
import java.util.Optional;


public interface CarRepo extends CrudRepository<Car, Integer> {

    String FIND_ALL = "SELECT new se.lexicon.simon.car_management.dto.CarDTO(car.id, car.regNumber, car.regDate, car.brandName) FROM Car car";

    @Query(FIND_ALL)
    Collection<CarDTO> findAllDTOs();

    Optional<Car> findByRegNumber(String regNumber);

    Optional<Car> findByServiceHistoryHistory(String history);










}
