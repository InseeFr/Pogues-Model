package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "field",
        "type"
})
@Getter
@Setter
public class SuggesterOrder {

    @JsonProperty(required = true)
    protected String field;

    @JsonProperty(required = true)
    protected String type;

}
