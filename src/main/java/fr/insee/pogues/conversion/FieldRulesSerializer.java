package fr.insee.pogues.conversion;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fr.insee.pogues.model.FieldRules;

import java.io.IOException;

/** Temporary custom serializer to mitigate bad pattern in Lunatic modeling.
 * @see FieldRules */
public class FieldRulesSerializer extends StdSerializer<FieldRules> {

    @SuppressWarnings("unused") // default constructor is required by jackson
    public FieldRulesSerializer() {
        this(null);
    }

    public FieldRulesSerializer(Class<FieldRules> t) {
        super(t);
    }

    @Override
    public void serialize(FieldRules fieldRules, JsonGenerator jsonGenerator, SerializerProvider provider)
            throws IOException {
        if (fieldRules.getRule() != null && fieldRules.getPatterns() != null) // double check
            throw new IllegalStateException(FieldRules.ILLEGAL_STATE_MESSAGE);

        if (fieldRules.getRule() != null) {
            serializeStringRule(fieldRules, jsonGenerator);
            return;
        }

        if (fieldRules.getPatterns() != null) {
            serializePatternsList(fieldRules, jsonGenerator);
            return;
        }

        jsonGenerator.writeNull();
    }

    private void serializeStringRule(FieldRules fieldRules, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeString(fieldRules.getRule());
    }

    private void serializePatternsList(FieldRules fieldRules, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartArray();
        for (String pattern : fieldRules.getPatterns()) {
            jsonGenerator.writeString(pattern);
        }
        jsonGenerator.writeEndArray();
    }

}
