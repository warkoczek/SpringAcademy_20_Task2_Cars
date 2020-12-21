package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Color;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getCars_Should_Return_List_Size_3() throws Exception {
        //given
        mockMvc.perform(get("/cars").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
        //when
        //then

    }

    @Test
    void getCarById_Should_Return_Car_Model_Volkswagen_For_Id_2() throws Exception {
        mockMvc.perform(get("/cars/car/{id}", 2).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.model", Is.is("Clio")));
    }

    @Test
    void getCarsByColor() throws Exception {
        mockMvc.perform(get("/cars/color?color=BLACK").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }

    @Test
    void addCar_Should_Add_Car_And_Return_HttpStatus__isCreated_201() throws Exception {
        Car car = new Car(4l,"Lexus", "100", Color.GREEN);
        String jsonRequest = objectMapper.writeValueAsString(car);
        mockMvc.perform(post("/cars/add").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andReturn();
    }
    @Test
    void addCar_Should_Add_Car_And_Return_HttpStatus__isCreated_201_And_List_Size_4() throws Exception {
        Car car = new Car(4l,"Lexus", "100", Color.GREEN);
        String jsonRequest = objectMapper.writeValueAsString(car);
        mockMvc.perform(post("/cars/add").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/cars").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)));
    }

    @Test
    void modifyCar() {
    }

    @Test
    void modifyCarPartially() {
    }

    @Test
    void deleteCar() {
    }


}
