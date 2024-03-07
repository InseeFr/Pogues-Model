package fr.insee.pogues.test.suggester;

import fr.insee.pogues.conversion.JSONDeserializer;
import fr.insee.pogues.conversion.JSONSerializer;
import fr.insee.pogues.conversion.JSONToXMLTranslator;
import fr.insee.pogues.model.CodeList;
import fr.insee.pogues.model.CodeLists;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.SuggesterParametersType;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.xmlunit.assertj3.XmlAssert;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggesterParametersTypeTest {

    private final String jsonSuggesters = """
            {
              "id": "questionnaire-id",
              "CodeLists": {
                "CodeList": [
                  {
                    "SuggesterParameters": {
                      "url": "some url",
                      "version": 1
                    }
                  }
                ]
              }
            }""";

    @Test
    void serializeJsonSuggesters() throws JAXBException, UnsupportedEncodingException, JSONException {
        //
        CodeList codeList = new CodeList();
        SuggesterParametersType suggesterParametersType = new SuggesterParametersType();
        suggesterParametersType.setUrl("some url");
        suggesterParametersType.setVersion(BigInteger.ONE);
        codeList.setSuggesterParameters(suggesterParametersType);
        //
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setId("questionnaire-id");
        questionnaire.setCodeLists(new CodeLists());
        questionnaire.getCodeLists().getCodeList().add(codeList);

        //
        JSONSerializer jsonSerializer = new JSONSerializer();
        String result = jsonSerializer.serialize(questionnaire);

        // Current json serializer implementation wraps content in a "Questionnaire" node
        String expectedJson = "{\"Questionnaire\":" + jsonSuggesters + "}";
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    void deserializeJsonSuggesters() throws JAXBException {
        //
        JSONDeserializer jsonDeserializer = new JSONDeserializer();
        Questionnaire questionnaire = jsonDeserializer.deserialize(
                new ByteArrayInputStream(jsonSuggesters.getBytes()));
        //
        SuggesterParametersType suggesterParameters = questionnaire.getCodeLists().getCodeList().getFirst().getSuggesterParameters();
        assertEquals("some url", suggesterParameters.getUrl());
        assertEquals(BigInteger.ONE, suggesterParameters.getVersion());
    }

    @Test
    void suggestersJsonToXml() throws JAXBException {
        //
        String xmlResult = new JSONToXMLTranslator().translate(jsonSuggesters);
        //
        String expectedXml = """
                <?xml version="1.0" encoding="UTF-8"?>
                <Questionnaire xmlns="http://xml.insee.fr/schema/applis/pogues" id="questionnaire-id">
                    <CodeLists>
                        <CodeList>
                            <SuggesterParameters>
                                <url>some url</url>
                                <version>1</version>
                            </SuggesterParameters>
                        </CodeList>
                    </CodeLists>
                </Questionnaire>
                """;
        XmlAssert.assertThat(xmlResult).and(expectedXml).ignoreWhitespace().areIdentical();
    }

}
