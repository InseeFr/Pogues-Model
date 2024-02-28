package fr.insee.pogues.conversion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.pogues.exception.JsonSerializationException;
import fr.insee.pogues.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonSerializer {
	
	private final ObjectMapper objectMapper;

	public JsonSerializer() {
		this.objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
	}

	private static final Logger logger = LoggerFactory.getLogger(JsonSerializer.class);

	public String serialize(Questionnaire questionnaire) throws JsonSerializationException {
		if (questionnaire == null) return "";

		logger.debug("Serializing questionnaire {}", questionnaire.getId());
		try {
			return objectMapper.writeValueAsString(questionnaire);
		} catch (JsonProcessingException e) {
			throw new JsonSerializationException("Unable to serialize given questionnaire.", e);
		}
	}

	public String serialize(SequenceType sequence) throws JsonSerializationException {
		if (sequence == null) return "";

		logger.debug("Serializing sequence {}", sequence.getId());
		try {
			return objectMapper.writeValueAsString(sequence);
		} catch (JsonProcessingException e) {
			throw new JsonSerializationException("Unable to serialize given sequence.", e);
		}
	}

	public String serialize(CodeList codeList) throws JsonSerializationException {
		if (codeList == null) return "";

		logger.debug("Serializing code list {}", codeList.getId());
		try {
			return objectMapper.writeValueAsString(codeList);
		} catch (JsonProcessingException e) {
			throw new JsonSerializationException("Unable to serialize given code list.", e);
		}
	}

	public String serialize(QuestionType question) throws JsonSerializationException {
		if (question == null) return "";

		logger.debug("Serializing question {}", question.getId());
		try {
			return objectMapper.writeValueAsString(question);
		} catch (JsonProcessingException e) {
			throw new JsonSerializationException("Unable to serialize given question.", e);
		}
	}

	public String serialize(ResponseType response) throws JsonSerializationException {
		if (response == null) return "";
		
		logger.debug("Serializing a Response object");
		try {
			return objectMapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			throw new JsonSerializationException("Unable to serialize given response object.", e);
		}
	}

}
