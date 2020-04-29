
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
    "drive_on",
    "road",
    "speed_in"
})

@JsonIgnoreProperties(ignoreUnknown=true)

public class Roadinfo {

    @JsonProperty("drive_on")
    private String driveOn;
    @JsonProperty("road")
    private String road;
    @JsonProperty("speed_in")
    private String speedIn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("drive_on")
    public String getDriveOn() {
        return driveOn;
    }

    @JsonProperty("drive_on")
    public void setDriveOn(String driveOn) {
        this.driveOn = driveOn;
    }

    @JsonProperty("road")
    public String getRoad() {
        return road;
    }

    @JsonProperty("road")
    public void setRoad(String road) {
        this.road = road;
    }

    @JsonProperty("speed_in")
    public String getSpeedIn() {
        return speedIn;
    }

    @JsonProperty("speed_in")
    public void setSpeedIn(String speedIn) {
        this.speedIn = speedIn;
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
