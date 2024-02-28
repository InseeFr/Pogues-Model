package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "Value",
        "Label",
        "Filter",
        "Parent"
})
@Getter
@Setter
public class CodeType {

    /** The value of the code. */
    @JsonProperty(value = "Value", required = true)
    protected String value;

    /** The label of the code. */
    @JsonProperty(value = "Label", required = true)
    protected String label;

    /** Specifies a condition for NOT displaying the code value.
     * @deprecated Old and unused property, to be removed. */
    @JsonProperty("Filter")
    @Deprecated(since = "2.0.0", forRemoval = true)
    protected ExpressionType filter;

    /** This attribute is used in hierarchical code lists case (a code may contain a code that may contain a code, etc.,
     * as a recursive description). It refers the parent code of this code. */
    @JsonProperty("Parent")
    protected String parent;

}
