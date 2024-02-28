package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "id",
        "simple",
        "mandatory",
        "CodeListReference",
        "Datatype",
        "Value",
        "NonResponseModality",
        "CollectedVariableReference"
})
@Getter
@Setter
public class ResponseType {

    /** Identifier to responses in order to be able to reference them in mappings. */
    @JsonProperty(required = true)
    protected String id;

    protected Boolean simple;

    protected Boolean mandatory;

    @JsonProperty("CodeListReference")
    protected String codeListReference;

    @JsonProperty(value = "Datatype", required = true)
    protected DatatypeType datatype;

    /** ???
     * @deprecated unless you know what it's for, please contribute if you do. */
    @JsonProperty("Value")
    @Deprecated(since = "2.0.0")
    protected List<Object> value = new ArrayList<>();

    /** Specifies the non-response specific modality (e.g. "Don't know" or "Refusal").
     * @deprecated Old and unused property, to be removed. */
    @JsonProperty("NonResponseModality")
    @Deprecated(since = "2.0.0", forRemoval = true)
    protected List<NonResponseModalityType> nonResponseModality = new ArrayList<>();

    /** CollectedVariableReference : collected variable reference to link the variable in the wrap and the variable
     * created in the response element. */
    @JsonProperty(value = "CollectedVariableReference", required = true)
    protected String collectedVariableReference;

}
