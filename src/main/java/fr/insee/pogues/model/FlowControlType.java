package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The FlowControl element is used in two ways: as a GoTo only used in a question and as a Filter only used in the
 * questionnaire.
 * Note: GoTo is deprecated.
 */
@JsonPropertyOrder({
        "id",
        "flowControlType",
        "Description",
        "Expression",
        "IfTrue"
})
@Getter
@Setter
public class FlowControlType {

    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected String id;

    /** {@link FlowControlTypeEnum} */
    @JacksonXmlProperty(isAttribute = true)
    protected FlowControlTypeEnum flowControlType;

    @JsonProperty("Description")
    protected String description;

    @JsonProperty(value = "Expression", required = true)
    protected ExpressionType expression;

    @JsonProperty(value = "IfTrue", required = true)
    protected String ifTrue;

}
