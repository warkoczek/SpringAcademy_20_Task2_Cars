package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum  Topic {
    @JsonProperty("GENERAL")GENERAL,
    @JsonProperty("EVENT")EVENT,
    @JsonProperty("REMINDER")REMINDER,
    @JsonProperty("HOROSCOPE")HOROSCOPE,
    @JsonProperty("PAYMENT")PAYMENT,
    @JsonProperty("COST")COST,
    @JsonProperty("DUTY")DUTY,
    @JsonProperty("DRAFT")DRAFT
}
