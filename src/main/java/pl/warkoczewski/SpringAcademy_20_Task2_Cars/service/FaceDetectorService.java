package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.faceObject.FaceObject;

public interface FaceDetectorService {
    FaceObject[] getFaceFeatures(String url);
}
