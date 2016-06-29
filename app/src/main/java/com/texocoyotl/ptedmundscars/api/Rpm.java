package com.texocoyotl.ptedmundscars.api;

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
        "horsepower",
        "torque"
})
public class Rpm {

    @JsonProperty("horsepower")
    private Integer horsepower;
    @JsonProperty("torque")
    private Integer torque;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The horsepower
     */
    @JsonProperty("horsepower")
    public Integer getHorsepower() {
        return horsepower;
    }

    /**
     *
     * @param horsepower
     * The horsepower
     */
    @JsonProperty("horsepower")
    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    /**
     *
     * @return
     * The torque
     */
    @JsonProperty("torque")
    public Integer getTorque() {
        return torque;
    }

    /**
     *
     * @param torque
     * The torque
     */
    @JsonProperty("torque")
    public void setTorque(Integer torque) {
        this.torque = torque;
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
        return "Rpm{" +
                "horsepower=" + horsepower +
                ", torque=" + torque +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
