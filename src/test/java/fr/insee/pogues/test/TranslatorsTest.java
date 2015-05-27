package fr.insee.pogues.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.insee.pogues.conversion.JSONToXMLTranslator;
import fr.insee.pogues.conversion.XMLToJSONTranslator;

public class TranslatorsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testQuestionnaireJSONToXML() throws Exception {

		long startTime = System.currentTimeMillis();

		JSONToXMLTranslator translator = new JSONToXMLTranslator();
		String xmlQuestionnaire = translator.translate(new File("src/test/resources/questionnaire.json"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/questionnaire.xml"), xmlQuestionnaire, "UTF-8");
		System.out.println("Conversion time: " + elapsedTime);
	}

	@Test
	public void testQuestionnaireXMLToJSON() throws Exception {

		long startTime = System.currentTimeMillis();

		XMLToJSONTranslator translator = new XMLToJSONTranslator();
		String jsonQuestionnaire = translator.translate(new File("src/test/resources/questionnaire.xml"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/questionnaire-loop.json"), jsonQuestionnaire, "UTF-8");
		System.out.println("Conversion time: " + elapsedTime);
	}

}
