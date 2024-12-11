package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JSONDeserializer;
import fr.insee.pogues.model.Questionnaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class JSONDeserializerTest {


	private String jsonLastUpdatedDate;
	private String jsonChildQuestionnaireRef;
	private String jsonOwner;

	@BeforeEach
	void setup() {
		jsonLastUpdatedDate = """
                {
                  "id": "questionnaire-id",
                  "lastUpdatedDate": "Tue Dec 10 2024 10:33:38 GMT+0100 (heure normale d’Europe centrale)"
                }
                """;
		jsonChildQuestionnaireRef = """
                {
                  "id": "questionnaire-id",
                  "childQuestionnaireRef": [ "ref-id-1", "ref-id-2" ]
                }
                """;
		jsonOwner = """
                {
                  "id": "questionnaire-id",
                  "owner": "NiceOwner"
                }
                """;
	}

	@Test // Note: this test should be replaced by an exception test, see comment in deserializer class.
	void deserializeFileFromNullInput_resultShouldBeNull() throws JAXBException, IOException {
		String nullFileName = null;
		assertNull(new JSONDeserializer().deserialize(nullFileName));
	}

	@Test
	void testQuestionnaire() throws Exception {

		long startTime = System.currentTimeMillis();

		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserialize("src/main/resources/examples/fr.insee-POPO-QPO-DOC.json");

		long elapsedTime = System.currentTimeMillis() - startTime;

		assertEquals("fr.insee-POPO-QPO-DOC",questionnaire.getId());
		System.out.println("Serialization time: " + elapsedTime);
		assertNotNull(questionnaire);
	}

	@Test
	void testLastUpdatedDate() throws Exception {
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(jsonLastUpdatedDate);
		assertEquals("Tue Dec 10 2024 10:33:38 GMT+0100 (heure normale d’Europe centrale)", questionnaire.getLastUpdatedDate());
	}

	@Test
	void testChildQuestionnaireRef() throws Exception {
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(jsonChildQuestionnaireRef);
		assertEquals(Arrays.asList("ref-id-1", "ref-id-2"), questionnaire.getChildQuestionnaireRef());
	}

	@Test
	void testOwner() throws Exception {
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(jsonOwner);
		assertEquals("NiceOwner", questionnaire.getOwner());
	}

}
