package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "label",
        "value",
        "firstIntentionDisplay"
})
@Getter
@Setter
public class NonResponseModalityType {

    /** The label of the modality. */
    @JsonProperty(value = "Label", required = true)
    protected String label;

    /** The value of the code. */
    @JsonProperty(value = "Value", required = true)
    protected String value;

    /** A boolean with first intention or not (the dynamic behaviour in the generated questionnaire). */
    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected boolean firstIntentionDisplay;

}
