package fr.insee.pogues.conversion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.pogues.exception.JsonDeserializationException;
import fr.insee.pogues.model.Questionnaire;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class JsonDeserializer {

	private final ObjectMapper objectMapper;

	public JsonDeserializer() {
		objectMapper = new ObjectMapper();
	}

	public Questionnaire deserialize(String fileName) throws JsonDeserializationException {

		if (fileName == null || fileName.isEmpty()) {
			// TODO: throwing an exception instead of silent failing would be better here
			// (sonar complains about the return null breakpoint...)
			// Note: might be a breaking change
			log.warn("null or empty file path given!");
			return null;
		}

		log.debug("Deserializing questionnaire from file {}", fileName);

		String jsonContent;
		try {
			jsonContent = Files.readString(Path.of(fileName));
		} catch (IOException e) {
			// Return null to preserve existing pattern, should be replaced by an exception
			log.warn("null or empty file path given!");
			return null;
		}

		Questionnaire questionnaire;
		try {
			questionnaire = objectMapper.readValue(jsonContent, Questionnaire.class);
		} catch (JsonProcessingException e) {
			throw new JsonDeserializationException("Unable to deserialize questionnaire from file: " + fileName, e);
		}

		if (questionnaire == null)
			throw new JsonDeserializationException("Deserialized questionnaire is null.");
		if (questionnaire.getId() == null)
			log.warn("Identifier of the deserialized questionnaire is null.");

		log.debug("Questionnaire {} successfully deserialized.", questionnaire.getId());
		return questionnaire;
	}

	/**
	 * Deserializes given json questionnaire input stream.
	 * @param jsonQuestionnaireInputStream Input stream of a Pogues json questionnaire.
	 * @return A questionnaire object.
	 */
	public Questionnaire deserialize(InputStream jsonQuestionnaireInputStream) throws JsonDeserializationException {

		Questionnaire questionnaire;
		try {
			questionnaire = objectMapper.readValue(jsonQuestionnaireInputStream, Questionnaire.class);
		} catch (IOException e) {
			throw new JsonDeserializationException(
					"Unable to deserialize json questionnaire from input stream given.", e);
		}

		if (questionnaire == null)
			throw new JsonDeserializationException("Deserialized questionnaire is null.");
		if (questionnaire.getId() == null)
			log.warn("Identifier of the deserialized questionnaire is null.");

		log.debug("Questionnaire {} successfully deserialized.", questionnaire.getId());
		return questionnaire;
	}

}
