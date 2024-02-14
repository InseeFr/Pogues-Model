package fr.insee.pogues.conversion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.pogues.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONSerializer {

	public JSONSerializer() { }

	private static final Logger logger = LoggerFactory.getLogger(JSONSerializer.class);

	public String serialize(Questionnaire questionnaire) {
		if (questionnaire == null) return "";

		logger.debug("Serializing questionnaire " + questionnaire.getId());
		try {
			return new ObjectMapper().writeValueAsString(questionnaire);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public String serialize(SequenceType sequence)     {
		if (sequence == null) return "";

		logger.debug("Serializing sequence " + sequence.getId());
		try {
			return new ObjectMapper().writeValueAsString(sequence);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public String serialize(CodeList codeList)     {
		if (codeList == null) return "";

		logger.debug("Serializing code list " + codeList.getId());
		try {
			return new ObjectMapper().writeValueAsString(codeList);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public String serialize(QuestionType question) {
		if (question == null) return "";

		logger.debug("Serializing question " + question.getId());
		try {
			return new ObjectMapper().writeValueAsString(question);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public String serialize(ResponseType response) {
		if (response == null) return "";
		
		logger.debug("Serializing a Response object");
		try {
			return new ObjectMapper().writeValueAsString(response);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
