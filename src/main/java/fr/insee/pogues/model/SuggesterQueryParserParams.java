package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@JsonPropertyOrder({
        "language",
        "min",
        "pattern",
        "stemmer"
})
@Getter
@Setter
public class SuggesterQueryParserParams {

    protected String language;

    protected BigInteger min;

    protected String pattern;

    protected Boolean stemmer;

}
