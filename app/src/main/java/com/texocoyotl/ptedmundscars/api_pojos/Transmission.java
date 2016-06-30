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
        "id",
        "name",
        "equipmentType",
        "transmissionType",
        "numberOfSpeeds"
})
public class Transmission {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("equipmentType")
    private String equipmentType;
    @JsonProperty("transmissionType")
    private String transmissionType;
    @JsonProperty("numberOfSpeeds")
    private String numberOfSpeeds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The equipmentType
     */
    @JsonProperty("equipmentType")
    public String getEquipmentType() {
        return equipmentType;
    }

    /**
     *
     * @param equipmentType
     * The equipmentType
     */
    @JsonProperty("equipmentType")
    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    /**
     *
     * @return
     * The transmissionType
     */
    @JsonProperty("transmissionType")
    public String getTransmissionType() {
        return transmissionType;
    }

    /**
     *
     * @param transmissionType
     * The transmissionType
     */
    @JsonProperty("transmissionType")
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    /**
     *
     * @return
     * The numberOfSpeeds
     */
    @JsonProperty("numberOfSpeeds")
    public String getNumberOfSpeeds() {
        return numberOfSpeeds;
    }

    /**
     *
     * @param numberOfSpeeds
     * The numberOfSpeeds
     */
    @JsonProperty("numberOfSpeeds")
    public void setNumberOfSpeeds(String numberOfSpeeds) {
        this.numberOfSpeeds = numberOfSpeeds;
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
        return "Transmission{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", numberOfSpeeds='" + numberOfSpeeds + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
