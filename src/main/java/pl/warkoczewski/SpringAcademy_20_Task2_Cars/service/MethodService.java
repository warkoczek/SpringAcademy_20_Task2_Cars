package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Method;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.MethodRepository;

import java.util.List;

@Service
public class MethodService {
    private final MethodRepository methodRepository;

    public MethodService(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }
    public List<Method> getMethods(){
        return methodRepository.getMethods();
    }
}
