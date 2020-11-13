package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

@Component
public class Exchange {
    private String baseCurrency;
    private String exchangeCurrency;
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double exchangeRate;
    private String date;

    public Exchange() {
    }

    public Exchange(String baseCurrency, String exchangeCurrency, Double exchangeRate, String date) {
        this.baseCurrency = baseCurrency;
        this.exchangeCurrency = exchangeCurrency;
        this.exchangeRate = exchangeRate;
        this.date = date;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getExchangeCurrency() {
        return exchangeCurrency;
    }

    public void setExchangeCurrency(String exchangeCurrency) {
        this.exchangeCurrency = exchangeCurrency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
