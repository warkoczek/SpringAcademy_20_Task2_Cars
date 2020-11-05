package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public enum Color {
    @JsonProperty("BLACK")BLACK,
    @JsonProperty("WHITE")WHITE,
    @JsonProperty("SILVER")SILVER,
    @JsonProperty("RED")RED,
    @JsonProperty("VIOLET")VIOLET,
    @JsonProperty("GREEN")GREEN,
    @JsonProperty("YELLOW")YELLOW,
    @JsonProperty("GRAY")GRAY,
    @JsonProperty("GOLD")GOLD,
}
