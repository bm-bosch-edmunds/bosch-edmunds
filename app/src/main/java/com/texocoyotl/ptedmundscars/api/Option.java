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
        "id",
        "name",
        "equipmentType",
        "manufactureOptionName",
        "manufactureOptionCode",
        "colorChips"
})
public class Option {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("equipmentType")
    private String equipmentType;
    @JsonProperty("manufactureOptionName")
    private String manufactureOptionName;
    @JsonProperty("manufactureOptionCode")
    private String manufactureOptionCode;
    @JsonProperty("colorChips")
    private ColorChips colorChips;
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
     * The manufactureOptionName
     */
    @JsonProperty("manufactureOptionName")
    public String getManufactureOptionName() {
        return manufactureOptionName;
    }

    /**
     *
     * @param manufactureOptionName
     * The manufactureOptionName
     */
    @JsonProperty("manufactureOptionName")
    public void setManufactureOptionName(String manufactureOptionName) {
        this.manufactureOptionName = manufactureOptionName;
    }

    /**
     *
     * @return
     * The manufactureOptionCode
     */
    @JsonProperty("manufactureOptionCode")
    public String getManufactureOptionCode() {
        return manufactureOptionCode;
    }

    /**
     *
     * @param manufactureOptionCode
     * The manufactureOptionCode
     */
    @JsonProperty("manufactureOptionCode")
    public void setManufactureOptionCode(String manufactureOptionCode) {
        this.manufactureOptionCode = manufactureOptionCode;
    }

    /**
     *
     * @return
     * The colorChips
     */
    @JsonProperty("colorChips")
    public ColorChips getColorChips() {
        return colorChips;
    }

    /**
     *
     * @param colorChips
     * The colorChips
     */
    @JsonProperty("colorChips")
    public void setColorChips(ColorChips colorChips) {
        this.colorChips = colorChips;
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
        return "Option{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", manufactureOptionName='" + manufactureOptionName + '\'' +
                ", manufactureOptionCode='" + manufactureOptionCode + '\'' +
                ", colorChips=" + colorChips +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
