package fr.insee.pogues.test;

import fr.insee.pogues.conversion.XmlDeserializer;
import fr.insee.pogues.conversion.XmlToJsonConverter;
import fr.insee.pogues.exception.JsonSerializationException;
import fr.insee.pogues.exception.XmlDeserializationException;
import fr.insee.pogues.model.Questionnaire;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class XmlToJsonConverterTest {

    private String xmlCodeList;
	String codeList2;
    @BeforeEach
    void setup() {
        xmlCodeList = """
                <Questionnaire type="Questionnaire">
				<CodeLists>
				<CodeList id="code-list-id">
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
				</CodeList>
				</CodeLists>
				</Questionnaire>""";
		codeList2 = """
                <Questionnaire>
				<CodeLists>
				<CodeList id="toto">
				</CodeList>
				</CodeLists>
				</Questionnaire>""";
    }

    @Test
    void translateCodeList() throws XmlDeserializationException, JsonSerializationException, JSONException {
        //
        XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter();
        Questionnaire questionnaire = new XmlDeserializer().deserialize(new ByteArrayInputStream(codeList2.getBytes()));
		assertNotNull(questionnaire);
//        String result = xmlToJsonConverter.convertQuestionnaire(xmlCodeList);
//        //
//        String expectedJson = """
//                {
//                  "type": "Questionnaire",
//                  "CodeLists": {
//                    "CodeList": [
//                      {
//                        "id": "code-list-id",
//                        "Name": "CODE_LIST_NAME",
//                        "Label": "Code list label.",
//                        "Code": [
//                          {
//                            "Value": "1",
//                            "Label": "CODE_1"
//                          },
//                          {
//                            "Value": "2",
//                            "Label": "CODE_2"
//                          }
//                        ]
//                      }
//                    ]
//                  }
//                }""";
//        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

}
