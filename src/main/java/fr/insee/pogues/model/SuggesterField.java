package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "name",
        "rules",
        "language",
        "min",
        "stemmer",
        "synonyms"
})
@Getter
@Setter
public class SuggesterField {

    @JsonProperty(required = true)
    protected String name;

    @JsonProperty(required = true)
    protected FieldRules rules;

    protected String language;

    protected BigInteger min;

    protected Boolean stemmer;

    protected List<FieldSynonym> synonyms;

    public SuggesterField() {
        rules = new FieldRules();
        synonyms = new ArrayList<>();
    }

}
