package se.lexicon.simon.car_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.simon.car_management.dto.CarDTO;
import se.lexicon.simon.car_management.repository.CarRepo;

import java.util.Collection;

@RestController
@RequestMapping("/cars")
public class CarController {

    CarRepo carRepo;

    @Autowired
    public CarController(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping()
    public ResponseEntity<Collection<CarDTO>> findAll(){

        return ResponseEntity.ok(carRepo.findAllDTOs());
    }

}
