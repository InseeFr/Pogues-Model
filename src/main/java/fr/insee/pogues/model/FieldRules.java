package fr.insee.pogues.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.insee.pogues.conversion.FieldRulesJsonDeserializer;
import fr.insee.pogues.conversion.FieldRulesSerializer;

import java.util.ArrayList;
import java.util.List;

/** Temporary class before Lunatic modeling is changed so to not have a property that can be either string or list. */
@JsonSerialize(using = FieldRulesSerializer.class)
@JsonDeserialize(using = FieldRulesJsonDeserializer.class)
public class FieldRules {

    public static final String SOFT_RULE = "soft";

    public static final String ILLEGAL_STATE_MESSAGE = "String and array values are mutually exclusive";

    private String rule;
    private List<String> patterns;


    public String getRule() {
        return rule;
    }
    public void setRule(String rule) {
        if (patterns != null)
            throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
        if (! SOFT_RULE.equals(rule))
            throw new IllegalArgumentException("Only '"+SOFT_RULE+"' value is accepted for string rule value.");
        this.rule = rule;
    }

    public void addPattern(String pattern) {
        if (rule != null)
            throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
        if (patterns == null)
            patterns = new ArrayList<>();
        patterns.add(pattern);
    }
    public List<String> getPatterns() {
        return patterns;
    }

}
