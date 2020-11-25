package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.ArticleDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Article;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.ArticleServiceImpl;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleServiceImpl articleService;

    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }
    @GetMapping
    public String displayArticlesPage(Model model){
        model.addAttribute("articles", articleService.showArticles());
        return "article/articles";
    }
    @GetMapping("/update/{article_id}")
    public ModelAndView displayUpdateArticlePage(@PathVariable("article_id") Long article_id, ModelAndView modelAndView){
        ArticleDTO article = articleService.findById(article_id);
        modelAndView.addObject("article", article);
        modelAndView.setViewName("article/update");
        return modelAndView;
    }
    @PostMapping("/update")
    public String processUpdateForm(@ModelAttribute(name = "article") ArticleDTO articleDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "article/update";
        }
        articleService.update(articleDTO);
        return "redirect:";
    }
}
