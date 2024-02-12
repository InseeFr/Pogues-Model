package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JSONSerializer;
import fr.insee.pogues.mock.*;
import fr.insee.pogues.model.*;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

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

}
