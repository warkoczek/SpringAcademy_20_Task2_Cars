package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/face")
public class FaceDetectorController {
    @GetMapping
    public String getFaceDetectorHomePage(){
        return "/face/home";
    }
    @GetMapping("/detector")
    public String displayFaceDetectorPage(){
        return "/face/detector";
    }
    @PostMapping("/detector")
    public String processImageUrlForm(){
        return "";
    }


}
