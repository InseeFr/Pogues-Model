package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonPropertyOrder({
        "id",
        "Name",
        "Label",
        "MemberReference",
        "Minimum",
        "Maximum",
        "Step",
        "IterableReference",
        "Filter"
})
@Getter
@Setter
public abstract class IterationType {

    @JsonProperty(value = "id", required = true)
    protected String id;

    @JsonProperty(value = "Name", required = true)
    protected String name;

    @JsonProperty("Label")
    protected String label;

    @JsonProperty("MemberReference")
    protected List<String> memberReference;

}
