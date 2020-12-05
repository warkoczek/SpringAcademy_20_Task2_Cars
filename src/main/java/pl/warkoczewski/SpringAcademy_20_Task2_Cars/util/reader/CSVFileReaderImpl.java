package pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.reader;

import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVFileReaderImpl implements FileReader {

    @Override
    public List<User> readForSQL(String path) {
        List<User> users = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            String[] headers = bufferedReader.readLine().split(",");
            String record;
            while((record = bufferedReader.readLine()) != null){
                String[] tokens = record.split(",");
                User user = createUserForSQL(headers, tokens);
                users.add(user);
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return users;
    }
    private User createUserForSQL(String[] headers, String[] tokens) {
        User user = new User();
        for(int h=1; h < headers.length; h++){
            if("first_name".equals(headers[h])){
                user.setFirst_name(tokens[h]);
            }
            if("last_name".equals(headers[h])){
                user.setLast_name(tokens[h]);
            }
            if("email".equals(headers[h])){
                user.setEmail(tokens[h]);
            }
            if("gender".equals(headers[h])){
                user.setGender(tokens[h]);
            }
            if("ip_address;;".equals(headers[h])){
                String ip_address = tokens[h];
                user.setIp_address(ip_address.substring(0, ip_address.length()-2));
            }
        }
        return user;
    }
    @Override
    public List<pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.document.User> readForMongo(String path) {
        List<pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.document.User> users = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            String[] headers = bufferedReader.readLine().split(",");
            String record;
            while((record = bufferedReader.readLine()) != null){
                String[] tokens = record.split(",");
                pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.document.User user = createUserForMongo(headers, tokens);
                users.add(user);
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return users;
    }


    private pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.document.User createUserForMongo(String[] headers, String[] tokens) {
        pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.document.User user = new pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.document.User();
        for(int h=0; h < headers.length; h++){
            if("id".equals(headers[h])){
                user.setId(tokens[h]);
            }
            if("first_name".equals(headers[h])){
                user.setFirst_name(tokens[h]);
            }
            if("last_name".equals(headers[h])){
                user.setLast_name(tokens[h]);
            }
            if("email".equals(headers[h])){
                user.setEmail(tokens[h]);
            }
            if("gender".equals(headers[h])){
                user.setGender(tokens[h]);
            }
            if("ip_address;;".equals(headers[h])){
                String ip_address = tokens[h];
                user.setIp_address(ip_address.substring(0, ip_address.length()-2));
            }
        }
        return user;
    }

    /*
    @Override
    public List<User> readStream(String path){
        List<User> users = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))){
            users = bufferedReader.lines().skip(1).map(this::mapToUser).collect(Collectors.toList());
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return users;
    }

    private User mapToUser(String string){
        User user = new User();
        String[] array = string.split(";");
        user.setFirst_name(array[0]);
        user.setLast_name(array[1]);
        user.setEmail(array[2]);
        user.setGender(array[3]);
        user.setIp_address(array[4]);
        return user;
    }*/
}
