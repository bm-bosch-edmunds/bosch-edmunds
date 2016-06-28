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
        "years"
})
public class Model {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("niceName")
    private String niceName;
    @JsonProperty("years")
    private List<Year> years = new ArrayList<Year>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
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
     *     The years
     */
    @JsonProperty("years")
    public List<Year> getYears() {
        return years;
    }

    /**
     *
     * @param years
     *     The years
     */
    @JsonProperty("years")
    public void setYears(List<Year> years) {
        this.years = years;
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
        return "Model{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", niceName='" + niceName + '\'' +
                ", years=" + years +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}

