package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {

    /*
    @Autowired
    MockMvc mockMvc;

    @Test
    void showCars() throws Exception {
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].mark").value("White"));
    }*/
}