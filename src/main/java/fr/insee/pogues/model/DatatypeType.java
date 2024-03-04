package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
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

    @JacksonXmlProperty(isAttribute = true)
    private final String type;

    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected final DatatypeTypeEnum typeName;

    /** VisualizationHint is the type of input as part of an answer to a single-choice question.
     * That may not be the perfect choice of a name, a better choice could be "GraphicalImplementation". */
    @JacksonXmlProperty(isAttribute = true)
    protected VisualizationHintEnum visualizationHint;

    protected DatatypeType(DatatypeTypeEnum datatypeTypeEnum) {
        type = this.getClass().getSimpleName();
        typeName = datatypeTypeEnum;
    }

}
