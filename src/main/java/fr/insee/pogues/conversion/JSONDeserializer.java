package fr.insee.pogues.conversion;

import fr.insee.pogues.exception.PoguesDeserializationException;
import fr.insee.pogues.model.Questionnaire;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.StringReader;

public class JSONDeserializer {

	private static final Logger logger = LoggerFactory.getLogger(JSONDeserializer.class);

	public Questionnaire deserialize(String fileName) throws JAXBException {

		if (fileName == null || fileName.isEmpty()) {
			// TODO: throwing an exception instead of silent failing would be better here
			// (sonar complains about the return null breakpoint...)
			// Note: might be a breaking change
			logger.warn("null or empty file path given!");
			return null;
		}

		logger.debug("Deserializing questionnaire from file {}", fileName);
		StreamSource json = new StreamSource(fileName);
		return deserializeStreamSource(json);
	}

	/**
	 * Deserializes given json questionnaire input stream.
	 * @param jsonQuestionnaireInputStream Input stream of a Pogues json questionnaire.
	 * @return A questionnaire object.
	 * @throws JAXBException if deserialization fails.
	 */
	public Questionnaire deserialize(InputStream jsonQuestionnaireInputStream) throws JAXBException {
		logger.debug("Deserializing json questionnaire from input stream.");
		StreamSource json = new StreamSource(jsonQuestionnaireInputStream);
		return deserializeStreamSource(json);
	}

	private static Questionnaire deserializeStreamSource(StreamSource json) throws JAXBException {

		String preProcessedString = new JSONSynonymsPreProcessor().transform(json);
		StreamSource preProcessedStream = new StreamSource(new StringReader(preProcessedString));

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);

		Questionnaire questionnaire = unmarshaller.unmarshal(preProcessedStream, Questionnaire.class).getValue();

		if (questionnaire == null)
			throw new PoguesDeserializationException("Deserialized questionnaire is null.");
		if (questionnaire.getId() == null)
			logger.warn("Identifier of the deserialized questionnaire is null.");

		logger.debug("Questionnaire {} successfully deserialized.", questionnaire.getId());

		return questionnaire;
	}

}
