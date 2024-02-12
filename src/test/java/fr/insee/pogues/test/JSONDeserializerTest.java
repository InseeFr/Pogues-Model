package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JSONDeserializer;
import fr.insee.pogues.model.Questionnaire;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JSONDeserializerTest {

	@Test
	void testQuestionnaire() throws Exception {

		long startTime = System.currentTimeMillis();

		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserialize("src/main/resources/examples/fr.insee-POPO-QPO-DOC.json");

		long elapsedTime = System.currentTimeMillis() - startTime;

		assertEquals("fr.insee-POPO-QPO-DOC",questionnaire.getId());
		System.out.println("Serialization time: " + elapsedTime);
	}

}
