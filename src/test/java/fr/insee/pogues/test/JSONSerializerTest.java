package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JSONSerializer;
import fr.insee.pogues.mock.*;
import fr.insee.pogues.model.*;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


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
		;

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
	public void serializeRowLevelControl() throws JAXBException, UnsupportedEncodingException, JSONException {
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
	public void serializeCodeListFilters() throws JAXBException, UnsupportedEncodingException, JSONException {
		Questionnaire questionnaire = new Questionnaire();
		QuestionType questionType = new QuestionType();
		CodeFilter codeFilter18 = new CodeFilter();
		codeFilter18.setCodeValue("01");
		codeFilter18.setConditionFilter("$AGE$ > 18");
		CodeFilter codeFilter30 = new CodeFilter();
		codeFilter30.setCodeValue("02");
		codeFilter30.setConditionFilter("$AGE$ > 30");
		questionType.getCodeFilters().add(codeFilter18);
		;
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
	public void serializeGenericName() throws JAXBException, UnsupportedEncodingException, JSONException {
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
	public void serializeConditionFilterInDatatypeInTableResponse() throws JAXBException, UnsupportedEncodingException, JSONException {
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
	public void serializeConditionReadOnlyInDatatypeInTableResponse() throws JAXBException, UnsupportedEncodingException, JSONException {
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
		dimensionType.setDynamic(DynamicTypeEnum.DYNAMIC);
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
				                "maximum":{
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
		dimensionType.setDynamic(DynamicTypeEnum.DYNAMIC);
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
				                "maximum":{
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
		dimensionType.setDynamic(DynamicTypeEnum.DYNAMIC_FIXED);
		TypedValueType size = new TypedValueType();
		size.setType(ValueTypeEnum.NUMBER);
		size.setValue("5");
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
				                    "type": "number",
				                    "value": "5"
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

}
