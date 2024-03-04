package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

/**
 *  VariableType base type, which is extended by types for collected (CollectedVariableType),
 *  calculated (CalculatedVariableType) and external (ExternalVariableType) variables.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CollectedVariableType.class, name = "CollectedVariableType"),
        @JsonSubTypes.Type(value = CalculatedVariableType.class, name = "CalculatedVariableType"),
        @JsonSubTypes.Type(value = ExternalVariableType.class, name = "ExternalVariableType")
})
@JsonPropertyOrder({
        "id",
        "type",
        "CodeListReference",
        "Datatype",
        "Name",
        "Label",
        "Formula",
        "Scope"
})
@Getter
@Setter
public abstract class VariableType {

    @JsonProperty(required = true)
    protected String id;

    protected final String type;

    @JsonProperty("CodeListReference")
    protected String codeListReference;

    /** {@link DatatypeType} */
    @JsonProperty(value = "Datatype", required = true)
    protected DatatypeType datatype;

    @JsonProperty(value = "Name", required = true)
    protected String name;

    @JsonProperty(value = "Label", required = true)
    protected String label;

    /** Iteration reference (in which the variable has a local scope) */
    @JsonProperty("Scope")
    protected String scope;

    protected VariableType() {
        type = this.getClass().getSimpleName();
    }

}
