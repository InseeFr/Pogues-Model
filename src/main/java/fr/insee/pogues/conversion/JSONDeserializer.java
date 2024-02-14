package fr.insee.pogues.conversion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.pogues.exception.PoguesDeserializationException;
import fr.insee.pogues.model.Questionnaire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class JSONDeserializer {

	private static final Logger logger = LoggerFactory.getLogger(JSONDeserializer.class);

	public Questionnaire deserialize(String fileName) {

		if (fileName == null || fileName.isEmpty()) {
			// TODO: throwing an exception instead of silent failing would be better here
			// (sonar complains about the return null breakpoint...)
			// Note: might be a breaking change
			logger.warn("null or empty file path given!");
			return null;
		}

		logger.debug("Deserializing questionnaire from file {}", fileName);

		String jsonContent;
		try {
			jsonContent = Files.readString(Path.of(fileName));
		} catch (IOException e) {
			// Return null to preserve existing pattern, should be replaced by an exception
			logger.warn("null or empty file path given!");
			return null;
		}

		ObjectMapper objectMapper = new ObjectMapper();
		Questionnaire questionnaire;
		try {
			questionnaire = objectMapper.readValue(jsonContent, Questionnaire.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e); // TODO
		}

		if (questionnaire == null)
			throw new PoguesDeserializationException("Deserialized questionnaire is null.");
		if (questionnaire.getId() == null)
			logger.warn("Identifier of the deserialized questionnaire is null.");

		logger.debug("Questionnaire {} successfully deserialized.", questionnaire.getId());
		return questionnaire;
	}

	/**
	 * Deserializes given json questionnaire input stream.
	 * @param jsonQuestionnaireInputStream Input stream of a Pogues json questionnaire.
	 * @return A questionnaire object.
	 */
	public Questionnaire deserialize(InputStream jsonQuestionnaireInputStream) {
		ObjectMapper objectMapper = new ObjectMapper();
		Questionnaire questionnaire;
		try {
			questionnaire = objectMapper.readValue(jsonQuestionnaireInputStream, Questionnaire.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		if (questionnaire == null)
			throw new PoguesDeserializationException("Deserialized questionnaire is null.");
		if (questionnaire.getId() == null)
			logger.warn("Identifier of the deserialized questionnaire is null.");

		logger.debug("Questionnaire {} successfully deserialized.", questionnaire.getId());
		return questionnaire;
	}

}
