package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  A calculated variable is a variable calculated from others variables including the calculated variables.
 */
public class CalculatedVariableType extends VariableType {

    @JsonProperty(value = "Formula", required = true)
    protected ExpressionType formula;

}
