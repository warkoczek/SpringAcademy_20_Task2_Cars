package pl.warkoczewski.SpringAcademy_20_Task2_Cars.fetcher;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.faceObject.FaceObject;

import java.util.Optional;

public interface FaceData {
    Optional<FaceObject> getFaceData(String url);
}
