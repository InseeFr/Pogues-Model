package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JsonDeserializer;
import fr.insee.pogues.exception.JsonDeserializationException;
import fr.insee.pogues.model.Questionnaire;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class JsonDeserializerTest {

	@Test // Note: this test should be replaced by an exception test, see comment in deserializer class.
	void deserializeFromNullInput_resultShouldBeNull() throws JsonDeserializationException {
		assertNull(new JsonDeserializer().deserialize((String) null));
	}

	@Test
	void testQuestionnaire() throws JsonDeserializationException {

		long startTime = System.currentTimeMillis();

		JsonDeserializer deserializer = new JsonDeserializer();
		Questionnaire questionnaire = deserializer.deserialize("src/main/resources/examples/fr.insee-POPO-QPO-DOC.json");

		long elapsedTime = System.currentTimeMillis() - startTime;

		assertEquals("fr.insee-POPO-QPO-DOC",questionnaire.getId());
		System.out.println("Serialization time: " + elapsedTime);
	}

}
