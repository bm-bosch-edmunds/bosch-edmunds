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
        "baseMSRP",
        "baseInvoice",
        "deliveryCharges",
        "usedTmvRetail",
        "usedPrivateParty",
        "usedTradeIn",
        "estimateTmv"
})
public class Price {

    @JsonProperty("baseMSRP")
    private Double baseMSRP;
    @JsonProperty("baseInvoice")
    private Double baseInvoice;
    @JsonProperty("deliveryCharges")
    private Double deliveryCharges;
    @JsonProperty("usedTmvRetail")
    private Double usedTmvRetail;
    @JsonProperty("usedPrivateParty")
    private Double usedPrivateParty;
    @JsonProperty("usedTradeIn")
    private Double usedTradeIn;
    @JsonProperty("estimateTmv")
    private Boolean estimateTmv;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The baseMSRP
     */
    @JsonProperty("baseMSRP")
    public Double getBaseMSRP() {
        return baseMSRP;
    }

    /**
     *
     * @param baseMSRP
     * The baseMSRP
     */
    @JsonProperty("baseMSRP")
    public void setBaseMSRP(Double baseMSRP) {
        this.baseMSRP = baseMSRP;
    }

    /**
     *
     * @return
     * The baseInvoice
     */
    @JsonProperty("baseInvoice")
    public Double getBaseInvoice() {
        return baseInvoice;
    }

    /**
     *
     * @param baseInvoice
     * The baseInvoice
     */
    @JsonProperty("baseInvoice")
    public void setBaseInvoice(Double baseInvoice) {
        this.baseInvoice = baseInvoice;
    }

    /**
     *
     * @return
     * The deliveryCharges
     */
    @JsonProperty("deliveryCharges")
    public Double getDeliveryCharges() {
        return deliveryCharges;
    }

    /**
     *
     * @param deliveryCharges
     * The deliveryCharges
     */
    @JsonProperty("deliveryCharges")
    public void setDeliveryCharges(Double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    /**
     *
     * @return
     * The usedTmvRetail
     */
    @JsonProperty("usedTmvRetail")
    public Double getUsedTmvRetail() {
        return usedTmvRetail;
    }

    /**
     *
     * @param usedTmvRetail
     * The usedTmvRetail
     */
    @JsonProperty("usedTmvRetail")
    public void setUsedTmvRetail(Double usedTmvRetail) {
        this.usedTmvRetail = usedTmvRetail;
    }

    /**
     *
     * @return
     * The usedPrivateParty
     */
    @JsonProperty("usedPrivateParty")
    public Double getUsedPrivateParty() {
        return usedPrivateParty;
    }

    /**
     *
     * @param usedPrivateParty
     * The usedPrivateParty
     */
    @JsonProperty("usedPrivateParty")
    public void setUsedPrivateParty(Double usedPrivateParty) {
        this.usedPrivateParty = usedPrivateParty;
    }

    /**
     *
     * @return
     * The usedTradeIn
     */
    @JsonProperty("usedTradeIn")
    public Double getUsedTradeIn() {
        return usedTradeIn;
    }

    /**
     *
     * @param usedTradeIn
     * The usedTradeIn
     */
    @JsonProperty("usedTradeIn")
    public void setUsedTradeIn(Double usedTradeIn) {
        this.usedTradeIn = usedTradeIn;
    }

    /**
     *
     * @return
     * The estimateTmv
     */
    @JsonProperty("estimateTmv")
    public Boolean getEstimateTmv() {
        return estimateTmv;
    }

    /**
     *
     * @param estimateTmv
     * The estimateTmv
     */
    @JsonProperty("estimateTmv")
    public void setEstimateTmv(Boolean estimateTmv) {
        this.estimateTmv = estimateTmv;
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
        return "Price{" +
                "baseMSRP=" + baseMSRP +
                ", baseInvoice=" + baseInvoice +
                ", deliveryCharges=" + deliveryCharges +
                ", usedTmvRetail=" + usedTmvRetail +
                ", usedPrivateParty=" + usedPrivateParty +
                ", usedTradeIn=" + usedTradeIn +
                ", estimateTmv=" + estimateTmv +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
