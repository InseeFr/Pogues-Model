package fr.insee.pogues.test;

import fr.insee.pogues.conversion.XMLToJSONTranslator;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import javax.xml.bind.JAXBException;
import java.io.UnsupportedEncodingException;

class XMLToJSONTanslatorTest {

	private String xmlCodeList;

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
	}

	@Test
    void translateCodeList() throws JAXBException, UnsupportedEncodingException, JSONException {
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

}
