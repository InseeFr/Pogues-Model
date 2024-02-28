package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "Dimension",
        "Attribute",
        "Mapping"
})
@Getter
@Setter
public class ResponseStructureType {

    @JsonProperty(value = "Dimension", required = true)
    protected List<DimensionType> dimension;

    /** Used to model "No data by definition" ((a no meaning intersection)) */
    @JsonProperty("Attribute")
    protected List<AttributeType> attribute;

    /** Mapping makes it possible to make the link between the box and the answer */
    @JsonProperty("Mapping")
    protected List<MappingType> mapping;

    public ResponseStructureType() {
        dimension = new ArrayList<>();
        attribute = new ArrayList<>();
        mapping = new ArrayList<>();
    }

}
