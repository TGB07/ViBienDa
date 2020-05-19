
package aiss.model.foursquare.list;

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
    "createdAt",
    "tip",
    "venue",
    "index",
    "isNew"
})
public class Item_ {

    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private Integer createdAt;
    @JsonProperty("tip")
    private Tip tip;
    @JsonProperty("venue")
    private Venue venue;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("isNew")
    private Boolean isNew;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("createdAt")
    public Integer getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("tip")
    public Tip getTip() {
        return tip;
    }

    @JsonProperty("tip")
    public void setTip(Tip tip) {
        this.tip = tip;
    }

    @JsonProperty("venue")
    public Venue getVenue() {
        return venue;
    }

    @JsonProperty("venue")
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    @JsonProperty("isNew")
    public Boolean getIsNew() {
        return isNew;
    }

    @JsonProperty("isNew")
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
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
