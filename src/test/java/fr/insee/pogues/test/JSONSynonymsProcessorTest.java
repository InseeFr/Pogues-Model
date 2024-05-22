package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JSONSynonymsPostProcessor;
import fr.insee.pogues.conversion.JSONSynonymsPreProcessor;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

class JSONSynonymsProcessorTest {


    private String questionnaireSynonymsObject = """
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

    private String questionnaireSynonymsArray = """
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

    @Test
    void preProcessingTransformSynonyms() throws JSONException {
        JSONSynonymsPreProcessor jsonSynonymsPreProcessor = new JSONSynonymsPreProcessor();
        String result = jsonSynonymsPreProcessor.transform(questionnaireSynonymsObject);
        JSONAssert.assertEquals(questionnaireSynonymsArray, result, JSONCompareMode.STRICT);
    }

    @Test
    void postProcessingTransformSynonyms() throws JSONException {
        JSONSynonymsPostProcessor jsonSynonymsPostProcessor = new JSONSynonymsPostProcessor();
        String result = jsonSynonymsPostProcessor.transform(questionnaireSynonymsArray);
        JSONAssert.assertEquals(questionnaireSynonymsObject, result, JSONCompareMode.STRICT);
    }

    @Test
    void identityPrePostPocessingTransformSynonyms() throws JSONException {
        JSONSynonymsPreProcessor jsonSynonymsPreProcessor = new JSONSynonymsPreProcessor();
        JSONSynonymsPostProcessor jsonSynonymsPostProcessor = new JSONSynonymsPostProcessor();
        String result = jsonSynonymsPostProcessor.transform(jsonSynonymsPreProcessor.transform(questionnaireSynonymsObject));
        JSONAssert.assertEquals(questionnaireSynonymsObject, result, JSONCompareMode.STRICT);
    }

    @Test
    void identityPostPrePocessingTransformSynonyms() throws JSONException {
        JSONSynonymsPostProcessor jsonSynonymsPostProcessor = new JSONSynonymsPostProcessor();
        JSONSynonymsPreProcessor jsonSynonymsPreProcessor = new JSONSynonymsPreProcessor();
        String result = jsonSynonymsPreProcessor.transform(jsonSynonymsPostProcessor.transform(questionnaireSynonymsArray));
        JSONAssert.assertEquals(questionnaireSynonymsArray, result, JSONCompareMode.STRICT);
    }

}
