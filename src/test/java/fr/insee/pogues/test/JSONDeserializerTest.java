package fr.insee.pogues.test;

import fr.insee.pogues.conversion.JSONDeserializer;
import fr.insee.pogues.conversion.JSONSerializer;
import fr.insee.pogues.model.*;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

	@Test
	public void testCodeFilters() throws JAXBException, UnsupportedEncodingException, JSONException {
		String jsonWithCodeFilters = """
				{
				   "Child": [
				     {
				       "type": "QuestionType",
				       "codeFilters": [
				       		{ "codeValue": "01", "conditionFilter": "$AGE$ > 18" },				       		
				       		{ "codeValue": "02", "conditionFilter": "$AGE$ > 30" }
				       	]
				     }
				   ]
				 }
				 """;
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(jsonWithCodeFilters);
		assertEquals(2, ((QuestionType) questionnaire.getChild().get(0)).getCodeFilters().size());
		assertEquals("$AGE$ > 18", ((QuestionType) questionnaire.getChild().get(0)).getCodeFilters().get(0).getConditionFilter());
		assertEquals("$AGE$ > 30", ((QuestionType) questionnaire.getChild().get(0)).getCodeFilters().get(1).getConditionFilter());
	}

	@Test
	public void testMandatoryQuestion() throws JAXBException {
		String json = """
				{
				   "Child": [
				     {
				       "type": "QuestionType",
				       "mandatory": true,
				     }
				   ]
				 }
				 """;
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(json);
		assertTrue(((QuestionType) questionnaire.getChild().getFirst()).isMandatory());
	}

	@Test
	public void testExternalElement() throws JAXBException, UnsupportedEncodingException, JSONException {
		String json = """
				{
				   "Child": [
				     {
				       "type": "SequenceType",
				       "genericName": "EXTERNAL_ELEMENT"
				     }
				   ]
				 }
				 """;
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(json);
		assertEquals(GenericNameEnum.EXTERNAL_ELEMENT, ((SequenceType) questionnaire.getChild().get(0)).getGenericName());
	}

	@Test
	public void testConditionFilterInDatatypeInTableResponse() throws JAXBException, UnsupportedEncodingException, JSONException {
		String json = """
				{
				   "Child": [
				     {
				       "type": "QuestionType",
				       "Response": [ { "conditionFilter": "$PRENOM$ = \\"Laurent\\"" } ]
				     }
				   ]
				 }
				 """;
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(json);
		assertEquals(
				"$PRENOM$ = \"Laurent\"",
				((QuestionType) questionnaire.getChild().get(0))
						.getResponse().getFirst().getConditionFilter());
	}

	@Test
	public void testConditionReadOnlyInDatatypeInTableResponse() throws JAXBException, UnsupportedEncodingException, JSONException {
		String json = """
				{
				   "Child": [
				     {
				       "type": "QuestionType",
				       "Response": [ { "conditionReadOnly": "$PRENOM$ = \\"Remi\\"" } ]
				     }
				   ]
				 }
				 """;
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(json);
		assertEquals(
				"$PRENOM$ = \"Remi\"",
				((QuestionType) questionnaire.getChild().get(0))
						.getResponse().getFirst().getConditionReadOnly());
	}

	@Test
	public void testLoopArrayToSingleLoopInRoundabout() throws JAXBException {
		String json = """
				{
					"Child": [
						{
						  "type": "RoundaboutType",
						  "Loop": [
							{
							  "Name": "RD_POINT_NAME",
							  "MemberReference": ["id1", "id2"],
							  "IterableReference": "TEST",
							  "Filter": "NAME = \\"Laurent\\""
							}
						  ]
						}
					]
				}
				""";
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(json);
		assertEquals(
				"RD_POINT_NAME",
				((RoundaboutType) questionnaire.getChild().getFirst())
						.getLoop().getName());
	}

	@Test
	public void shouldConvertArrayLoopToSingleLoopInJson() throws JAXBException, UnsupportedEncodingException, JSONException {
		String json = """
				{
					"Child": [
						{
						  "type": "RoundaboutType",
						  "Locked": false,
						  "Loop": [
							{
							  "Name": "RD_POINT_NAME",
							  "MemberReference": ["id1", "id2"],
							  "IterableReference": "TEST",
							  "Filter": "NAME = \\"Laurent\\""
							}
						  ]
						}
					]
				}
				""";

		String expectedJson = """
				{
					"Child": [
						{
						  "type": "RoundaboutType",
						  "Locked": false,
						  "Loop": {
							  "Name": "RD_POINT_NAME",
							  "MemberReference": ["id1", "id2"],
							  "IterableReference": "TEST",
							  "Filter": "NAME = \\"Laurent\\""
							}
						}
					]
				}
				""";
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(json);
		JSONSerializer serializer = new JSONSerializer(true);
		String result = serializer.serialize(questionnaire);
		JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
	}

	@Test
	public void serializeMinMaxVTLInDimensionTable() throws JAXBException {
		String json = """
				{
				    "Child": [
				      {
				        "type": "QuestionType",
				        "ResponseStructure": {
				          "Dimension": [
				            {
				              "minimum": "count($PRENOM$)",
				              "maximum": "count($PRENOM$) + 10"
				            }
				          ]
				        }
				      }
				    ]
				  }
				  """;
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire questionnaire = deserializer.deserializeString(json);
		assertEquals(
				"count($PRENOM$)",
				((QuestionType) questionnaire.getChild().getFirst())
						.getResponseStructure().getDimension().getFirst()
						.getMinimum().getValue());
		assertEquals(
				"count($PRENOM$) + 10",
				((QuestionType) questionnaire.getChild().getFirst())
						.getResponseStructure().getDimension().getFirst()
						.getMaximum().getValue());
	}

	@Test
	public void shouldHandleMinMaxDynamicIteration_notCaseSensitive() throws JAXBException {
		String oldJson = """
				{
				  "Iterations": {
				  	"Iteration": [
				  		{
				  			"type": "DynamicIterationType",
				  			"Minimum": "1",
				  			"Maximum": "5"
				  		}
				  	]
				  }
				}
				""";

		String newJson = """
				{
				  "Iterations": {
				  	"Iteration": [
				  		{
				  			"type": "DynamicIterationType",
				  			"minimum": "1",
				  			"maximum": "5",
				  			"shouldSplitIterations": true
				  		}
				  	]
				  }
				}
				""";
		JSONDeserializer deserializer = new JSONDeserializer();
		Questionnaire oldQuestionnaire = deserializer.deserializeString(oldJson);
		assertEquals(
				"1",
				((DynamicIterationType) oldQuestionnaire.getIterations().getIteration().getFirst())
						.getDeprecatedMinimum().getValue());
		assertEquals(
				"5",
				((DynamicIterationType) oldQuestionnaire.getIterations().getIteration().getFirst())
						.getDeprecatedMaximum().getValue());


		Questionnaire newQuestionnaire = deserializer.deserializeString(newJson);
		assertEquals(
				"1",
				((DynamicIterationType) newQuestionnaire.getIterations().getIteration().getFirst())
						.getMinimum().getValue());
		assertEquals(
				"5",
				((DynamicIterationType) newQuestionnaire.getIterations().getIteration().getFirst())
						.getMaximum().getValue());
		assertTrue(
				((DynamicIterationType) newQuestionnaire.getIterations().getIteration().getFirst())
						.isShouldSplitIterations());
	}
}
