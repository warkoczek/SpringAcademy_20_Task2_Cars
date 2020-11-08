package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum Color {
    @JsonProperty("BLACK")BLACK("BLACK"),
    @JsonProperty("WHITE")WHITE("WHITE"),
    @JsonProperty("SILVER")SILVER("SILVER"),
    @JsonProperty("RED")RED("RED"),
    @JsonProperty("VIOLET")VIOLET("VIOLET"),
    @JsonProperty("GREEN")GREEN("GREEN"),
    @JsonProperty("YELLOW")YELLOW("YELLOW"),
    @JsonProperty("GRAY")GRAY("GRAY"),
    @JsonProperty("GOLD")GOLD("GOLD")
    ;

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
