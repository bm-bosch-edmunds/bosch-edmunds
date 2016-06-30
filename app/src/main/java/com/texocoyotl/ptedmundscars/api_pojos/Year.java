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
        "id",
        "year",
        "styles"
})
public class Year {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("styles")
    private List<Style> styles = new ArrayList<Style>();
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
     * The year
     */
    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    /**
     *
     * @param year
     * The year
     */
    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     *
     * @return
     * The styles
     */
    @JsonProperty("styles")
    public List<Style> getStyles() {
        return styles;
    }

    /**
     *
     * @param styles
     * The styles
     */
    @JsonProperty("styles")
    public void setStyles(List<Style> styles) {
        this.styles = styles;
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
        return "Year{" +
                "id=" + id +
                ", year=" + year +
                ", styles=" + styles +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
