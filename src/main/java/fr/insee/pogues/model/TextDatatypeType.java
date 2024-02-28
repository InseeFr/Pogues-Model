package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class TextDatatypeType extends DatatypeType {

    /** Maximum text response size in number of characters. */
    @JsonProperty("MaxLength")
    protected BigInteger maxLength;

    /** The pattern allows you to specify regular expressions.
     Pattern should perhaps be attached to the answer rather than the question. */
    @JsonProperty("Pattern")
    protected String pattern;

    public TextDatatypeType() {
        super(DatatypeTypeEnum.TEXT);
    }

}
