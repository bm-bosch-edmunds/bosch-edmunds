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
        "compressionRatio",
        "cylinder",
        "size",
        "displacement",
        "configuration",
        "fuelType",
        "horsepower",
        "torque",
        "totalValves",
        "type",
        "code",
        "compressorType",
        "rpm",
        "valve"
})
public class Engine {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("equipmentType")
    private String equipmentType;
    @JsonProperty("compressionRatio")
    private Double compressionRatio;
    @JsonProperty("cylinder")
    private Integer cylinder;
    @JsonProperty("size")
    private Double size;
    @JsonProperty("displacement")
    private Double displacement;
    @JsonProperty("configuration")
    private String configuration;
    @JsonProperty("fuelType")
    private String fuelType;
    @JsonProperty("horsepower")
    private Integer horsepower;
    @JsonProperty("torque")
    private Integer torque;
    @JsonProperty("totalValves")
    private Integer totalValves;
    @JsonProperty("type")
    private String type;
    @JsonProperty("code")
    private String code;
    @JsonProperty("compressorType")
    private String compressorType;
    @JsonProperty("rpm")
    private Rpm rpm;
    @JsonProperty("valve")
    private Valve valve;
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
     * The compressionRatio
     */
    @JsonProperty("compressionRatio")
    public Double getCompressionRatio() {
        return compressionRatio;
    }

    /**
     *
     * @param compressionRatio
     * The compressionRatio
     */
    @JsonProperty("compressionRatio")
    public void setCompressionRatio(Double compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    /**
     *
     * @return
     * The cylinder
     */
    @JsonProperty("cylinder")
    public Integer getCylinder() {
        return cylinder;
    }

    /**
     *
     * @param cylinder
     * The cylinder
     */
    @JsonProperty("cylinder")
    public void setCylinder(Integer cylinder) {
        this.cylinder = cylinder;
    }

    /**
     *
     * @return
     * The size
     */
    @JsonProperty("size")
    public Double getSize() {
        return size;
    }

    /**
     *
     * @param size
     * The size
     */
    @JsonProperty("size")
    public void setSize(Double size) {
        this.size = size;
    }

    /**
     *
     * @return
     * The displacement
     */
    @JsonProperty("displacement")
    public Double getDisplacement() {
        return displacement;
    }

    /**
     *
     * @param displacement
     * The displacement
     */
    @JsonProperty("displacement")
    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    /**
     *
     * @return
     * The configuration
     */
    @JsonProperty("configuration")
    public String getConfiguration() {
        return configuration;
    }

    /**
     *
     * @param configuration
     * The configuration
     */
    @JsonProperty("configuration")
    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    /**
     *
     * @return
     * The fuelType
     */
    @JsonProperty("fuelType")
    public String getFuelType() {
        return fuelType;
    }

    /**
     *
     * @param fuelType
     * The fuelType
     */
    @JsonProperty("fuelType")
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

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

    /**
     *
     * @return
     * The totalValves
     */
    @JsonProperty("totalValves")
    public Integer getTotalValves() {
        return totalValves;
    }

    /**
     *
     * @param totalValves
     * The totalValves
     */
    @JsonProperty("totalValves")
    public void setTotalValves(Integer totalValves) {
        this.totalValves = totalValves;
    }

    /**
     *
     * @return
     * The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The code
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The compressorType
     */
    @JsonProperty("compressorType")
    public String getCompressorType() {
        return compressorType;
    }

    /**
     *
     * @param compressorType
     * The compressorType
     */
    @JsonProperty("compressorType")
    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }

    /**
     *
     * @return
     * The rpm
     */
    @JsonProperty("rpm")
    public Rpm getRpm() {
        return rpm;
    }

    /**
     *
     * @param rpm
     * The rpm
     */
    @JsonProperty("rpm")
    public void setRpm(Rpm rpm) {
        this.rpm = rpm;
    }

    /**
     *
     * @return
     * The valve
     */
    @JsonProperty("valve")
    public Valve getValve() {
        return valve;
    }

    /**
     *
     * @param valve
     * The valve
     */
    @JsonProperty("valve")
    public void setValve(Valve valve) {
        this.valve = valve;
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
        return "Engine{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", compressionRatio=" + compressionRatio +
                ", cylinder=" + cylinder +
                ", size=" + size +
                ", displacement=" + displacement +
                ", configuration='" + configuration + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", horsepower=" + horsepower +
                ", torque=" + torque +
                ", totalValves=" + totalValves +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", compressorType='" + compressorType + '\'' +
                ", rpm=" + rpm +
                ", valve=" + valve +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}