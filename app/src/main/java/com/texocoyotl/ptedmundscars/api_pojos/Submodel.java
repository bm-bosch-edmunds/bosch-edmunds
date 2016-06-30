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
        "body",
        "modelName",
        "niceName"
})
public class Submodel {

    @JsonProperty("body")
    private String body;
    @JsonProperty("modelName")
    private String modelName;
    @JsonProperty("niceName")
    private String niceName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The body
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     *
     * @param body
     * The body
     */
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    /**
     *
     * @return
     * The modelName
     */
    @JsonProperty("modelName")
    public String getModelName() {
        return modelName;
    }

    /**
     *
     * @param modelName
     * The modelName
     */
    @JsonProperty("modelName")
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     *
     * @return
     * The niceName
     */
    @JsonProperty("niceName")
    public String getNiceName() {
        return niceName;
    }

    /**
     *
     * @param niceName
     * The niceName
     */
    @JsonProperty("niceName")
    public void setNiceName(String niceName) {
        this.niceName = niceName;
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
        return "Submodel{" +
                "body='" + body + '\'' +
                ", modelName='" + modelName + '\'' +
                ", niceName='" + niceName + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}