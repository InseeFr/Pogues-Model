package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

/**
 * Expression in the language declared in "FormulasLanguage".
 */
@Getter
@Setter
public class ExpressionType {

    @JsonValue
    protected String value;

    @JsonCreator
    public ExpressionType(String value) {
        this.value = value;
    }

}
