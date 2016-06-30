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
        "highway",
        "city"
})
public class MPG {

    @JsonProperty("highway")
    private String highway;
    @JsonProperty("city")
    private String city;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The highway
     */
    @JsonProperty("highway")
    public String getHighway() {
        return highway;
    }

    /**
     *
     * @param highway
     * The highway
     */
    @JsonProperty("highway")
    public void setHighway(String highway) {
        this.highway = highway;
    }

    /**
     *
     * @return
     * The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
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
        return "MPG{" +
                "highway='" + highway + '\'' +
                ", city='" + city + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
