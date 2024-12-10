package fr.insee.pogues.test;

import fr.insee.pogues.conversion.XMLToJSONTranslator;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import javax.xml.bind.JAXBException;

class XMLToJSONTranslatorTest {

    private String xmlCodeList;
    private String xmlLastUpdatedDate;
    private String xmlChildQuestionnaireRef;
    private String xmlOwner;

    @BeforeEach
    void setup() {
        xmlCodeList = """
                <CodeList xmlns="http://xml.insee.fr/schema/applis/pogues" id="code-list-id">
                  <Name>CODE_LIST_NAME</Name>
                  <Label>Code list label.</Label>
                  <Code>
                    <Value>1</Value>
                    <Label>CODE_1</Label>
                  </Code>
                  <Code>
                    <Value>2</Value>
                    <Label>CODE_2</Label>
                  </Code>
                </CodeList>""";
        xmlLastUpdatedDate = """
                <Questionnaire 
                    xmlns="http://xml.insee.fr/schema/applis/pogues"
                    id="questionnaire-id" 
                    lastUpdatedDate="Tue Dec 10 2024 10:33:38 GMT+0100 (heure normale d’Europe centrale)"/>
                """;
        xmlChildQuestionnaireRef = """
                <Questionnaire 
                    xmlns="http://xml.insee.fr/schema/applis/pogues"
                    id="questionnaire-id">
                    <childQuestionnaireRef>ref-id-1</childQuestionnaireRef>
                    <childQuestionnaireRef>ref-id-2</childQuestionnaireRef>
                </Questionnaire>
                """;
        xmlOwner = """
               <Questionnaire xmlns="http://xml.insee.fr/schema/applis/pogues" id="questionnaire-id" owner="NiceOwner"/>
                """;
    }

    @Test
    void translateCodeList() throws JAXBException, JSONException {
        //
        XMLToJSONTranslator xmlToJsonTranslator = new XMLToJSONTranslator();
        String result = xmlToJsonTranslator.translateCodeList(xmlCodeList);
        //
        String expectedJson = """
                {
                  "id": "code-list-id",
                  "Name": "CODE_LIST_NAME",
                  "Label": "Code list label.",
                  "Code": [
                    {
                      "Value": "1",
                      "Label": "CODE_1"
                    },
                    {
                      "Value": "2",
                      "Label": "CODE_2"
                    }
                  ]
                }""";
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    void translateLastUpdatedDate() throws JAXBException, JSONException {
        //
        XMLToJSONTranslator xmlToJsonTranslator = new XMLToJSONTranslator();
        String result = xmlToJsonTranslator.translate(xmlLastUpdatedDate);
        //
        String expectedJson = """
                {
                  "id": "questionnaire-id",
                  "lastUpdatedDate": "Tue Dec 10 2024 10:33:38 GMT+0100 (heure normale d’Europe centrale)"
                }""";
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    void translateChildQuestionnaireRef() throws JAXBException, JSONException {
        //
        XMLToJSONTranslator xmlToJsonTranslator = new XMLToJSONTranslator();
        String result = xmlToJsonTranslator.translate(xmlChildQuestionnaireRef);
        //
        String expectedJson = """
                {
                  "id": "questionnaire-id",
                  "childQuestionnaireRef": [ "ref-id-1", "ref-id-2" ]
                }
                """;
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    void translateOwner() throws JAXBException, JSONException {
        //
        XMLToJSONTranslator xmlToJsonTranslator = new XMLToJSONTranslator();
        String result = xmlToJsonTranslator.translate(xmlOwner);
        //
        String expectedJson = """
                {
                  "id": "questionnaire-id",
                  "owner": "NiceOwner"
                }
                """;
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

}
