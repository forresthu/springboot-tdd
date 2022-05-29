package com.sb_tdd;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sb_tdd.model.Car;


@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getCar_should_return_http_200_given_valid_car_name() throws Exception {

        // arrange - train your mock
        given(carService.getCarDetails(anyString())).willReturn(new Car("hyundai", "hybrid"));

        // act & assert
        mockMvc.perform(get("/cars/hyundai"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("name").value("hyundai"))
               .andExpect(jsonPath("type").value("hybrid"));

        // verify that dependency is invoked
        verify(carService, times(1)).getCarDetails(anyString());
    }

}
