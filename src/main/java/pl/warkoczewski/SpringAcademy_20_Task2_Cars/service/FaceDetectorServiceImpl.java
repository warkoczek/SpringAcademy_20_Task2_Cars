package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.ImageUrlDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.fetcher.FaceDataImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.ImageUrl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.faceObject.FaceObject;

import java.util.Optional;

@Service
public class FaceDetectorServiceImpl implements FaceDetectorService {
    private final FaceDataImpl faceData;

    public FaceDetectorServiceImpl(FaceDataImpl faceData) {
        this.faceData = faceData;
    }

    @Override
    public Optional<FaceObject> getFaceFeatures(ImageUrlDTO imageUrlDTO) {
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.setUrl(imageUrlDTO.getUrl());
        String url =  imageUrl.getUrl();
        return faceData.getFaceData(url);
    }
}
