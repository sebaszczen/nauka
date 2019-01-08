package testDrivenDevelopment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import testDrivenDevelopment.exceptions.CarNotFoundException;
import testDrivenDevelopment.domain.Car;
import testDrivenDevelopment.service.CarService;

@RestController
public class CarController {

    @Autowired
    private CarService carServie;

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name)
    {
        return carServie.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex) {

    }

}
