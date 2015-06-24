package fr.insee.pogues.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.insee.pogues.conversion.JSONSerializer;
import fr.insee.pogues.mock.CodeListFactory;
import fr.insee.pogues.mock.QuestionFactory;
import fr.insee.pogues.mock.QuestionnaireFactory;
import fr.insee.pogues.mock.ResponseFactory;
import fr.insee.pogues.mock.SequenceFactory;
import fr.insee.pogues.model.CodeList;
import fr.insee.pogues.model.QuestionType;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.ResponseType;
import fr.insee.pogues.model.SequenceType;

public class JSONSerializerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testQuestionnaire() throws Exception {

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
	public void testSequence() throws Exception {

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
	public void testCodeList() throws Exception {

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
	public void testQuestion() throws Exception {

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
	public void testQuestionOnly() throws Exception {

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
	public void testResponse() throws Exception {

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
