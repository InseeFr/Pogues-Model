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
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggesterSerializationTests {

    @Test
    void serializeSuggesterQueryParserParams() throws JAXBException, UnsupportedEncodingException, JSONException {
        // Given a suggester query params
        SuggesterQueryParserParams queryParserParams = new SuggesterQueryParserParams();
        queryParserParams.setLanguage("FR");
        queryParserParams.setMin(BigInteger.ONE);
        queryParserParams.setPattern("(\\w+)");
        queryParserParams.setStemmer(true);
        // in a questionnaire object
        Questionnaire questionnaire = new Questionnaire();
        CodeList codeList = new CodeList();
        SuggesterQueryParser queryParser = new SuggesterQueryParser();
        queryParser.setParams(queryParserParams);
        codeList.setSuggesterParameters(new SuggesterParametersType());
        codeList.getSuggesterParameters().setQueryParser(queryParser);
        questionnaire.setCodeLists(new CodeLists());
        questionnaire.getCodeLists().getCodeList().add(codeList);

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
                            "queryParser": {
                              "params": {
                                "language": "FR",
                                "min": 1,
                                "pattern": "(\\\\w+)",
                                "stemmer": true
                              }
                            }
                          }
                        }
                      ]
                    }
                  }
                }""";
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    void deserializeSuggesterQueryParserParams() throws JAXBException {
        // Given
        String jsonInput = """
                {
                  "CodeLists": {
                    "CodeList": [
                      {
                        "SuggesterParameters": {
                          "queryParser": {
                            "params": {
                              "language": "FR",
                              "min": 1,
                              "pattern": "(\\\\w+)",
                              "stemmer": true
                            }
                          }
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
        SuggesterQueryParserParams queryParserParams = questionnaire.getCodeLists().getCodeList().getFirst()
                .getSuggesterParameters().getQueryParser().getParams();
        //
        assertEquals("FR", queryParserParams.getLanguage());
        assertEquals(BigInteger.ONE, queryParserParams.getMin());
        assertEquals("(\\w+)", queryParserParams.getPattern());
        assertEquals(true, queryParserParams.isStemmer());
    }

}
