package com.texocoyotl.ptedmundscars.api_pojos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
        "make",
        "model",
        "engine",
        "transmission",
        "drivenWheels",
        "numOfDoors",
        "options",
        "colors",
        "manufacturerCode",
        "price",
        "categories",
        "id",
        "name",
        "year",
        "submodel",
        "trim",
        "states",
        "squishVins",
        "MPG"
})
public class Style {

    @JsonProperty("make")
    private Make make;
    @JsonProperty("model")
    private Model model;
    @JsonProperty("engine")
    private Engine engine;
    @JsonProperty("transmission")
    private Transmission transmission;
    @JsonProperty("drivenWheels")
    private String drivenWheels;
    @JsonProperty("numOfDoors")
    private String numOfDoors;
    @JsonProperty("options")
    private List<Object> options = new ArrayList<Object>();
    @JsonProperty("colors")
    private List<Color> colors = new ArrayList<Color>();
    @JsonProperty("manufacturerCode")
    private String manufacturerCode;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("categories")
    private Categories categories;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("year")
    private Year year;
    @JsonProperty("submodel")
    private Submodel submodel;
    @JsonProperty("trim")
    private String trim;
    @JsonProperty("states")
    private List<String> states = new ArrayList<String>();
    @JsonProperty("squishVins")
    private List<String> squishVins = new ArrayList<String>();
    @JsonProperty("MPG")
    private MPG mPG;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The make
     */
    @JsonProperty("make")
    public Make getMake() {
        return make;
    }

    /**
     *
     * @param make
     * The make
     */
    @JsonProperty("make")
    public void setMake(Make make) {
        this.make = make;
    }

    /**
     *
     * @return
     * The model
     */
    @JsonProperty("model")
    public Model getModel() {
        return model;
    }

    /**
     *
     * @param model
     * The model
     */
    @JsonProperty("model")
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     *
     * @return
     * The engine
     */
    @JsonProperty("engine")
    public Engine getEngine() {
        return engine;
    }

    /**
     *
     * @param engine
     * The engine
     */
    @JsonProperty("engine")
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     *
     * @return
     * The transmission
     */
    @JsonProperty("transmission")
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     *
     * @param transmission
     * The transmission
     */
    @JsonProperty("transmission")
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    /**
     *
     * @return
     * The drivenWheels
     */
    @JsonProperty("drivenWheels")
    public String getDrivenWheels() {
        return drivenWheels;
    }

    /**
     *
     * @param drivenWheels
     * The drivenWheels
     */
    @JsonProperty("drivenWheels")
    public void setDrivenWheels(String drivenWheels) {
        this.drivenWheels = drivenWheels;
    }

    /**
     *
     * @return
     * The numOfDoors
     */
    @JsonProperty("numOfDoors")
    public String getNumOfDoors() {
        return numOfDoors;
    }

    /**
     *
     * @param numOfDoors
     * The numOfDoors
     */
    @JsonProperty("numOfDoors")
    public void setNumOfDoors(String numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    /**
     *
     * @return
     * The options
     */
    @JsonProperty("options")
    public List<Object> getOptions() {
        return options;
    }

    /**
     *
     * @param options
     * The options
     */
    @JsonProperty("options")
    public void setOptions(List<Object> options) {
        this.options = options;
    }

    /**
     *
     * @return
     * The colors
     */
    @JsonProperty("colors")
    public List<Color> getColors() {
        return colors;
    }

    /**
     *
     * @param colors
     * The colors
     */
    @JsonProperty("colors")
    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    /**
     *
     * @return
     * The manufacturerCode
     */
    @JsonProperty("manufacturerCode")
    public String getManufacturerCode() {
        return manufacturerCode;
    }

    /**
     *
     * @param manufacturerCode
     * The manufacturerCode
     */
    @JsonProperty("manufacturerCode")
    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    /**
     *
     * @return
     * The price
     */
    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The categories
     */
    @JsonProperty("categories")
    public Categories getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    @JsonProperty("categories")
    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    /**
     *
     * @return
     * The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
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
     * The year
     */
    @JsonProperty("year")
    public Year getYear() {
        return year;
    }

    /**
     *
     * @param year
     * The year
     */
    @JsonProperty("year")
    public void setYear(Year year) {
        this.year = year;
    }

    /**
     *
     * @return
     * The submodel
     */
    @JsonProperty("submodel")
    public Submodel getSubmodel() {
        return submodel;
    }

    /**
     *
     * @param submodel
     * The submodel
     */
    @JsonProperty("submodel")
    public void setSubmodel(Submodel submodel) {
        this.submodel = submodel;
    }

    /**
     *
     * @return
     * The trim
     */
    @JsonProperty("trim")
    public String getTrim() {
        return trim;
    }

    /**
     *
     * @param trim
     * The trim
     */
    @JsonProperty("trim")
    public void setTrim(String trim) {
        this.trim = trim;
    }

    /**
     *
     * @return
     * The states
     */
    @JsonProperty("states")
    public List<String> getStates() {
        return states;
    }

    /**
     *
     * @param states
     * The states
     */
    @JsonProperty("states")
    public void setStates(List<String> states) {
        this.states = states;
    }

    /**
     *
     * @return
     * The squishVins
     */
    @JsonProperty("squishVins")
    public List<String> getSquishVins() {
        return squishVins;
    }

    /**
     *
     * @param squishVins
     * The squishVins
     */
    @JsonProperty("squishVins")
    public void setSquishVins(List<String> squishVins) {
        this.squishVins = squishVins;
    }

    /**
     *
     * @return
     * The mPG
     */
    @JsonProperty("MPG")
    public MPG getMPG() {
        return mPG;
    }

    /**
     *
     * @param mPG
     * The MPG
     */
    @JsonProperty("MPG")
    public void setMPG(MPG mPG) {
        this.mPG = mPG;
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
        return "Style{" +
                "make=" + make +
                ", model=" + model +
                ", engine=" + engine +
                ", transmission=" + transmission +
                ", drivenWheels='" + drivenWheels + '\'' +
                ", numOfDoors='" + numOfDoors + '\'' +
                ", options=" + options +
                ", colors=" + colors +
                ", manufacturerCode='" + manufacturerCode + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", submodel=" + submodel +
                ", trim='" + trim + '\'' +
                ", states=" + states +
                ", squishVins=" + squishVins +
                ", mPG=" + mPG +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}