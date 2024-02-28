package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "AttributeValue",
        "AttributeTarget"
})
@Getter
@Setter
public class AttributeType {

    /** In the case of a "no data by definition", is "NoDataByDefinition". */
    @JsonProperty(value = "AttributeValue", required = true)
    protected String attributeValue;

    /** n-uple giving the coordinates (1-based) of the target cell according to
     the dimensions, format "i" (one dimension) or "i j" (two dimensions). */
    @JsonProperty(value = "AttributeTarget", required = true)
    protected String attributeTarget;

}
