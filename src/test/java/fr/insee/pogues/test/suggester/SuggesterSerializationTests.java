package fr.insee.pogues.test.suggester;

import fr.insee.pogues.conversion.JSONSerializer;
import fr.insee.pogues.model.*;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import javax.xml.bind.JAXBException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

class SuggesterSerializationTests {

    @Test
    void serializeSuggesterQueryParserParams() throws JAXBException, UnsupportedEncodingException, JSONException {
        //
        SuggesterQueryParserParams queryParserParams = new SuggesterQueryParserParams();
        queryParserParams.setLanguage("FR");
        queryParserParams.setMin(BigInteger.ONE);
        queryParserParams.setPattern("(\\w+)");
        queryParserParams.setStemmer(true);
        //
        Questionnaire questionnaire = new Questionnaire();
        CodeList codeList = new CodeList();
        SuggesterQueryParser queryParser = new SuggesterQueryParser();
        queryParser.setParams(queryParserParams);
        codeList.setSuggesterParameters(new SuggesterParametersType());
        codeList.getSuggesterParameters().setQueryParser(queryParser);
        questionnaire.setCodeLists(new CodeLists());
        questionnaire.getCodeLists().getCodeList().add(codeList);

        //
        JSONSerializer jsonSerializer = new JSONSerializer();
        String result = jsonSerializer.serialize(questionnaire);

        //
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

}
