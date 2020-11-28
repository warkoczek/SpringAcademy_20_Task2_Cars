package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MeteoDTO;

import java.util.List;

public interface MeteoService {
    List<MeteoDTO> getAllRecords();
    void save();
}
