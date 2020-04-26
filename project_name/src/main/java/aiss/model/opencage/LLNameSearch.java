
package aiss.model.opencage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "documentation",
    "licenses",
    "rate",
    "results",
    "status",
    "stay_informed",
    "thanks",
    "timestamp",
    "total_results"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class LLNameSearch {

    @JsonProperty("documentation")
    private String documentation;
    @JsonProperty("licenses")
    private List<License> licenses = null;
    @JsonProperty("rate")
    private Rate rate;
    @JsonProperty("results")
    private List<Result> results = null;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("stay_informed")
    private StayInformed stayInformed;
    @JsonProperty("thanks")
    private String thanks;
    @JsonProperty("timestamp")
    private Timestamp timestamp;
    @JsonProperty("total_results")
    private Integer totalResults;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("documentation")
    public String getDocumentation() {
        return documentation;
    }

    @JsonProperty("documentation")
    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    @JsonProperty("licenses")
    public List<License> getLicenses() {
        return licenses;
    }

    @JsonProperty("licenses")
    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    @JsonProperty("rate")
    public Rate getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(Rate rate) {
        this.rate = rate;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("stay_informed")
    public StayInformed getStayInformed() {
        return stayInformed;
    }

    @JsonProperty("stay_informed")
    public void setStayInformed(StayInformed stayInformed) {
        this.stayInformed = stayInformed;
    }

    @JsonProperty("thanks")
    public String getThanks() {
        return thanks;
    }

    @JsonProperty("thanks")
    public void setThanks(String thanks) {
        this.thanks = thanks;
    }

    @JsonProperty("timestamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("total_results")
    public Integer getTotalResults() {
        return totalResults;
    }

    @JsonProperty("total_results")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
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
