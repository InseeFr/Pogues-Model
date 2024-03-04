package fr.insee.pogues.test.questionnaire;

import fr.insee.pogues.conversion.XmlSerializer;
import fr.insee.pogues.exception.XmlSerializationException;
import fr.insee.pogues.model.Questionnaire;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionnaireSerializationTest {

    @Test
    void xmlFinalProperty() throws XmlSerializationException {
        // @JacksonXmlProperty(isAttribute = true)
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setFinalOrNot(true);
        //
        String xmlResult = new XmlSerializer().serialize(questionnaire);
        //
        assertEquals("<Questionnaire " +
                "type=\"Questionnaire\" " +
                "final=\"true\" " +
                "xmlns=\"http://xml.insee.fr/schema/applis/pogues\"/>",
                xmlResult);
    }

}
