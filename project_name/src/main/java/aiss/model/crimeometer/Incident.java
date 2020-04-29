
package aiss.model.crimeometer;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "city_key",
    "incident_code",
    "incident_date",
    "incident_offense",
    "incident_offense_code",
    "incident_offense_description",
    "incident_offense_detail_description",
    "incident_offense_crime_against",
    "incident_offense_action",
    "incident_source_original_type",
    "incident_source_name",
    "incident_latitude",
    "incident_longitude",
    "incident_address"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class Incident {

    @JsonProperty("city_key")
    private String cityKey;
    @JsonProperty("incident_code")
    private String incidentCode;
    @JsonProperty("incident_date")
    private String incidentDate;
    @JsonProperty("incident_offense")
    private String incidentOffense;
    @JsonProperty("incident_offense_code")
    private String incidentOffenseCode;
    @JsonProperty("incident_offense_description")
    private String incidentOffenseDescription;
    @JsonProperty("incident_offense_detail_description")
    private String incidentOffenseDetailDescription;
    @JsonProperty("incident_offense_crime_against")
    private String incidentOffenseCrimeAgainst;
    @JsonProperty("incident_offense_action")
    private String incidentOffenseAction;
    @JsonProperty("incident_source_original_type")
    private String incidentSourceOriginalType;
    @JsonProperty("incident_source_name")
    private String incidentSourceName;
    @JsonProperty("incident_latitude")
    private Double incidentLatitude;
    @JsonProperty("incident_longitude")
    private Double incidentLongitude;
    @JsonProperty("incident_address")
    private String incidentAddress;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("city_key")
    public String getCityKey() {
        return cityKey;
    }

    @JsonProperty("city_key")
    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    @JsonProperty("incident_code")
    public String getIncidentCode() {
        return incidentCode;
    }

    @JsonProperty("incident_code")
    public void setIncidentCode(String incidentCode) {
        this.incidentCode = incidentCode;
    }

    @JsonProperty("incident_date")
    public String getIncidentDate() {
        return incidentDate;
    }

    @JsonProperty("incident_date")
    public void setIncidentDate(String incidentDate) {
        this.incidentDate = incidentDate;
    }

    @JsonProperty("incident_offense")
    public String getIncidentOffense() {
        return incidentOffense;
    }

    @JsonProperty("incident_offense")
    public void setIncidentOffense(String incidentOffense) {
        this.incidentOffense = incidentOffense;
    }

    @JsonProperty("incident_offense_code")
    public String getIncidentOffenseCode() {
        return incidentOffenseCode;
    }

    @JsonProperty("incident_offense_code")
    public void setIncidentOffenseCode(String incidentOffenseCode) {
        this.incidentOffenseCode = incidentOffenseCode;
    }

    @JsonProperty("incident_offense_description")
    public String getIncidentOffenseDescription() {
        return incidentOffenseDescription;
    }

    @JsonProperty("incident_offense_description")
    public void setIncidentOffenseDescription(String incidentOffenseDescription) {
        this.incidentOffenseDescription = incidentOffenseDescription;
    }

    @JsonProperty("incident_offense_detail_description")
    public String getIncidentOffenseDetailDescription() {
        return incidentOffenseDetailDescription;
    }

    @JsonProperty("incident_offense_detail_description")
    public void setIncidentOffenseDetailDescription(String incidentOffenseDetailDescription) {
        this.incidentOffenseDetailDescription = incidentOffenseDetailDescription;
    }

    @JsonProperty("incident_offense_crime_against")
    public String getIncidentOffenseCrimeAgainst() {
        return incidentOffenseCrimeAgainst;
    }

    @JsonProperty("incident_offense_crime_against")
    public void setIncidentOffenseCrimeAgainst(String incidentOffenseCrimeAgainst) {
        this.incidentOffenseCrimeAgainst = incidentOffenseCrimeAgainst;
    }

    @JsonProperty("incident_offense_action")
    public String getIncidentOffenseAction() {
        return incidentOffenseAction;
    }

    @JsonProperty("incident_offense_action")
    public void setIncidentOffenseAction(String incidentOffenseAction) {
        this.incidentOffenseAction = incidentOffenseAction;
    }

    @JsonProperty("incident_source_original_type")
    public String getIncidentSourceOriginalType() {
        return incidentSourceOriginalType;
    }

    @JsonProperty("incident_source_original_type")
    public void setIncidentSourceOriginalType(String incidentSourceOriginalType) {
        this.incidentSourceOriginalType = incidentSourceOriginalType;
    }

    @JsonProperty("incident_source_name")
    public String getIncidentSourceName() {
        return incidentSourceName;
    }

    @JsonProperty("incident_source_name")
    public void setIncidentSourceName(String incidentSourceName) {
        this.incidentSourceName = incidentSourceName;
    }

    @JsonProperty("incident_latitude")
    public Double getIncidentLatitude() {
        return incidentLatitude;
    }

    @JsonProperty("incident_latitude")
    public void setIncidentLatitude(Double incidentLatitude) {
        this.incidentLatitude = incidentLatitude;
    }

    @JsonProperty("incident_longitude")
    public Double getIncidentLongitude() {
        return incidentLongitude;
    }

    @JsonProperty("incident_longitude")
    public void setIncidentLongitude(Double incidentLongitude) {
        this.incidentLongitude = incidentLongitude;
    }

    @JsonProperty("incident_address")
    public String getIncidentAddress() {
        return incidentAddress;
    }

    @JsonProperty("incident_address")
    public void setIncidentAddress(String incidentAddress) {
        this.incidentAddress = incidentAddress;
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
