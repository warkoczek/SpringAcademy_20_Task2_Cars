package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.User;

public interface SQLUserRepository extends JpaRepository<User, Long> {

}
