package pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Place;

import java.util.List;

public interface PlaceFetcher {
    List<Place> getPlaces();
}
