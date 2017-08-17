package fr.insee.pogues.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.insee.pogues.conversion.JSONDeserializer;
import fr.insee.pogues.model.Questionnaire;

public class JSONDeserializerTest {

	@Test
	public void testQuestionnaire() throws Exception {

		long startTime = System.currentTimeMillis();

		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserialize("src/main/resources/examples/fr.insee-POPO-QPO-DOC.json");

		long elapsedTime = System.currentTimeMillis() - startTime;

		assertEquals("fr.insee-POPO-QPO-DOC",questionnaire.getId());
		System.out.println("Serialization time: " + elapsedTime);
	}

}
