package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Method;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MethodRepository {
    private final List<Method> methods;
    public MethodRepository() {
        methods = new ArrayList<>();
        methods.add(new Method("AddAllToMySQLDB", "792", "608", "862", "696"));
        methods.add(new Method("AddAllToMongoDB", "823", "810", "834", "790"));
        methods.add(new Method("FindAllFromMySQLDB", "191", "218", "187", "151"));
        methods.add(new Method("FindAllFromMongoDB", "108", "189", "99", "155"));
    }

    public List<Method> getMethods() {
        return methods;
    }
}
