
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
    "rise",
    "set"
})

@JsonIgnoreProperties(ignoreUnknown=true)

public class Sun {

    @JsonProperty("rise")
    private Rise rise;
    @JsonProperty("set")
    private Set set;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rise")
    public Rise getRise() {
        return rise;
    }

    @JsonProperty("rise")
    public void setRise(Rise rise) {
        this.rise = rise;
    }

    @JsonProperty("set")
    public Set getSet() {
        return set;
    }

    @JsonProperty("set")
    public void setSet(Set set) {
        this.set = set;
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
