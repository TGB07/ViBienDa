
package aiss.model.crimeometer;

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
    "total_incidents",
    "total_pages",
    "incidents"
})

@JsonIgnoreProperties(ignoreUnknown=true)
public class CrimeometerLLSearch {

    @JsonProperty("total_incidents")
    private Integer totalIncidents;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("incidents")
    private List<Incident> incidents = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("total_incidents")
    public Integer getTotalIncidents() {
        return totalIncidents;
    }

    @JsonProperty("total_incidents")
    public void setTotalIncidents(Integer totalIncidents) {
        this.totalIncidents = totalIncidents;
    }

    @JsonProperty("total_pages")
    public Integer getTotalPages() {
        return totalPages;
    }

    @JsonProperty("total_pages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("incidents")
    public List<Incident> getIncidents() {
        return incidents;
    }

    @JsonProperty("incidents")
    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
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
