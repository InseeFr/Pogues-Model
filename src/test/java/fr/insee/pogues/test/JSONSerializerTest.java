package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JsonSerializer;
import fr.insee.pogues.exception.JsonSerializationException;
import fr.insee.pogues.mock.*;
import fr.insee.pogues.model.*;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.UnsupportedEncodingException;


class JsonSerializerTest {

	@Test
	void testQuestionnaire() throws Exception {

		QuestionnaireFactory factory = new QuestionnaireFactory();
		Questionnaire fakeQuestionnaire = factory.createQuestionnaire();

		long startTime = System.currentTimeMillis();

		JsonSerializer serializer = new JsonSerializer();
		String jsonQuestionnaire = serializer.serialize(fakeQuestionnaire);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/questionnaire.json"), jsonQuestionnaire, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testSequence() throws Exception {

		SequenceFactory factory = new SequenceFactory();
		SequenceType fakeSequence = factory.createSequence(2);

		long startTime = System.currentTimeMillis();

		JsonSerializer serializer = new JsonSerializer();
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

		JsonSerializer serializer = new JsonSerializer();
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

		JsonSerializer serializer = new JsonSerializer();
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

		JsonSerializer serializer = new JsonSerializer();
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

		JsonSerializer serializer = new JsonSerializer();
		String jsonResponse = serializer.serialize(fakeResponse);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/response-ser.json"), jsonResponse, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void serializeCodeList() throws JAXBException, UnsupportedEncodingException, JSONException, JsonSerializationException {
		// Given
		JsonSerializer jsonSerializer = new JsonSerializer();
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
