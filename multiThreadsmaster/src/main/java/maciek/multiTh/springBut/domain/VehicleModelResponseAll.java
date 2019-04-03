package maciek.multiTh.springBut.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleModelResponseAll {

    @JsonProperty("Count")
    private Integer count;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("SearchCriteria")
    private String searchCriteria;
    @JsonProperty("Results")
    private List<VehicleModel> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<VehicleModel> getResults() {
        return results;
    }

    public void setResults(List<VehicleModel> results) {
        this.results = results;
    }
}
