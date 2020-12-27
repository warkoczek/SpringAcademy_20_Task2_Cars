package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.ImageUrlDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.faceObject.FaceObject;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.FaceDetectorServiceImpl;

import java.util.Optional;

@Controller
@RequestMapping("/face")
public class FaceDetectorController {
    private final FaceDetectorServiceImpl faceDetectorService;

    public FaceDetectorController(FaceDetectorServiceImpl faceDetectorService) {
        this.faceDetectorService = faceDetectorService;
    }
    @GetMapping
    public String getFaceDetectorHomePage(){
        return "/face/home";
    }
    @GetMapping("/detector")
    public String displayFaceDetectorPage(Model model){
        model.addAttribute("imageUrlDTO", new ImageUrlDTO());
        return "/face/detector";
    }

    @PostMapping("/detector")
    public String processImageUrlForm(@ModelAttribute ImageUrlDTO imageUrlDTO, Model model){
        Optional<FaceObject> faceFeatures = faceDetectorService.getFaceFeatures(imageUrlDTO);
        faceFeatures.ifPresent(faceObject -> model.addAttribute("faceFeatures", faceObject));
        return "/face/faceFeatures";
    }


}
