package fr.insee.pogues.test;

import fr.insee.pogues.conversion.XMLSerializer;
import fr.insee.pogues.mock.CodeListFactory;
import fr.insee.pogues.mock.QuestionnaireFactory;
import fr.insee.pogues.mock.SequenceFactory;
import fr.insee.pogues.model.CodeList;
import fr.insee.pogues.model.CodeLists;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.SequenceType;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

class XMLSerializerTest {

	@Test
	void testQuestionnaire() throws Exception {

		QuestionnaireFactory factory = new QuestionnaireFactory();
		Questionnaire fakeQuestionnaire = factory.createQuestionnaire();

		long startTime = System.currentTimeMillis();

		XMLSerializer serializer = new XMLSerializer();
		String xmlQuestionnaire = serializer.serialize(fakeQuestionnaire);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/questionnaire-ser.xml"), xmlQuestionnaire, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testSequence() throws Exception {

		SequenceFactory factory = new SequenceFactory();
		SequenceType fakeSequence = factory.createSequence(2);

		long startTime = System.currentTimeMillis();

		XMLSerializer serializer = new XMLSerializer();
		String xmlSequence = serializer.serialize(fakeSequence);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/sequence-ser.xml"), xmlSequence, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testCodeList() throws Exception {

		CodeListFactory factory = new CodeListFactory();
		CodeList fakeCodeList = factory.createCodeList();

		long startTime = System.currentTimeMillis();

		XMLSerializer serializer = new XMLSerializer();
		String xmlCodeList = serializer.serialize(fakeCodeList);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/codelist-ser.xml"), xmlCodeList, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testCodeLists() throws Exception {

		CodeListFactory factory = new CodeListFactory();
		CodeLists fakeCodeLists = factory.createCodeLists();

		long startTime = System.currentTimeMillis();

		XMLSerializer serializer = new XMLSerializer();
		String xmlCodeLists = serializer.serialize(fakeCodeLists);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/codelists-ser.xml"), xmlCodeLists, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}
}
