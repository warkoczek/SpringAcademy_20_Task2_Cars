package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.ImageUrlDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.faceObject.FaceObject;

import java.util.Optional;

public interface FaceDetectorService {
    Optional<FaceObject> getFaceFeatures(ImageUrlDTO imageUrlDTO);
}
