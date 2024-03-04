package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JSONSynonymsPreProcessor;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;

class JSONSynonymsPreProcessorTest {


    @Test
    void transformSynonyms() throws IOException, JSONException {
        //
        String jsonInput = """
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
        //
        JSONSynonymsPreProcessor jsonSynonymsPreProcessor = new JSONSynonymsPreProcessor();
        String result = jsonSynonymsPreProcessor.transform(jsonInput);
        //
        String expected = """
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
                              "synonyms": [
                                {
                                  "source": "foo",
                                  "target": [
                                    "BAR"
                                  ]
                                },
                                {
                                  "source": "example",
                                  "target": [
                                    "INSTANCE",
                                    "SAMPLE",
                                    "ILLUSTRATION"
                                  ]
                                }
                              ]
                            }
                          ]
                        }
                      }
                    ]
                  }
                }""";
        JSONAssert.assertEquals(expected, result, JSONCompareMode.STRICT);
    }

}
