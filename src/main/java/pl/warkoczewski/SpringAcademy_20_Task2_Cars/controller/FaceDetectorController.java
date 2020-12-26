package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/face")
public class FaceDetectorController {
    @GetMapping("/detector")
    public String displayFaceDetectorPage(){
        return "/face/detector";
    }


}
