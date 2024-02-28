package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Pogues question component.
 */
@Getter
@Setter
public class QuestionType extends ComponentType {

    protected QuestionTypeEnum questionType;

    @JsonProperty(value = "Response", required = true)
    protected List<ResponseType> response;

    @JsonProperty("ResponseStructure")
    protected ResponseStructureType responseStructure;

    /** Clarification question is a request for additional information from
     a list of choices defined a priori (single or multiple choice question). This
     additional information is related to a response domain and triggered when a specific
     response value is selected or typed. The triggering of the clarification question
     can be made through the FlowControl element and the CLARIFICATION
     flowControlType. */
    @JsonProperty("ClarificationQuestion")
    protected List<QuestionType> clarificationQuestion;

    @JsonProperty("Scope")
    protected String scope;

    public QuestionType() {
        super();
        response = new ArrayList<>();
        clarificationQuestion = new ArrayList<>();
    }

}
