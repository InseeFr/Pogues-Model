package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JsonToXmlConverter;
import fr.insee.pogues.conversion.XmlToJsonConverter;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

class TranslatorsTest {

	@Test
	void testQuestionnaireJsonToXml() throws Exception {

		long startTime = System.currentTimeMillis();

		JsonToXmlConverter translator = new JsonToXmlConverter();
		String xmlQuestionnaire = translator
				.convertQuestionnaire(new File("src/main/resources/examples/fr.insee-POPO-QPO-DOC.json"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/fr.insee-POPO-QPO-DOC-out.xml"), xmlQuestionnaire,
				"UTF-8");
		System.out.println("Conversion time: " + elapsedTime);
	}

	@Test
	void testQuestionnaireXmlToJson() throws Exception {

		long startTime = System.currentTimeMillis();

		XmlToJsonConverter translator = new XmlToJsonConverter();
		String jsonQuestionnaire = translator
				.convertQuestionnaire(new File("src/main/resources/examples/fr.insee-POPO-QPO-DOC.xml"));

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/fr.insee-POPO-QPO-DOC-out.json"), jsonQuestionnaire,
				"UTF-8");
		System.out.println("Conversion time: " + elapsedTime);
	}

}
