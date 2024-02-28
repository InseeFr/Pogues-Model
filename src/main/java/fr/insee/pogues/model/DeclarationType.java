package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * A "Declaration" is information related to a question or a sequence that gives information to the respondent or
 * interviewer.
 */
@JsonPropertyOrder({
        "id",
        "declarationType",
        "position",
        "Text",
        "DeclarationMode"
})
@Getter
@Setter
public class DeclarationType {

    /** Identifier of the declaration. */
    @JsonProperty(required = true)
    protected String id;

    /** {@link DeclarationTypeEnum} */
    protected DeclarationTypeEnum declarationType;

    /** {@link DeclarationPositionEnum} */
    protected DeclarationPositionEnum position;

    /** Text of the declaration. */
    @JsonProperty(value = "Text", required = true)
    protected String text;

    /** Survey modes of declaration. */
    @JsonProperty("DeclarationMode")
    protected List<SurveyModeEnum> declarationMode;

    public DeclarationType() {
        declarationMode = new ArrayList<>();
    }

}
