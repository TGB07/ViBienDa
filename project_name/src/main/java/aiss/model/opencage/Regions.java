
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
    "AMERICAS",
    "NORTHERN_AMERICA",
    "US",
    "WORLD"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class Regions {

    @JsonProperty("AMERICAS")
    private String aMERICAS;
    @JsonProperty("NORTHERN_AMERICA")
    private String nORTHERNAMERICA;
    @JsonProperty("US")
    private String uS;
    @JsonProperty("WORLD")
    private String wORLD;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("AMERICAS")
    public String getAMERICAS() {
        return aMERICAS;
    }

    @JsonProperty("AMERICAS")
    public void setAMERICAS(String aMERICAS) {
        this.aMERICAS = aMERICAS;
    }

    @JsonProperty("NORTHERN_AMERICA")
    public String getNORTHERNAMERICA() {
        return nORTHERNAMERICA;
    }

    @JsonProperty("NORTHERN_AMERICA")
    public void setNORTHERNAMERICA(String nORTHERNAMERICA) {
        this.nORTHERNAMERICA = nORTHERNAMERICA;
    }

    @JsonProperty("US")
    public String getUS() {
        return uS;
    }

    @JsonProperty("US")
    public void setUS(String uS) {
        this.uS = uS;
    }

    @JsonProperty("WORLD")
    public String getWORLD() {
        return wORLD;
    }

    @JsonProperty("WORLD")
    public void setWORLD(String wORLD) {
        this.wORLD = wORLD;
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
