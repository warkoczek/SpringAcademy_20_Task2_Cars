package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void getCars_Should_Return_List_Size_4() throws Exception {
        //given
        mockMvc.perform(get("/cars").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)));
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
        mockMvc.perform(get("/cars/color?color=RED").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }
    @Test
    void addCar_Should_Add_Car_And_Return_HttpStatus__isCreated_201_And_Car_Model_100() throws Exception {
        Car car = new Car(5l,"Lexus", "100", Color.GREEN);
        String jsonRequest = objectMapper.writeValueAsString(car);
        mockMvc.perform(post("/cars/add").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/cars/car/{id}", 5).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.model", Is.is("100")));
    }

    @Test
    void modifyCar_Should_Return_Color_BLACK_For_Car_Id_2() throws Exception {
        Car car = new Car(2l, "Renault", "Clio", Color.BLACK);
        String jsonRequest = objectMapper.writeValueAsString(car);
        mockMvc.perform(put("/cars/update").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        mockMvc.perform(get("/cars/car/{id}", 2).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.color", Is.is("BLACK")));
    }
    /*
    @Test
    void modifyCarPartially_Should_Update_Car_Mark_Renault_To_Penault() throws Exception {
        Car car = new Car(2l, "Penault", "Clio", Color.BLACK);
        String jsonRequest = objectMapper.writeValueAsString(car);
        mockMvc.perform(patch("/cars/patchUpdate/{id}", 2).content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        mockMvc.perform(get("/cars/car/{id}", 2).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mark", Is.is("Penault")));
    }*/

    @Test
    void deleteCar_Should_Delete_Car_With_Id_4_And_Return_Status_isOK() throws Exception {
        mockMvc.perform(delete("/cars/delete/{id}", 4).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
