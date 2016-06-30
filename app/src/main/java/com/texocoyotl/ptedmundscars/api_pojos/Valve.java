package com.texocoyotl.ptedmundscars.api_pojos;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
        "timing",
        "gear"
})
public class Valve {

    @JsonProperty("timing")
    private String timing;
    @JsonProperty("gear")
    private String gear;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The timing
     */
    @JsonProperty("timing")
    public String getTiming() {
        return timing;
    }

    /**
     *
     * @param timing
     * The timing
     */
    @JsonProperty("timing")
    public void setTiming(String timing) {
        this.timing = timing;
    }

    /**
     *
     * @return
     * The gear
     */
    @JsonProperty("gear")
    public String getGear() {
        return gear;
    }

    /**
     *
     * @param gear
     * The gear
     */
    @JsonProperty("gear")
    public void setGear(String gear) {
        this.gear = gear;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Valve{" +
                "timing='" + timing + '\'' +
                ", gear='" + gear + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
