package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
    @JsonProperty(value = "firstIntentionDisplay", required = true)
    protected boolean firstIntentionDisplay;

}
