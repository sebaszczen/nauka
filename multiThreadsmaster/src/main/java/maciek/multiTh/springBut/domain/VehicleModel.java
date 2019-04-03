package maciek.multiTh.springBut.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleModel {

    @JsonProperty("Make_ID")
    private Integer makeID;
    @JsonProperty("Make_Name")
    private String makeName;
    @JsonProperty("Model_ID")
    private Integer modelID;
    @JsonProperty("Model_Name")
    private String modelName;

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

    public Integer getModelID() {
        return modelID;
    }

    public void setModelID(Integer modelID) {
        this.modelID = modelID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "VehicleModel{" +
                "makeID=" + makeID +
                ", makeName='" + makeName + '\'' +
                ", modelID=" + modelID +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
