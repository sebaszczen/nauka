package multiTh.springBut.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleMakeResponseAll {
    @JsonProperty("Count")
    private Integer count;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("SearchCriteria")
    private Object searchCriteria;
    @JsonProperty("Results")
    private List<VehicleMake> results;

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

    public Object getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(Object searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<VehicleMake> getResults() {
        return results;
    }

    public void setResults(List<VehicleMake> results) {
        this.results = results;
    }
}
