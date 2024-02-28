package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class DynamicIterationType extends IterationType {

    @JsonProperty("Minimum")
    protected ExpressionType minimum;

    @JsonProperty("Maximum")
    protected ExpressionType maximum;

    @JsonProperty("Step")
    protected BigInteger step;

    /** Could be a Roster (dynamic table) or another iteration */
    @JsonProperty(value = "IterableReference", required = true)
    protected String iterableReference;

    /** Specifies a condition for filter for NOT displaying the code value. */
    @JsonProperty("Filter")
    protected ExpressionType filter;

}
