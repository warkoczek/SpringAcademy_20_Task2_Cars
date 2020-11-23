package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Color {
    @JsonProperty("BLUE") BLUE,
    @JsonProperty("WHITE") WHITE,
    @JsonProperty("BLACK") BLACK,
    @JsonProperty("RED") RED,
    @JsonProperty("PURPLE") PURPLE,
    @JsonProperty("PINK") PINK,
    @JsonProperty("BROWN") BROWN
}
