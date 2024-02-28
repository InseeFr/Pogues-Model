package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "dimensionType",
        "dynamic",
        "CodeListReference",
        "Label",
        "TotalLabel"
})
@Getter
@Setter
public class DimensionType {

    @JsonProperty(value = "dimensionType", required = true)
    protected DimensionTypeEnum dimensionType;

    /** '0': no constraint; 'm-': min m, no max; '-n': no min, n max; 'm-n': m min, n max */
    @JsonProperty(value = "dynamic", required = true)
    protected String dynamic;

    @JsonProperty("CodeListReference")
    protected String codeListReference;

    @JsonProperty("Label")
    protected String label;

    /** Indicates if the dimension has a 'total' item and if yes the corresponding label. */
    @JsonProperty("TotalLabel")
    protected String totalLabel;

}
