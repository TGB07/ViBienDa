
package aiss.model.opencage;

import java.util.HashMap;
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
    "created_http",
    "created_unix"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class Timestamp {

    @JsonProperty("created_http")
    private String createdHttp;
    @JsonProperty("created_unix")
    private Integer createdUnix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("created_http")
    public String getCreatedHttp() {
        return createdHttp;
    }

    @JsonProperty("created_http")
    public void setCreatedHttp(String createdHttp) {
        this.createdHttp = createdHttp;
    }

    @JsonProperty("created_unix")
    public Integer getCreatedUnix() {
        return createdUnix;
    }

    @JsonProperty("created_unix")
    public void setCreatedUnix(Integer createdUnix) {
        this.createdUnix = createdUnix;
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
