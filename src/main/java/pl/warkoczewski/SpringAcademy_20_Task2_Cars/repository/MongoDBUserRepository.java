package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.document.User;

@Repository
public interface MongoDBUserRepository extends MongoRepository<User, String> {

}
