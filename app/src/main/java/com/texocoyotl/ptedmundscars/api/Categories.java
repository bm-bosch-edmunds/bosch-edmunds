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
        "market",
        "EPAClass",
        "vehicleSize",
        "primaryBodyType",
        "vehicleStyle",
        "vehicleType"
})
public class Categories {

    @JsonProperty("market")
    private String market;
    @JsonProperty("EPAClass")
    private String ePAClass;
    @JsonProperty("vehicleSize")
    private String vehicleSize;
    @JsonProperty("primaryBodyType")
    private String primaryBodyType;
    @JsonProperty("vehicleStyle")
    private String vehicleStyle;
    @JsonProperty("vehicleType")
    private String vehicleType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The market
     */
    @JsonProperty("market")
    public String getMarket() {
        return market;
    }

    /**
     *
     * @param market
     * The market
     */
    @JsonProperty("market")
    public void setMarket(String market) {
        this.market = market;
    }

    /**
     *
     * @return
     * The ePAClass
     */
    @JsonProperty("EPAClass")
    public String getEPAClass() {
        return ePAClass;
    }

    /**
     *
     * @param ePAClass
     * The EPAClass
     */
    @JsonProperty("EPAClass")
    public void setEPAClass(String ePAClass) {
        this.ePAClass = ePAClass;
    }

    /**
     *
     * @return
     * The vehicleSize
     */
    @JsonProperty("vehicleSize")
    public String getVehicleSize() {
        return vehicleSize;
    }

    /**
     *
     * @param vehicleSize
     * The vehicleSize
     */
    @JsonProperty("vehicleSize")
    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    /**
     *
     * @return
     * The primaryBodyType
     */
    @JsonProperty("primaryBodyType")
    public String getPrimaryBodyType() {
        return primaryBodyType;
    }

    /**
     *
     * @param primaryBodyType
     * The primaryBodyType
     */
    @JsonProperty("primaryBodyType")
    public void setPrimaryBodyType(String primaryBodyType) {
        this.primaryBodyType = primaryBodyType;
    }

    /**
     *
     * @return
     * The vehicleStyle
     */
    @JsonProperty("vehicleStyle")
    public String getVehicleStyle() {
        return vehicleStyle;
    }

    /**
     *
     * @param vehicleStyle
     * The vehicleStyle
     */
    @JsonProperty("vehicleStyle")
    public void setVehicleStyle(String vehicleStyle) {
        this.vehicleStyle = vehicleStyle;
    }

    /**
     *
     * @return
     * The vehicleType
     */
    @JsonProperty("vehicleType")
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     *
     * @param vehicleType
     * The vehicleType
     */
    @JsonProperty("vehicleType")
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
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
        return "Categories{" +
                "market='" + market + '\'' +
                ", ePAClass='" + ePAClass + '\'' +
                ", vehicleSize='" + vehicleSize + '\'' +
                ", primaryBodyType='" + primaryBodyType + '\'' +
                ", vehicleStyle='" + vehicleStyle + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
