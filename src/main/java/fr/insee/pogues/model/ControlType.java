package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "id",
        "criticity",
        "Description",
        "Expression",
        "FailMessage"
})
@Getter
@Setter
public class ControlType {

    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected String id;

    @JacksonXmlProperty(isAttribute = true)
    protected ControlCriticityEnum criticity;

    @JsonProperty(value = "Description", required = true)
    protected String description;

    /** Defines when the control is triggered. */
    @JsonProperty(value = "Expression", required = true)
    protected ExpressionType expression;

    @JsonProperty("FailMessage")
    protected String failMessage;

}
