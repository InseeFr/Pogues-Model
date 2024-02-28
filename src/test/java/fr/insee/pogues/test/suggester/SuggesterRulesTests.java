package fr.insee.pogues.test.suggester;

import fr.insee.pogues.conversion.JsonDeserializer;
import fr.insee.pogues.conversion.JsonSerializer;
import fr.insee.pogues.conversion.JsonToXmlConverter;
import fr.insee.pogues.exception.JsonDeserializationException;
import fr.insee.pogues.exception.JsonSerializationException;
import fr.insee.pogues.exception.XmlSerializationException;
import fr.insee.pogues.model.*;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.xmlunit.assertj3.XmlAssert;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggesterRulesTests {

    private static final String SOFT_RULE = "soft";

    private final String jsonInputSoftRules = """
            {
              "CodeLists": {
                "CodeList": [
                  {
                    "SuggesterParameters": {
                      "fields": [
                        {
                          "rules": "soft"
                        }
                      ]
                    }
                  }
                ]
              }
            }""";

    private final String jsonInputArrayRules = """
            {
              "CodeLists": {
                "CodeList": [
                  {
                    "SuggesterParameters": {
                      "fields": [
                        {
                          "rules": ["[\\\\w]+"]
                        }
                      ]
                    }
                  }
                ]
              }
            }""";

    @Test
    void serializeRules_softCase() throws JSONException, JsonSerializationException {
        // Given
        SuggesterField suggesterField = new SuggesterField();
        suggesterField.getRules().setRule(SOFT_RULE);
        //
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setCodeLists(new CodeLists());
        questionnaire.getCodeLists().getCodeList().add(new CodeList());
        SuggesterParametersType suggesterParameters = new SuggesterParametersType();
        suggesterParameters.getFields().add(suggesterField);
        questionnaire.getCodeLists().getCodeList().getFirst().setSuggesterParameters(suggesterParameters);

        // When
        JsonSerializer jsonSerializer = new JsonSerializer();
        String result = jsonSerializer.serialize(questionnaire);

        // Then
        String expectedJson = """
                {
                  "Questionnaire": {
                    "CodeLists": {
                      "CodeList": [
                        {
                          "SuggesterParameters": {
                            "fields": [
                              {
                                "rules": ["soft"]
                              }
                            ]
                          }
                        }
                      ]
                    }
                  }
                }""";
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    void deserializeRules_softCase() throws JsonDeserializationException {
        // Given + When
        JsonDeserializer jsonDeserializer = new JsonDeserializer();
        Questionnaire questionnaire = jsonDeserializer.deserialize(new ByteArrayInputStream(
                jsonInputSoftRules.getBytes()));

        // Then
        // (assuming intermediate objects are fine)
        SuggesterField suggesterField = questionnaire.getCodeLists().getCodeList().getFirst()
                .getSuggesterParameters().getFields().getFirst();
        assertEquals(List.of(SOFT_RULE), suggesterField.getRules().getPatterns());
    }

    @Test
    void deserializeRules_arrayCase() throws JsonDeserializationException {
        // Given + When
        JsonDeserializer jsonDeserializer = new JsonDeserializer();
        Questionnaire questionnaire = jsonDeserializer.deserialize(new ByteArrayInputStream(jsonInputArrayRules.getBytes()));

        // Then
        // (assuming intermediate objects are fine)
        SuggesterField suggesterField = questionnaire.getCodeLists().getCodeList().getFirst()
                .getSuggesterParameters().getFields().getFirst();
        assertEquals(List.of("[\\w]+"), suggesterField.getRules().getPatterns());
    }

    @Test
    void softRules_jsonToXml() throws JsonDeserializationException, XmlSerializationException {
        // Given + When
        JsonToXmlConverter jsonToXmlConverter = new JsonToXmlConverter();
        String xmlResult = jsonToXmlConverter.convertQuestionnaire(jsonInputSoftRules);

        // Then
        String expectedXml = """
                <?xml version="1.0" encoding="UTF-8"?>
                <Questionnaire xmlns="http://xml.insee.fr/schema/applis/pogues">
                  <CodeLists>
                    <CodeList>
                      <SuggesterParameters>
                        <fields>
                          <rules>soft</rules>
                        </fields>
                      </SuggesterParameters>
                    </CodeList>
                  </CodeLists>
                </Questionnaire>""";
        XmlAssert.assertThat(xmlResult).and(expectedXml).ignoreWhitespace().areIdentical();
    }

    @Test
    void arrayRules_jsonToXml() throws JsonDeserializationException, XmlSerializationException {
        // Given + When
        JsonToXmlConverter jsonToXmlConverter = new JsonToXmlConverter();
        String xmlResult = jsonToXmlConverter.convertQuestionnaire(jsonInputArrayRules);

        // Then
        String expectedXml = """
                <?xml version="1.0" encoding="UTF-8"?>
                <Questionnaire xmlns="http://xml.insee.fr/schema/applis/pogues">
                  <CodeLists>
                    <CodeList>
                      <SuggesterParameters>
                        <fields>
                          <rules>[\\w]+</rules>
                        </fields>
                      </SuggesterParameters>
                    </CodeList>
                  </CodeLists>
                </Questionnaire>""";
        XmlAssert.assertThat(xmlResult).and(expectedXml).ignoreWhitespace().areIdentical();
    }

}
