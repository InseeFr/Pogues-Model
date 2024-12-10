package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JSONToXMLTranslator;
import fr.insee.pogues.conversion.XMLToJSONTranslator;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

class TranslatorsTest {

	@Test
	void testQuestionnaireJSONToXML() throws Exception {

		long startTime = System.currentTimeMillis();

		JSONToXMLTranslator translator = new JSONToXMLTranslator(true);
		String xmlQuestionnaire = translator
				.translate(new File("src/main/resources/examples/fr.insee-POPO-QPO-DOC.json"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/fr.insee-POPO-QPO-DOC-out.xml"), xmlQuestionnaire,
				"UTF-8");
		System.out.println("Conversion time: " + elapsedTime);
	}

	@Test
	void testQuestionnaireXMLToJSON() throws Exception {

		long startTime = System.currentTimeMillis();

		XMLToJSONTranslator translator = new XMLToJSONTranslator();
		String jsonQuestionnaire = translator
				.translate(new File("src/main/resources/examples/fr.insee-POPO-QPO-DOC.xml"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/fr.insee-POPO-QPO-DOC-out.json"), jsonQuestionnaire,
				"UTF-8");
		System.out.println("Conversion time: " + elapsedTime);
	}

	@Test
	void testSequenceJSONToXML() throws Exception {

		long startTime = System.currentTimeMillis();

		JSONToXMLTranslator translator = new JSONToXMLTranslator(true);
		String xmlSequence = translator
				.translateSequence(new File("src/main/resources/examples/fr.insee-POPO-QPO-DOC-seq.json"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/fr.insee-POPO-QPO-DOC-seq-out.xml"), xmlSequence,
				"UTF-8");

		System.out.println("Conversion time: " + elapsedTime);
	}

	@Test
	void testSequenceXMLToJSON() throws Exception {

		long startTime = System.currentTimeMillis();

		XMLToJSONTranslator translator = new XMLToJSONTranslator();

		String jsonQuestionnaire = translator
				.translateSequence(new File("src/main/resources/examples/fr.insee-POPO-QPO-DOC-seq.xml"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/fr.insee-POPO-QPO-DOC-seq-out.json"),
				jsonQuestionnaire, "UTF-8");

		System.out.println("Conversion time: " + elapsedTime);
	}
	
	
	@Test
	void testQuestionJSONToXML() throws Exception {

		long startTime = System.currentTimeMillis();

		JSONToXMLTranslator translator = new JSONToXMLTranslator(true);
		String xmlQuestion = translator
				.translateQuestion(new File("src/main/resources/examples/fr.insee-POPO-QPO-DOC-question.json"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/fr.insee-POPO-QPO-DOC-question-out.xml"),
				xmlQuestion, "UTF-8");
		System.out.println("Conversion time: " + elapsedTime);
	}

	@Test
	void testQuestionXMLToJSON() throws Exception {

		long startTime = System.currentTimeMillis();

		XMLToJSONTranslator translator = new XMLToJSONTranslator();
		String jsonQuestion = translator
				.translateQuestion(new File("src/main/resources/examples/fr.insee-POPO-QPO-DOC-question.xml"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/fr.insee-POPO-QPO-DOC-question-out.json"),
				jsonQuestion, "UTF-8");
		System.out.println("Conversion time: " + elapsedTime);
	}

	@Test
	void testCodeListsJSONToXML() throws Exception {

		long startTime = System.currentTimeMillis();

		JSONToXMLTranslator translator = new JSONToXMLTranslator(true);
		String xmlCodeLists = translator
				.translateCodeLists(new File("src/main/resources/examples/fr.insee-POPO-QPO-DOC-codelists.json"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/fr.insee-POPO-QPO-DOC-codelists-out.xml"),
				xmlCodeLists, "UTF-8");
		System.out.println("Conversion time: " + elapsedTime);
	}

	@Test
	void testCodeListsXMLToJSON() throws Exception {

		long startTime = System.currentTimeMillis();

		XMLToJSONTranslator translator = new XMLToJSONTranslator();
		String jsonQuestionnaire = translator
				.translateCodeLists(new File("src/main/resources/examples/fr.insee-POPO-QPO-DOC-codelists.xml"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/fr.insee-POPO-QPO-DOC-codelists-out.json"),
				jsonQuestionnaire, "UTF-8");
		System.out.println("Conversion time: " + elapsedTime);
	}

}
