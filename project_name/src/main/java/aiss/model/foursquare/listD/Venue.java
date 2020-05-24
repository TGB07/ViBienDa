
package aiss.model.foursquare.listD;

import java.io.Serializable;
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
    "contact",
    "location",
    "verified",
    "stats",
    "url",
    "rating",
    "ratingColor",
    "ratingSignals",
    "allowMenuUrlEdit",
    "beenHere"
})
public class Venue implements Serializable{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("url")
    private String url;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("ratingColor")
    private String ratingColor;
    @JsonProperty("ratingSignals")
    private Integer ratingSignals;
    @JsonProperty("allowMenuUrlEdit")
    private Boolean allowMenuUrlEdit;
    @JsonProperty("beenHere")
    private BeenHere beenHere;
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @JsonProperty("ratingColor")
    public String getRatingColor() {
        return ratingColor;
    }

    @JsonProperty("ratingColor")
    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    @JsonProperty("ratingSignals")
    public Integer getRatingSignals() {
        return ratingSignals;
    }

    @JsonProperty("ratingSignals")
    public void setRatingSignals(Integer ratingSignals) {
        this.ratingSignals = ratingSignals;
    }

    @JsonProperty("allowMenuUrlEdit")
    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    @JsonProperty("allowMenuUrlEdit")
    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    @JsonProperty("beenHere")
    public BeenHere getBeenHere() {
        return beenHere;
    }

    @JsonProperty("beenHere")
    public void setBeenHere(BeenHere beenHere) {
        this.beenHere = beenHere;
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
