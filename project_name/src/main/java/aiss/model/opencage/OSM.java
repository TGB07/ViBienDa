
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
    "edit_url",
    "note_url",
    "url"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class OSM {

    @JsonProperty("edit_url")
    private String editUrl;
    @JsonProperty("note_url")
    private String noteUrl;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("edit_url")
    public String getEditUrl() {
        return editUrl;
    }

    @JsonProperty("edit_url")
    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }

    @JsonProperty("note_url")
    public String getNoteUrl() {
        return noteUrl;
    }

    @JsonProperty("note_url")
    public void setNoteUrl(String noteUrl) {
        this.noteUrl = noteUrl;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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
