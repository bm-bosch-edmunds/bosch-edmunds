package com.texocoyotl.ptedmundscars.api;


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
        "id",
        "name",
        "niceName",
        "models"
})
public class Make {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("niceName")
    private String niceName;
    @JsonProperty("models")
    private List<Model> models = new ArrayList<Model>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The niceName
     */
    @JsonProperty("niceName")
    public String getNiceName() {
        return niceName;
    }

    /**
     *
     * @param niceName
     *     The niceName
     */
    @JsonProperty("niceName")
    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    /**
     *
     * @return
     *     The models
     */
    @JsonProperty("models")
    public List<Model> getModels() {
        return models;
    }

    /**
     *
     * @param models
     *     The models
     */
    @JsonProperty("models")
    public void setModels(List<Model> models) {
        this.models = models;
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
        return "Make{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", niceName='" + niceName + '\'' +
                ", models=" + models +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
