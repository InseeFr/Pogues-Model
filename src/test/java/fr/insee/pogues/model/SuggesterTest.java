package fr.insee.pogues.model;

import fr.insee.pogues.conversion.JSONDeserializer;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggesterTest {

    @Test
    void deserializeSuggesterChoiceType() throws JAXBException {
        String json = """
            {
               "Child": [
                 {
                   "type": "QuestionType",
                   "Response": [
                        {
                            "choiceType": "SUGGESTER"
                        }
                   ]
                 }
               ]
             }
            """;
        Questionnaire questionnaire = new JSONDeserializer().deserializeString(json);
        QuestionType question = (QuestionType) questionnaire.getChild().getFirst();
        assertEquals(ChoiceTypeEnum.SUGGESTER, question.getResponse().getFirst().getChoiceType());
    }

}
