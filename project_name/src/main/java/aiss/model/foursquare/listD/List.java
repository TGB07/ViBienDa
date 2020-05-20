
package aiss.model.foursquare.listD;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "description",
    "type",
    "user",
    "editable",
    "public",
    "collaborative",
    "canonicalUrl",
    "createdAt",
    "updatedAt",
    "photo",
    "logView",
    "visitedCount",
    "venueCount",
    "categories",
    "following",
    "followers",
    "collaborators",
    "sort",
    "listItems",
    "completedCount"
})
public class List {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private String type;
    @JsonProperty("user")
    private User user;
    @JsonProperty("editable")
    private Boolean editable;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("collaborative")
    private Boolean collaborative;
    @JsonProperty("canonicalUrl")
    private String canonicalUrl;
    @JsonProperty("createdAt")
    private Integer createdAt;
    @JsonProperty("updatedAt")
    private Integer updatedAt;
    @JsonProperty("photo")
    private Photo_ photo;
    @JsonProperty("logView")
    private Boolean logView;
    @JsonProperty("visitedCount")
    private Integer visitedCount;
    @JsonProperty("venueCount")
    private Integer venueCount;
    @JsonProperty("categories")
    private Categories categories;
    @JsonProperty("following")
    private Boolean following;
    @JsonProperty("followers")
    private Followers followers;
    @JsonProperty("collaborators")
    private Collaborators collaborators;
    @JsonProperty("sort")
    private String sort;
    @JsonProperty("listItems")
    private ListItems listItems;
    @JsonProperty("completedCount")
    private Integer completedCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("editable")
    public Boolean getEditable() {
        return editable;
    }

    @JsonProperty("editable")
    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    @JsonProperty("public")
    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty("public")
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    @JsonProperty("collaborative")
    public Boolean getCollaborative() {
        return collaborative;
    }

    @JsonProperty("collaborative")
    public void setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
    }

    @JsonProperty("canonicalUrl")
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    @JsonProperty("canonicalUrl")
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    @JsonProperty("createdAt")
    public Integer getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updatedAt")
    public Integer getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("photo")
    public Photo_ getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(Photo_ photo) {
        this.photo = photo;
    }

    @JsonProperty("logView")
    public Boolean getLogView() {
        return logView;
    }

    @JsonProperty("logView")
    public void setLogView(Boolean logView) {
        this.logView = logView;
    }

    @JsonProperty("visitedCount")
    public Integer getVisitedCount() {
        return visitedCount;
    }

    @JsonProperty("visitedCount")
    public void setVisitedCount(Integer visitedCount) {
        this.visitedCount = visitedCount;
    }

    @JsonProperty("venueCount")
    public Integer getVenueCount() {
        return venueCount;
    }

    @JsonProperty("venueCount")
    public void setVenueCount(Integer venueCount) {
        this.venueCount = venueCount;
    }

    @JsonProperty("categories")
    public Categories getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @JsonProperty("following")
    public Boolean getFollowing() {
        return following;
    }

    @JsonProperty("following")
    public void setFollowing(Boolean following) {
        this.following = following;
    }

    @JsonProperty("followers")
    public Followers getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    @JsonProperty("collaborators")
    public Collaborators getCollaborators() {
        return collaborators;
    }

    @JsonProperty("collaborators")
    public void setCollaborators(Collaborators collaborators) {
        this.collaborators = collaborators;
    }

    @JsonProperty("sort")
    public String getSort() {
        return sort;
    }

    @JsonProperty("sort")
    public void setSort(String sort) {
        this.sort = sort;
    }

    @JsonProperty("listItems")
    public ListItems getListItems() {
        return listItems;
    }

    @JsonProperty("listItems")
    public void setListItems(ListItems listItems) {
        this.listItems = listItems;
    }

    @JsonProperty("completedCount")
    public Integer getCompletedCount() {
        return completedCount;
    }

    @JsonProperty("completedCount")
    public void setCompletedCount(Integer completedCount) {
        this.completedCount = completedCount;
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
