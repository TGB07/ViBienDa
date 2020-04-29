
package aiss.model.crimeometer;

import java.util.HashMap;
import java.util.List;
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
    "total_incidents",
    "report_types",
    "total_csi"
})
@JsonIgnoreProperties(ignoreUnknown = true)

public class CrimeStatsLLSearch {

    @JsonProperty("total_incidents")
    private Integer totalIncidents;
    @JsonProperty("report_types")
    private List<ReportType> reportTypes = null;
    @JsonProperty("total_csi")
    private String totalCsi;
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

    @JsonProperty("report_types")
    public List<ReportType> getReportTypes() {
        return reportTypes;
    }

    @JsonProperty("report_types")
    public void setReportTypes(List<ReportType> reportTypes) {
        this.reportTypes = reportTypes;
    }

    @JsonProperty("total_csi")
    public String getTotalCsi() {
        return totalCsi;
    }

    @JsonProperty("total_csi")
    public void setTotalCsi(String totalCsi) {
        this.totalCsi = totalCsi;
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
