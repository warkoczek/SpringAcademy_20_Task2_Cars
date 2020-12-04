package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.User;

public interface MongoDBUserRepository extends MongoRepository<User, String> {
}
