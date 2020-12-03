package pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.reader;

import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CSVFileReaderImpl implements FileReader {


    @Override
    public List<User> read(String path) {
        List<User> users = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))){
            String[] headers = bufferedReader.readLine().split(";");
            String record;
            while((record = bufferedReader.readLine()) != null){
                String[] tokens = record.split(";");
                User user = createUser(headers, tokens);
                users.add(user);
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return users;
    }

    private User createUser(String[] headers, String[] tokens) {
        User user = new User();
        for(int h=0; h < headers.length-1; h++){
            if("id".equals(headers[h])){
                user.setId(Long.parseLong(tokens[h]));
            }
            if("first_name".equals(headers[h])){
                user.setFirst_name(tokens[h]);
            }
            if("last_name".equals(headers[h])){
                user.setLast_name(tokens[h]);
            }
            if("gender".equals(headers[h])){
                user.setGender(tokens[h]);
            }
            if("ip_address".equals(headers[h])){
                user.setIp_address(tokens[h]);
            }
        }
        return user;
    }
    /*
    @Override
    public List<User> read(String path){
        List<User> users = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))){
            users = bufferedReader.lines().skip(1).map().collect(Collectors.toList());
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }*/
}
