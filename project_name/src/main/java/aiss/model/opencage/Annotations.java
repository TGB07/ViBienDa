
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
    "DMS",
    "MGRS",
    "Maidenhead",
    "Mercator",
    "OSM",
    "UN_M49",
    "callingcode",
    "currency",
    "flag",
    "geohash",
    "qibla",
    "roadinfo",
    "sun",
    "timezone",
    "what3words",
    "wikidata"
})
@JsonIgnoreProperties(ignoreUnknown=true)

public class Annotations {

    @JsonProperty("DMS")
    private DMS dMS;
    @JsonProperty("MGRS")
    private String mGRS;
    @JsonProperty("Maidenhead")
    private String maidenhead;
    @JsonProperty("Mercator")
    private Mercator mercator;
    @JsonProperty("OSM")
    private OSM oSM;
    @JsonProperty("UN_M49")
    private UNM49 uNM49;
    @JsonProperty("callingcode")
    private Integer callingcode;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("flag")
    private String flag;
    @JsonProperty("geohash")
    private String geohash;
    @JsonProperty("qibla")
    private Double qibla;
    @JsonProperty("roadinfo")
    private Roadinfo roadinfo;
    @JsonProperty("sun")
    private Sun sun;
    @JsonProperty("timezone")
    private Timezone timezone;
    @JsonProperty("what3words")
    private What3words what3words;
    @JsonProperty("wikidata")
    private String wikidata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DMS")
    public DMS getDMS() {
        return dMS;
    }

    @JsonProperty("DMS")
    public void setDMS(DMS dMS) {
        this.dMS = dMS;
    }

    @JsonProperty("MGRS")
    public String getMGRS() {
        return mGRS;
    }

    @JsonProperty("MGRS")
    public void setMGRS(String mGRS) {
        this.mGRS = mGRS;
    }

    @JsonProperty("Maidenhead")
    public String getMaidenhead() {
        return maidenhead;
    }

    @JsonProperty("Maidenhead")
    public void setMaidenhead(String maidenhead) {
        this.maidenhead = maidenhead;
    }

    @JsonProperty("Mercator")
    public Mercator getMercator() {
        return mercator;
    }

    @JsonProperty("Mercator")
    public void setMercator(Mercator mercator) {
        this.mercator = mercator;
    }

    @JsonProperty("OSM")
    public OSM getOSM() {
        return oSM;
    }

    @JsonProperty("OSM")
    public void setOSM(OSM oSM) {
        this.oSM = oSM;
    }

    @JsonProperty("UN_M49")
    public UNM49 getUNM49() {
        return uNM49;
    }

    @JsonProperty("UN_M49")
    public void setUNM49(UNM49 uNM49) {
        this.uNM49 = uNM49;
    }

    @JsonProperty("callingcode")
    public Integer getCallingcode() {
        return callingcode;
    }

    @JsonProperty("callingcode")
    public void setCallingcode(Integer callingcode) {
        this.callingcode = callingcode;
    }

    @JsonProperty("currency")
    public Currency getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @JsonProperty("flag")
    public String getFlag() {
        return flag;
    }

    @JsonProperty("flag")
    public void setFlag(String flag) {
        this.flag = flag;
    }

    @JsonProperty("geohash")
    public String getGeohash() {
        return geohash;
    }

    @JsonProperty("geohash")
    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }

    @JsonProperty("qibla")
    public Double getQibla() {
        return qibla;
    }

    @JsonProperty("qibla")
    public void setQibla(Double qibla) {
        this.qibla = qibla;
    }

    @JsonProperty("roadinfo")
    public Roadinfo getRoadinfo() {
        return roadinfo;
    }

    @JsonProperty("roadinfo")
    public void setRoadinfo(Roadinfo roadinfo) {
        this.roadinfo = roadinfo;
    }

    @JsonProperty("sun")
    public Sun getSun() {
        return sun;
    }

    @JsonProperty("sun")
    public void setSun(Sun sun) {
        this.sun = sun;
    }

    @JsonProperty("timezone")
    public Timezone getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("what3words")
    public What3words getWhat3words() {
        return what3words;
    }

    @JsonProperty("what3words")
    public void setWhat3words(What3words what3words) {
        this.what3words = what3words;
    }

    @JsonProperty("wikidata")
    public String getWikidata() {
        return wikidata;
    }

    @JsonProperty("wikidata")
    public void setWikidata(String wikidata) {
        this.wikidata = wikidata;
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
