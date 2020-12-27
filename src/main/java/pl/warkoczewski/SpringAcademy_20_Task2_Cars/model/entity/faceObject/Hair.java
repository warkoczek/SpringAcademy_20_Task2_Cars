
package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.faceObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bald",
    "invisible",
    "hairColor"
})
@ToString
public class Hair {

    @JsonProperty("bald")
    private Double bald;
    @JsonProperty("invisible")
    private Boolean invisible;
    @JsonProperty("hairColor")
    private List<HairColor> hairColor = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bald")
    public Double getBald() {
        return bald;
    }

    @JsonProperty("bald")
    public void setBald(Double bald) {
        this.bald = bald;
    }

    @JsonProperty("invisible")
    public Boolean getInvisible() {
        return invisible;
    }

    @JsonProperty("invisible")
    public void setInvisible(Boolean invisible) {
        this.invisible = invisible;
    }

    @JsonProperty("hairColor")
    public List<HairColor> getHairColor() {
        return hairColor;
    }

    @JsonProperty("hairColor")
    public void setHairColor(List<HairColor> hairColor) {
        this.hairColor = hairColor;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
