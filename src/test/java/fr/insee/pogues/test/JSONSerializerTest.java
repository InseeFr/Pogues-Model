package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JSONSerializer;
import fr.insee.pogues.mock.*;
import fr.insee.pogues.model.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.util.Source;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class JSONSerializerTest {

	@Test
	void testQuestionnaire() throws Exception {

		QuestionnaireFactory factory = new QuestionnaireFactory();
		Questionnaire fakeQuestionnaire = factory.createQuestionnaire();

		long startTime = System.currentTimeMillis();

		JSONSerializer serializer = new JSONSerializer();
		String jsonQuestionnaire = serializer.serialize(fakeQuestionnaire);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/questionnaire.json"), jsonQuestionnaire, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testQuestionnaireWithOrWithoutRoot() throws Exception {

		QuestionnaireFactory factory = new QuestionnaireFactory();
		Questionnaire fakeQuestionnaire = factory.createMinimalQuestionnaire();

		JSONSerializer serializer1 = new JSONSerializer();
		JSONSerializer serializer2 = new JSONSerializer(true);
		String withRoot = serializer1.serialize(fakeQuestionnaire);
		String withoutRoot = serializer2.serialize(fakeQuestionnaire);

		String expectedJsonWithRoot = """
				{
				    "Questionnaire": {
				    	"id" : "test",
				    	"agency" : "Insee",
				    	"final" : true,
				    	"flowLogic" : "FILTER",
				    	"Name" : "Without root questionnaire"
				    }
				 }""";

		String expectedJsonWithoutRoot = """
				{
				    "id" : "test",
				    "agency" : "Insee",
				    "final" : true,
				    "flowLogic" : "FILTER",
				    "Name" : "Without root questionnaire"
				 }""";
		JSONAssert.assertEquals(expectedJsonWithRoot, withRoot, JSONCompareMode.STRICT);
		JSONAssert.assertEquals(expectedJsonWithoutRoot, withoutRoot, JSONCompareMode.STRICT);
	}

	@Test
	void testSequence() throws Exception {

		SequenceFactory factory = new SequenceFactory();
		SequenceType fakeSequence = factory.createSequence(2);

		long startTime = System.currentTimeMillis();

		JSONSerializer serializer = new JSONSerializer();
		String jsonSequence = serializer.serialize(fakeSequence);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/sequence-ser.json"), jsonSequence, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testCodeList() throws Exception {

		CodeListFactory factory = new CodeListFactory();
		CodeList fakeCodeList = factory.createCodeList();

		long startTime = System.currentTimeMillis();

		JSONSerializer serializer = new JSONSerializer();
		String jsonCodeList = serializer.serialize(fakeCodeList);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/codelist-ser.json"), jsonCodeList, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testQuestion() throws Exception {

		QuestionFactory factory = new QuestionFactory();
		QuestionType fakeQuestion = factory.createQuestion(42);

		long startTime = System.currentTimeMillis();

		JSONSerializer serializer = new JSONSerializer();
		String jsonQuestion = serializer.serialize(fakeQuestion);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/question-ser.json"), jsonQuestion, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testQuestionOnly() throws Exception {

		QuestionFactory factory = new QuestionFactory();
		QuestionType fakeQuestion = factory.createQuestionOnly(50);

		long startTime = System.currentTimeMillis();

		JSONSerializer serializer = new JSONSerializer();
		String jsonQuestion = serializer.serialize(fakeQuestion);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/question-ser.json"), jsonQuestion, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testResponse() throws Exception {

		ResponseFactory factory = new ResponseFactory();
		ResponseType fakeResponse = factory.createResponse();

		long startTime = System.currentTimeMillis();

		JSONSerializer serializer = new JSONSerializer();
		String jsonResponse = serializer.serialize(fakeResponse);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/response-ser.json"), jsonResponse, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void serializeCodeList() throws JAXBException, UnsupportedEncodingException, JSONException {
		// Given
		JSONSerializer jsonSerializer = new JSONSerializer();
		CodeList codeList = new CodeList();
		codeList.setId("code-list-id");
		codeList.setName("CODE_LIST_NAME");
		codeList.setLabel("Code list label.");
		CodeType code1 = new CodeType();
		code1.setLabel("CODE_1");
		code1.setValue("1");
		CodeType code2 = new CodeType();
		code2.setLabel("CODE_2");
		code2.setValue("2");
		codeList.getCode().add(code1);
		codeList.getCode().add(code2);
		// When
		String result = jsonSerializer.serialize(codeList);
		// Then
		String expectedJson = """
				{
				  "CodeList": {
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
				  }
				}""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void testSynonyms() throws JAXBException, IOException, JSONException {
		QuestionnaireFactory factory = new QuestionnaireFactory();
		Questionnaire questionnaire = factory.createQuestionnaireWithSynonyms();

		JSONSerializer serializer = new JSONSerializer();
		JSONSerializer serializerWithoutRoot = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String resultWithoutRoot = serializerWithoutRoot.serialize(questionnaire);
		String expectedJson = """
				{
				   "Questionnaire": {
				     "id": "test",
				     "CodeLists": {
				       "CodeList": [
				         {
				           "SuggesterParameters": {
				             "fields": [{ "synonyms": { "foo": ["one", "two"] } }]
				           }
				         }
				       ]
				     }
				   }
				}""";
		String expectedJsonWithoutRoot = """
				{
				    "id": "test",
				    "CodeLists": {
				      "CodeList": [
				        {
				          "SuggesterParameters": {
				            "fields": [{ "synonyms": { "foo": ["one", "two"] } }]
				          }
				        }
				      ]
				    }
				}""";

		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
		JSONAssert.assertEquals(expectedJsonWithoutRoot, resultWithoutRoot, JSONCompareMode.STRICT);

	}

	@Test
	void serializeRowLevelControl() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		ComponentType componentType = new QuestionType();
		ControlType controlOccurrence = new ControlType();
		controlOccurrence.setScope(ControlScopeEnum.OCCURRENCE);
		ControlType controlWhole = new ControlType();
		controlWhole.setScope(ControlScopeEnum.WHOLE);
		componentType.getControl().addAll(List.of(controlOccurrence, controlWhole));
		questionnaire.getChild().add(componentType);
		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				   "Child": [
				     {
				       "type": "QuestionType",
				       "Control": [{ "scope": "occurrence" }, { "scope": "whole" }]
				     }
				   ]
				 }
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void serializeCodeListFilters() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		QuestionType questionType = new QuestionType();
		CodeFilter codeFilter18 = new CodeFilter();
		codeFilter18.setCodeValue("01");
		codeFilter18.setConditionFilter("$AGE$ > 18");
		CodeFilter codeFilter30 = new CodeFilter();
		codeFilter30.setCodeValue("02");
		codeFilter30.setConditionFilter("$AGE$ > 30");
		questionType.getCodeFilters().add(codeFilter18);
		questionType.getCodeFilters().add(codeFilter30);
		questionnaire.getChild().add(questionType);
		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				   "Child": [
				     {
				       "type": "QuestionType",
				       "codeFilters": [
				       		{ "codeValue": "01", "conditionFilter": "$AGE$ > 18" },
				       		{ "codeValue": "02", "conditionFilter": "$AGE$ > 30" }
				       	]
				     }
				   ]
				 }
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void serializeGenericName() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		SequenceType sequenceType = new SequenceType();
		sequenceType.setGenericName(GenericNameEnum.EXTERNAL_ELEMENT);
		questionnaire.getChild().add(sequenceType);
		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				   "Child": [
				     {
				       "type": "SequenceType",
				       "genericName": "EXTERNAL_ELEMENT"
				     }
				   ]
				 }
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void serializeConditionFilterInDatatypeInTableResponse() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		QuestionType questionType = new QuestionType();
		ResponseType response = new ResponseType();
		response.setConditionFilter("$PRENOM$ = \"Laurent\"");
		questionType.getResponse().add(response);
		questionnaire.getChild().add(questionType);
		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				   "Child": [
				     {
				       "type": "QuestionType",
				       "Response": [ { "conditionFilter": "$PRENOM$ = \\"Laurent\\"" } ]
				     }
				   ]
				 }
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void serializeConditionReadOnlyInDatatypeInTableResponse() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		QuestionType questionType = new QuestionType();
		ResponseType response = new ResponseType();
		response.setConditionReadOnly("$PRENOM$ = \"Remi\"");
		questionType.getResponse().add(response);
		questionnaire.getChild().add(questionType);
		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				   "Child": [
				     {
				       "type": "QuestionType",
				       "Response": [ { "conditionReadOnly": "$PRENOM$ = \\"Remi\\"" } ]
				     }
				   ]
				 }
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void serializeDynamicNumberMinMaxInDimensionTable() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		QuestionType questionType = new QuestionType();
		ResponseStructureType responseStructureType = new ResponseStructureType();
		DimensionType dimensionType = new DimensionType();
		dimensionType.setDimensionType(DimensionTypeEnum.PRIMARY);
		dimensionType.setDynamic("DYNAMIC");
		TypedValueType min = new TypedValueType();
		min.setType(ValueTypeEnum.NUMBER);
		min.setValue("2");
		TypedValueType max = new TypedValueType();
		max.setType(ValueTypeEnum.NUMBER);
		max.setValue("10");
		dimensionType.setMinimum(min);
		dimensionType.setMaximum(max);
		responseStructureType.getDimension().add(dimensionType);
		questionType.setResponseStructure(responseStructureType);
		questionnaire.getChild().add(questionType);
		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				  "Child": [
				    {
				      "type": "QuestionType",
				      "ResponseStructure": {
				        "Dimension": [
				          {
				            "dimensionType": "PRIMARY",
				            "dynamic": "DYNAMIC",
				            "minimum": {
				              "type": "number",
				              "value": "2"
				            },
				            "maximum": {
				              "type": "number",
				              "value": "10"
				            }
				          }
				        ]
				      }
				    }
				  ]
				}
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void serializeDynamicVTLMinMaxInDimensionTable() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		QuestionType questionType = new QuestionType();
		ResponseStructureType responseStructureType = new ResponseStructureType();
		DimensionType dimensionType = new DimensionType();
		dimensionType.setDimensionType(DimensionTypeEnum.PRIMARY);
		dimensionType.setDynamic("DYNAMIC");
		TypedValueType min = new TypedValueType();
		min.setType(ValueTypeEnum.VTL);
		min.setValue("count($PRENOM$)");
		TypedValueType max = new TypedValueType();
		max.setType(ValueTypeEnum.VTL);
		max.setValue("count($PRENOM$) + 10");
		dimensionType.setMinimum(min);
		dimensionType.setMaximum(max);
		responseStructureType.getDimension().add(dimensionType);
		questionType.setResponseStructure(responseStructureType);
		questionnaire.getChild().add(questionType);
		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				  "Child": [
				    {
				      "type": "QuestionType",
				      "ResponseStructure": {
				        "Dimension": [
				          {
				            "dimensionType": "PRIMARY",
				            "dynamic": "DYNAMIC",
				            "minimum": {
				              "type": "VTL",
				              "value": "count($PRENOM$)"
				            },
				            "maximum": {
				              "type": "VTL",
				              "value": "count($PRENOM$) + 10"
				            }
				          }
				        ]
				      }
				    }
				  ]
				}
				
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void serializeDynamicFixedSizeInDimensionTable() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		QuestionType questionType = new QuestionType();
		ResponseStructureType responseStructureType = new ResponseStructureType();
		DimensionType dimensionType = new DimensionType();
		dimensionType.setDimensionType(DimensionTypeEnum.PRIMARY);
		dimensionType.setDynamic("DYNAMIC_FIXED");
		TypedValueType size = new TypedValueType();
		size.setType(ValueTypeEnum.VTL);
		size.setValue("count($PRENOM$)");
		dimensionType.setSize(size);
		responseStructureType.getDimension().add(dimensionType);
		questionType.setResponseStructure(responseStructureType);
		questionnaire.getChild().add(questionType);
		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				  "Child": [
				    {
				      "type": "QuestionType",
				      "ResponseStructure": {
				        "Dimension": [
				          {
				            "dimensionType": "PRIMARY",
				            "dynamic": "DYNAMIC_FIXED",
				            "size": {
				              "type": "VTL",
				              "value": "count($PRENOM$)"
				            }
				          }
				        ]
				      }
				    }
				  ]
				}
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void serializeNonDynamicInDimensionTable() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		QuestionType questionType = new QuestionType();
		ResponseStructureType responseStructureType = new ResponseStructureType();
		DimensionType dimensionType = new DimensionType();
		dimensionType.setDimensionType(DimensionTypeEnum.PRIMARY);
		dimensionType.setDynamic("NON_DYNAMIC");
		dimensionType.setCodeListReference("refCodeList");
		responseStructureType.getDimension().add(dimensionType);
		questionType.setResponseStructure(responseStructureType);
		questionnaire.getChild().add(questionType);
		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				  "Child": [
				    {
				      "type": "QuestionType",
				      "ResponseStructure": {
				        "Dimension": [
				          {
				            "CodeListReference": "refCodeList",
				            "dimensionType": "PRIMARY",
				            "dynamic": "NON_DYNAMIC"
				          }
				        ]
				      }
				    }
				  ]
				}
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void serializeIterationPagination() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		DynamicIterationType dynamicIterationType = new DynamicIterationType();
		ExpressionType minimum = new ExpressionType();
		minimum.setValue("1");
		ExpressionType maximum = new ExpressionType();
		maximum.setValue("5");
		dynamicIterationType.setMinimum(minimum);
		dynamicIterationType.setMaximum(maximum);
		dynamicIterationType.setShouldSplitIterations(true);

		Questionnaire.Iterations iterations = new Questionnaire.Iterations();
		iterations.getIteration().add(dynamicIterationType);
		questionnaire.setIterations(iterations);

		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				  "Iterations": {
				  	"Iteration": [
				  		{
				  			"type": "DynamicIterationType",
				  			"minimum": "1",
				  			"maximum": "5",
				  			"shouldSplitIterations": true
				  		}
				  	]
				  }
				}
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	void serializeIterationPaginationFixedLength() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		DynamicIterationType dynamicIterationType = new DynamicIterationType();
		ExpressionType size = new ExpressionType();
		size.setValue("42");
		dynamicIterationType.setSize(size);
		dynamicIterationType.setIsFixedLength(true);
		dynamicIterationType.setShouldSplitIterations(true);

		Questionnaire.Iterations iterations = new Questionnaire.Iterations();
		iterations.getIteration().add(dynamicIterationType);
		questionnaire.setIterations(iterations);

		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		String expectedJson = """
				{
				  "Iterations": {
				  	"Iteration": [
				  		{
				  			"type": "DynamicIterationType",
				  			"size": "42",
				  			"isFixedLength": true,
				  			"shouldSplitIterations": true
				  		}
				  	]
				  }
				}
				""";
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

    @Test
    void serializeExternalVariableIsDeletedOnReset() throws JAXBException, UnsupportedEncodingException, JSONException {
        Questionnaire questionnaire = new Questionnaire();

        ExternalVariableType externalVariableType = new ExternalVariableType();
        externalVariableType.setId("ext1");
        externalVariableType.setName("NUMERO_MENAGE");
        externalVariableType.setLabel("Numéro du ménage");
        externalVariableType.setDeletedOnReset(true);

        Questionnaire.Variables variables = new Questionnaire.Variables();
        variables.getVariable().add(externalVariableType);
        questionnaire.setVariables(variables);

        JSONSerializer serializer = new JSONSerializer(true);
        String result = serializer.serialize(questionnaire);

        String expectedJson = """
            {
              "Variables": {
                "Variable": [
                  {
                    "type": "ExternalVariableType",
                    "id": "ext1",
                    "Name": "NUMERO_MENAGE",
                    "Label": "Numéro du ménage",
                    "isDeletedOnReset": true
                  }
                ]
              }
            }
            """;

        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    void serializePairwiseSourceVariableReferences() throws JAXBException, UnsupportedEncodingException, JSONException {
				// Given a questionnaire with a question with sourceVariableReferences
        Questionnaire questionnaire = new Questionnaire();

        QuestionType pairwiseQuestion = new QuestionType();
				SourceVariableReferences sourceVariableReferences = new SourceVariableReferences();
				sourceVariableReferences.setName("var-name-id");
				sourceVariableReferences.setGender("var-gender-id");
				sourceVariableReferences.setAge("var-age-id");
				pairwiseQuestion.setSourceVariableReferences(sourceVariableReferences);
		
				questionnaire.getChild().add(pairwiseQuestion);

				// When it is serialized
        JSONSerializer serializer = new JSONSerializer(true);
        String result = serializer.serialize(questionnaire);

        String expectedJson = """
            {
							"Child": [
								{
									"type": "QuestionType",
									"sourceVariableReferences": {
										"name": "var-name-id",
										"gender": "var-gender-id",
										"age": "var-age-id"
									}
								}
							]
            }
            """;

				// Then the sourceVariableReferences are correctly serialized
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    void testSerializeVariableResponsesFullConfiguration() throws Exception {

        QuestionType question = new QuestionType();
        question.setQuestionType(QuestionTypeEnum.SINGLE_CHOICE);
        question.setChoiceType(ChoiceTypeEnum.VARIABLE_RESPONSES);
        question.setOptionFilter("nvl($AGE$, 0) > 18");

        ResponseType response = new ResponseType();
        response.setVariableReference("id-loop-variable");

        question.getResponse().add(response);

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.getChild().add(question);

        JSONSerializer serializer = new JSONSerializer();
        String json = serializer.serialize(questionnaire);

        assertTrue(json.contains("\"choiceType\":\"VARIABLE_RESPONSES\""));
        assertTrue(json.contains("\"OptionFilter\":\"nvl($AGE$, 0) > 18\""));
        assertTrue(json.contains("\"VariableReference\":\"id-loop-variable\""));
    }
}
