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
        "children",
        "id",
        "site",
        "authorNames",
        "captionTranscript",
        "type",
        "subType",
        "shotTypeAbbreviation",
        "photoSrcs",
        "source",
        "vdpOrder"
})
public class Gallery {

    @JsonProperty("children")
    private List<Object> children = new ArrayList<Object>();
    @JsonProperty("id")
    private String id;
    @JsonProperty("site")
    private String site;
    @JsonProperty("authorNames")
    private List<String> authorNames = new ArrayList<String>();
    @JsonProperty("captionTranscript")
    private String captionTranscript;
    @JsonProperty("type")
    private String type;
    @JsonProperty("subType")
    private String subType;
    @JsonProperty("shotTypeAbbreviation")
    private String shotTypeAbbreviation;
    @JsonProperty("photoSrcs")
    private List<String> photoSrcs = new ArrayList<String>();
    @JsonProperty("source")
    private String source;
    @JsonProperty("vdpOrder")
    private Integer vdpOrder;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The children
     */
    @JsonProperty("children")
    public List<Object> getChildren() {
        return children;
    }

    /**
     *
     * @param children
     * The children
     */
    @JsonProperty("children")
    public void setChildren(List<Object> children) {
        this.children = children;
    }

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
     * The site
     */
    @JsonProperty("site")
    public String getSite() {
        return site;
    }

    /**
     *
     * @param site
     * The site
     */
    @JsonProperty("site")
    public void setSite(String site) {
        this.site = site;
    }

    /**
     *
     * @return
     * The authorNames
     */
    @JsonProperty("authorNames")
    public List<String> getAuthorNames() {
        return authorNames;
    }

    /**
     *
     * @param authorNames
     * The authorNames
     */
    @JsonProperty("authorNames")
    public void setAuthorNames(List<String> authorNames) {
        this.authorNames = authorNames;
    }

    /**
     *
     * @return
     * The captionTranscript
     */
    @JsonProperty("captionTranscript")
    public String getCaptionTranscript() {
        return captionTranscript;
    }

    /**
     *
     * @param captionTranscript
     * The captionTranscript
     */
    @JsonProperty("captionTranscript")
    public void setCaptionTranscript(String captionTranscript) {
        this.captionTranscript = captionTranscript;
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
     * The subType
     */
    @JsonProperty("subType")
    public String getSubType() {
        return subType;
    }

    /**
     *
     * @param subType
     * The subType
     */
    @JsonProperty("subType")
    public void setSubType(String subType) {
        this.subType = subType;
    }

    /**
     *
     * @return
     * The shotTypeAbbreviation
     */
    @JsonProperty("shotTypeAbbreviation")
    public String getShotTypeAbbreviation() {
        return shotTypeAbbreviation;
    }

    /**
     *
     * @param shotTypeAbbreviation
     * The shotTypeAbbreviation
     */
    @JsonProperty("shotTypeAbbreviation")
    public void setShotTypeAbbreviation(String shotTypeAbbreviation) {
        this.shotTypeAbbreviation = shotTypeAbbreviation;
    }

    /**
     *
     * @return
     * The photoSrcs
     */
    @JsonProperty("photoSrcs")
    public List<String> getPhotoSrcs() {
        return photoSrcs;
    }

    /**
     *
     * @param photoSrcs
     * The photoSrcs
     */
    @JsonProperty("photoSrcs")
    public void setPhotoSrcs(List<String> photoSrcs) {
        this.photoSrcs = photoSrcs;
    }

    /**
     *
     * @return
     * The source
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     *
     * @param source
     * The source
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     *
     * @return
     * The vdpOrder
     */
    @JsonProperty("vdpOrder")
    public Integer getVdpOrder() {
        return vdpOrder;
    }

    /**
     *
     * @param vdpOrder
     * The vdpOrder
     */
    @JsonProperty("vdpOrder")
    public void setVdpOrder(Integer vdpOrder) {
        this.vdpOrder = vdpOrder;
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

