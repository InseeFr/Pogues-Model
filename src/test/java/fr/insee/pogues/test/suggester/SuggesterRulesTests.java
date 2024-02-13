package fr.insee.pogues.test.suggester;

import fr.insee.pogues.conversion.JSONDeserializer;
import fr.insee.pogues.conversion.JSONSerializer;
import fr.insee.pogues.model.*;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggesterRulesTests {

    private static final String SOFT_RULE = "soft";

    @Test
    void serializeRules_softCase() throws JAXBException, UnsupportedEncodingException, JSONException {
        // Given
        SuggesterField suggesterField = new SuggesterField();
        suggesterField.getRules().add(SOFT_RULE);
        //
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setCodeLists(new CodeLists());
        questionnaire.getCodeLists().getCodeList().add(new CodeList());
        SuggesterParametersType suggesterParameters = new SuggesterParametersType();
        suggesterParameters.getFields().add(suggesterField);
        questionnaire.getCodeLists().getCodeList().getFirst().setSuggesterParameters(suggesterParameters);

        // When
        JSONSerializer jsonSerializer = new JSONSerializer();
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
    void deserializeRules_softCase() throws JAXBException {
        // Given
        String jsonInput = """
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

        // When
        JSONDeserializer jsonDeserializer = new JSONDeserializer();
        Questionnaire questionnaire = jsonDeserializer.deserialize(new ByteArrayInputStream(jsonInput.getBytes()));

        // Then
        // (assuming intermediate objects are fine)
        SuggesterField suggesterField = questionnaire.getCodeLists().getCodeList().getFirst()
                .getSuggesterParameters().getFields().getFirst();
        assertEquals(List.of(SOFT_RULE), suggesterField.getRules());
    }

    @Test
    void deserializeRules_arrayCase() throws JAXBException {
        // Given
        String jsonInput = """
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

        // When
        JSONDeserializer jsonDeserializer = new JSONDeserializer();
        Questionnaire questionnaire = jsonDeserializer.deserialize(new ByteArrayInputStream(jsonInput.getBytes()));

        // Then
        // (assuming intermediate objects are fine)
        SuggesterField suggesterField = questionnaire.getCodeLists().getCodeList().getFirst()
                .getSuggesterParameters().getFields().getFirst();
        assertEquals(List.of("[\\w]+"), suggesterField.getRules());
    }

}
