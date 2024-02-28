package fr.insee.pogues.conversion;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import fr.insee.pogues.exception.XmlDeserializationException;
import fr.insee.pogues.model.Questionnaire;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class XmlDeserializer {

    public final XmlMapper xmlMapper;

    public XmlDeserializer() {
        xmlMapper = new XmlMapper();
    }

    /**
     * Deserializes given xml questionnaire input stream.
     * @param xmlQuestionnaireInputStream Input stream of a Pogues xml questionnaire.
     * @return A questionnaire object.
     */
    public Questionnaire deserialize(InputStream xmlQuestionnaireInputStream) throws XmlDeserializationException {

        Questionnaire questionnaire;
        try {
            questionnaire = xmlMapper.readValue(xmlQuestionnaireInputStream, Questionnaire.class);
        } catch (IOException e) {
            throw new XmlDeserializationException(
                    "Unable to deserialize xml questionnaire from input stream given.", e);
        }

        if (questionnaire == null)
            throw new XmlDeserializationException("Deserialized questionnaire is null.");
        if (questionnaire.getId() == null)
            log.warn("Identifier of the deserialized questionnaire is null.");

        log.debug("Questionnaire {} successfully deserialized.", questionnaire.getId());
        return questionnaire;
    }


}
