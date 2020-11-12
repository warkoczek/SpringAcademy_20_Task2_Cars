package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.exchange.ExchangeService;


@Controller
public class CurrencyController {
    private final ExchangeService exchangeService;

    public CurrencyController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/currencyExchanges")
    public String getRates(Model model){
        model.addAttribute("base", exchangeService.showExchanges().get(0).getBaseCurrency());
        model.addAttribute("exchanges", exchangeService.showExchanges());
        return "currencyExchanges";
    }

}
