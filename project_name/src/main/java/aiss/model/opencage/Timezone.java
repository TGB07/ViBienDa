
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
    "name",
    "now_in_dst",
    "offset_sec",
    "offset_string",
    "short_name"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class Timezone {

    @JsonProperty("name")
    private String name;
    @JsonProperty("now_in_dst")
    private Integer nowInDst;
    @JsonProperty("offset_sec")
    private Integer offsetSec;
    @JsonProperty("offset_string")
    private String offsetString;
    @JsonProperty("short_name")
    private String shortName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("now_in_dst")
    public Integer getNowInDst() {
        return nowInDst;
    }

    @JsonProperty("now_in_dst")
    public void setNowInDst(Integer nowInDst) {
        this.nowInDst = nowInDst;
    }

    @JsonProperty("offset_sec")
    public Integer getOffsetSec() {
        return offsetSec;
    }

    @JsonProperty("offset_sec")
    public void setOffsetSec(Integer offsetSec) {
        this.offsetSec = offsetSec;
    }

    @JsonProperty("offset_string")
    public String getOffsetString() {
        return offsetString;
    }

    @JsonProperty("offset_string")
    public void setOffsetString(String offsetString) {
        this.offsetString = offsetString;
    }

    @JsonProperty("short_name")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("short_name")
    public void setShortName(String shortName) {
        this.shortName = shortName;
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
