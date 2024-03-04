package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic Pogues component.
 */
@JsonPropertyOrder({
        "id",
        "type",
        "Name",
        "Label",
        "agency",
        "final",
        "flowLogic",
        "formulasLanguage",
        "TargetMode",
        "genericName",
        "depth",
        "questionType",
        "Response",
        "ResponseStructure",
        "ClarificationQuestion",
        "Scope",
        "Declaration",
        "Control",
        "FlowControl",
        "GoTo",
        "Iterations",
        "DataCollection",
        "ComponentGroup",
        "Child",
        "Variables",
        "CodeLists",
})
@JsonTypeInfo(use= JsonTypeInfo.Id.DEDUCTION, defaultImpl = SequenceType.class)
@JsonSubTypes({
        @JsonSubTypes.Type(Questionnaire.class),
        @JsonSubTypes.Type(SequenceType.class),
        @JsonSubTypes.Type(QuestionType.class)
})
@Getter
@Setter
public abstract class ComponentType {

    /** Component identifier. */
    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected String id;

    @JacksonXmlProperty(isAttribute = true)
    private final String type;

    /** Business name of the component. */
    @JsonProperty(value = "Name", required = true)
    protected String name;

    /** Descriptive label. */
    @JsonProperty(value = "Label", required = true)
    protected List<String> label;

    /** Declarations associated with the component. {@link DeclarationType} */
    @JsonProperty("Declaration")
    protected List<DeclarationType> declaration;

    /** Controls applied on the component. */
    @JsonProperty("Control")
    protected List<ControlType> control;

    /** Flow controls (i.e. filters) applied on the component. {@link FlowControlType} */
    @JsonProperty("FlowControl")
    protected List<FlowControlType> flowControl;

    /** GoTo filters applied on the component.
     * @deprecated GoTo filters are replaced by flow control filters. */
    @JsonProperty("GoTo")
    @Deprecated(since = "2.0.0")
    protected List<GoToType> goTo = new ArrayList<>();

    /** Collection modes for which the component is defined. */
    @JsonProperty("TargetMode")
    protected List<SurveyModeEnum> targetMode;

    /** Subcomponents of the component, e.g. a subsequence within a sequence. */
    @JsonProperty("Child")
    protected List<ComponentType> child;

    protected ComponentType() {
        type = this.getClass().getSimpleName();
        label = new ArrayList<>();
        declaration = new ArrayList<>();
        control = new ArrayList<>();
        flowControl = new ArrayList<>();
        targetMode = new ArrayList<>();
        child = new ArrayList<>();
    }

}
