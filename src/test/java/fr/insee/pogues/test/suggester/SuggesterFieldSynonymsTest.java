package fr.insee.pogues.test.suggester;

import fr.insee.pogues.conversion.JSONToXMLTranslator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xmlunit.assertj3.XmlAssert;

import javax.xml.bind.JAXBException;

class SuggesterFieldSynonymsTest {

    private String jsonInput;

    @BeforeEach
    void setup() {
        jsonInput = """
            {
              "id": "foo-id",
              "CodeLists": {
                "CodeList": [
                  {
                    "Name": "FOO_SUGGESTER_LIST",
                    "SuggesterParameters": {
                      "fields": [
                        {
                          "name": "foo",
                          "synonyms": {
                            "foo": [
                              "BAR"
                            ],
                            "example": [
                              "INSTANCE",
                              "SAMPLE",
                              "ILLUSTRATION"
                            ]
                          }
                        }
                      ]
                    }
                  }
                ]
              }
            }""";
    }

    @Test
    void synonymsJsonToXml() throws JAXBException {
        //
        JSONToXMLTranslator jsonToXmlTranslator = new JSONToXMLTranslator();
        String result = jsonToXmlTranslator.translate(jsonInput);
        //
        String expectedXml = """
                <?xml version="1.0" encoding="UTF-8"?>
                <Questionnaire xmlns="http://xml.insee.fr/schema/applis/pogues" id="foo-id">
                   <CodeLists>
                      <CodeList>
                         <Name>FOO_SUGGESTER_LIST</Name>
                         <SuggesterParameters>
                            <fields>
                               <name>foo</name>
                               <synonyms>
                                  <source>foo</source>
                                  <target>BAR</target>
                               </synonyms>
                               <synonyms>
                                  <source>example</source>
                                  <target>INSTANCE</target>
                                  <target>SAMPLE</target>
                                  <target>ILLUSTRATION</target>
                               </synonyms>
                            </fields>
                         </SuggesterParameters>
                      </CodeList>
                   </CodeLists>
                </Questionnaire>""";
        XmlAssert.assertThat(result).and(expectedXml).ignoreWhitespace().areIdentical();
    }

}
