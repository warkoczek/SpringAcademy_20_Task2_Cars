package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Meteo;

import java.util.Optional;

@Repository
public interface MeteoRepository extends JpaRepository<Meteo, Long> {
    Optional<Meteo> findByLocation(String location);
}
