package fr.insee.pogues.model;

import fr.insee.pogues.conversion.JSONDeserializer;
import fr.insee.pogues.conversion.JSONSerializer;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import javax.xml.bind.JAXBException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class UniqueChoiceVariableOptionsTest {

    @Test
    void serializeUcqVariable_withFilter() throws JAXBException, UnsupportedEncodingException, JSONException {
        // Given
        QuestionType question = new QuestionType();
        question.setQuestionType(QuestionTypeEnum.SINGLE_CHOICE);
        question.setOptionFilter("nvl($AGE$, 0) > 18");

        ResponseType response = new ResponseType();
        response.setVariableReference("id-loop-variable");
        response.setChoiceType(ChoiceTypeEnum.VARIABLE);

        question.getResponse().add(response);

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.getChild().add(question);

        // When
        String json = new JSONSerializer(true).serialize(questionnaire);

        // Then
        String expectedJson = """
        {
          "Child": [
            {
              "type": "QuestionType",
              "questionType": "SINGLE_CHOICE",
              "OptionFilter": "nvl($AGE$, 0) > 18",
              "Response": [
                {
                  "VariableReference": "id-loop-variable",
                  "choiceType": "VARIABLE"
                }
              ]
            }
          ]
        }
        """;
        JSONAssert.assertEquals(expectedJson, json, JSONCompareMode.STRICT);
    }

    private final JSONDeserializer jsonDeserializer = new JSONDeserializer();

    @Test
    void testChoiceTypeVariableResponses() throws JAXBException {
        String json = """
                {
                   "Child": [
                     {
                       "type": "QuestionType",
                       "Response": [
                           {
                                "choiceType": "VARIABLE"
                           }
                       ]
                     }
                   ]
                 }
                """;
        JSONDeserializer deserializer = new JSONDeserializer();
        Questionnaire questionnaire = deserializer.deserializeString(json);
        assertEquals(ChoiceTypeEnum.VARIABLE, ((QuestionType) questionnaire.getChild().getFirst()).getResponse().getFirst().getChoiceType());
    }

    @Test
    void deserializeUcqVariable() throws JAXBException {
        String json = """
            {
               "Child": [
                 {
                   "type": "QuestionType",
                   "questionType": "SINGLE_CHOICE",
                   "Response": {
                       "choiceType": "VARIABLE",
                       "VariableReference": "id-loop-variable"
                   }
                 }
               ]
             }
            """;

        JSONDeserializer deserializer = new JSONDeserializer();
        Questionnaire questionnaire = deserializer.deserializeString(json);

        QuestionType question = (QuestionType) questionnaire.getChild().getFirst();
        assertEquals(QuestionTypeEnum.SINGLE_CHOICE, question.getQuestionType());
        assertEquals(ChoiceTypeEnum.VARIABLE, question.getResponse().getFirst().getChoiceType());
        assertNull(question.getOptionFilter());
        assertNotNull(question.getResponse());
        assertFalse(question.getResponse().isEmpty()) ;
        assertEquals("id-loop-variable", question.getResponse().getFirst().getVariableReference());
    }

    @Test
    void deserializeUcqVariable_withFilter() throws JAXBException {
        String json = """
            {
               "Child": [
                 {
                   "type": "QuestionType",
                   "questionType": "SINGLE_CHOICE",
                   "OptionFilter": "nvl($AGE$, 0) > 18",
                   "Response": {
                       "choiceType": "VARIABLE",
                       "VariableReference": "id-loop-variable"
                   }
                 }
               ]
             }
            """;

        JSONDeserializer deserializer = new JSONDeserializer();
        Questionnaire questionnaire = deserializer.deserializeString(json);

        QuestionType question = (QuestionType) questionnaire.getChild().getFirst();
        assertEquals(QuestionTypeEnum.SINGLE_CHOICE, question.getQuestionType());
        assertEquals(ChoiceTypeEnum.VARIABLE, question.getResponse().getFirst().getChoiceType());
        assertEquals("nvl($AGE$, 0) > 18", question.getOptionFilter());
        assertNotNull(question.getResponse());
        assertFalse(question.getResponse().isEmpty()) ;
        assertEquals("id-loop-variable", question.getResponse().getFirst().getVariableReference());
    }

    /** The response object is the same for choice responses and other types of responses (text, numeric, date etc.).
     * So the 'choiceType' property must be null is absent. */
    @Test
    void responseWithoutChoiceType() throws JAXBException {
        String json = """
            {
               "Child": [
                 {
                   "type": "QuestionType",
                   "Response": {}
                 }
               ]
             }
            """;
        Questionnaire questionnaire = jsonDeserializer.deserializeString(json);
        QuestionType question = (QuestionType) questionnaire.getChild().getFirst();
        assertNull(question.getResponse().getFirst().getChoiceType());
    }

}
