package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "id",
        "Description",
        "Expression",
        "IfTrue"
})
@Getter
@Setter
public class GoToType {

    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected String id;

    @JsonProperty("Description")
    protected String description;

    @JsonProperty(value = "Expression", required = true)
    protected ExpressionType expression;

    @JsonProperty(value = "IfTrue", required = true)
    protected String ifTrue;

}
