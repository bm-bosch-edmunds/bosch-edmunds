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
        "r",
        "g",
        "b",
        "hex"
})
public class Primary {

    @JsonProperty("r")
    private Integer r;
    @JsonProperty("g")
    private Integer g;
    @JsonProperty("b")
    private Integer b;
    @JsonProperty("hex")
    private String hex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The r
     */
    @JsonProperty("r")
    public Integer getR() {
        return r;
    }

    /**
     *
     * @param r
     * The r
     */
    @JsonProperty("r")
    public void setR(Integer r) {
        this.r = r;
    }

    /**
     *
     * @return
     * The g
     */
    @JsonProperty("g")
    public Integer getG() {
        return g;
    }

    /**
     *
     * @param g
     * The g
     */
    @JsonProperty("g")
    public void setG(Integer g) {
        this.g = g;
    }

    /**
     *
     * @return
     * The b
     */
    @JsonProperty("b")
    public Integer getB() {
        return b;
    }

    /**
     *
     * @param b
     * The b
     */
    @JsonProperty("b")
    public void setB(Integer b) {
        this.b = b;
    }

    /**
     *
     * @return
     * The hex
     */
    @JsonProperty("hex")
    public String getHex() {
        return hex;
    }

    /**
     *
     * @param hex
     * The hex
     */
    @JsonProperty("hex")
    public void setHex(String hex) {
        this.hex = hex;
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
        return "Primary{" +
                "r=" + r +
                ", g=" + g +
                ", b=" + b +
                ", hex='" + hex + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
