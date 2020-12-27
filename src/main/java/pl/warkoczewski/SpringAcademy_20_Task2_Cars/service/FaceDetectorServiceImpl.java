package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.fetcher.FaceDataImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.faceObject.FaceObject;

@Service
public class FaceDetectorServiceImpl implements FaceDetectorService {
    private final FaceDataImpl faceData;

    public FaceDetectorServiceImpl(FaceDataImpl faceData) {
        this.faceData = faceData;
    }

    @Override
    public FaceObject[] getFaceFeatures(String url) {
        return faceData.getFaceData();
    }
}
