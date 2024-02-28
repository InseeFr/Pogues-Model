package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "MappingSource",
        "MappingTarget"
})
@Getter
@Setter
public class MappingType {

    /** Identifier of the response. */
    @JsonProperty(value = "MappingSource", required = true)
    protected String mappingSource;

    /** n-uple giving the coordinates (1-based) of the target cell according to
     the dimensions, format "i" (one dimension) or "i j" (two dimensions). */
    @JsonProperty(value = "MappingTarget", required = true)
    protected String mappingTarget;

}
