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
        "makes",
        "makesCount"
})
public class CarsResult {

    @JsonProperty("makes")
    private List<Make> makes = new ArrayList<Make>();
    @JsonProperty("makesCount")
    private Integer makesCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The makes
     */
    @JsonProperty("makes")
    public List<Make> getMakes() {
        return makes;
    }

    /**
     *
     * @param makes
     *     The makes
     */
    @JsonProperty("makes")
    public void setMakes(List<Make> makes) {
        this.makes = makes;
    }

    /**
     *
     * @return
     *     The makesCount
     */
    @JsonProperty("makesCount")
    public Integer getMakesCount() {
        return makesCount;
    }

    /**
     *
     * @param makesCount
     *     The makesCount
     */
    @JsonProperty("makesCount")
    public void setMakesCount(Integer makesCount) {
        this.makesCount = makesCount;
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
        return "CarsResult{" +
                "makes=" + makes +
                ", makesCount=" + makesCount +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
