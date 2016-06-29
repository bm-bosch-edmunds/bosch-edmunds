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
        "submodel",
        "trim"
})
public class Style {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("submodel")
    private Submodel submodel;
    @JsonProperty("trim")
    private String trim;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
