package com.sb_tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb_tdd.model.Car;

@RestController	
@RequestMapping("/cars")
public class CarController {

	@Autowired   
	private CarService carService;

//    @Autowired
//    public CarController(CarService carService) {
//        this.carService = carService;
//    }
    
    @GetMapping("/{name}")
    public Car getCar(@PathVariable String name){
        return carService.getCarDetails(name);

    }
}
