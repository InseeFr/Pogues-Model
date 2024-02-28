package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Variable representation type to characterize the variable (numeric, boolean, text, etc.).
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "typeName",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BooleanDatatypeType.class, name = "BOOLEAN"),
        @JsonSubTypes.Type(value = TextDatatypeType.class, name = "TEXT"),
        @JsonSubTypes.Type(value = NumericDatatypeType.class, name = "NUMERIC"),
        @JsonSubTypes.Type(value = DateDatatypeType.class, name = "DATE"),
        @JsonSubTypes.Type(value = DurationDatatypeType.class, name = "DURATION"),
})
@JsonPropertyOrder({
        "typeName",
        "visualisationHint",
        "MaxLength",
        "Pattern",
        "Minimum",
        "Maximum",
        "Decimals",
        "Unit",
        "Format"
})
@Getter
@Setter
public abstract class DatatypeType {

    @JsonProperty(required = true)
    protected final DatatypeTypeEnum typeName;

    /** VisualizationHint is the type of input as part of an answer to a single-choice question.
     * That may not be the perfect choice of a name, a better choice could be "GraphicalImplementation". */
    protected VisualizationHintEnum visualizationHint;

    protected DatatypeType(DatatypeTypeEnum datatypeTypeEnum) {
        this.typeName = datatypeTypeEnum;
    }

}
