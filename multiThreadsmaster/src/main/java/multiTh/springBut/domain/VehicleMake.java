package multiTh.springBut.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleMake {

    @JsonProperty("Make_ID")
    private Integer makeID;
    @JsonProperty("Make_Name")
    private String makeName;

    public Integer getMakeID() {
        return makeID;
    }

    public void setMakeID(Integer makeID) {
        this.makeID = makeID;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    @Override
    public String toString() {
        return "makeID= " + makeID +", makeName= " + makeName;
    }
}
