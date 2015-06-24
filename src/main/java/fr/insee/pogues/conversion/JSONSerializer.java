package fr.insee.pogues.conversion;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import fr.insee.pogues.model.CodeList;
import fr.insee.pogues.model.QuestionType;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.ResponseType;
import fr.insee.pogues.model.SequenceType;

public class JSONSerializer {

	public JSONSerializer() { }

	private static final Logger logger = LogManager.getLogger(JSONSerializer.class);

	public String serialize(Questionnaire questionnaire) throws JAXBException, UnsupportedEncodingException {

		if (questionnaire == null) return "";

		logger.debug("Serializing questionnaire " + questionnaire.getId());

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

		// Set it to true if you need to include the JSON root element in the JSON output
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		// Set it to true if you need the JSON output to formatted
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// Marshal the questionnaire object to JSON and put the output in a string

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(questionnaire, baos);
	
		return baos.toString("UTF-8");

	}

	public String serialize(SequenceType sequence) throws JAXBException, UnsupportedEncodingException {

		if (sequence == null) return "";

		logger.debug("Serializing sequence " + sequence.getId());

		JAXBContext context = JAXBContext.newInstance(SequenceType.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

		// Set it to true if you need to include the JSON root element in the JSON output
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		// Set it to true if you need the JSON output to formatted
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// Marshal the sequence object to JSON and put the output in a string

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(sequence, baos);
	
		return baos.toString("UTF-8");
	}

	public String serialize(CodeList codeList) throws JAXBException, UnsupportedEncodingException {

		if (codeList == null) return "";

		logger.debug("Serializing code list " + codeList.getId());

		JAXBContext context = JAXBContext.newInstance(CodeList.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

		// Set it to true if you need to include the JSON root element in the JSON output
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		// Set it to true if you need the JSON output to formatted
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// Marshal the code list object to JSON and put the output in a string

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(codeList, baos);
	
		return baos.toString("UTF-8");
	}

	public String serialize(QuestionType question) throws JAXBException, UnsupportedEncodingException {

		if (question == null) return "";

		logger.debug("Serializing question " + question.getId());

		JAXBContext context = JAXBContext.newInstance(QuestionType.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

		// Set it to true if you need to include the JSON root element in the JSON output
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		// Set it to true if you need the JSON output to formatted
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// Marshal the code list object to JSON and put the output in a string

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(question, baos);
	
		return baos.toString("UTF-8");
	}

	public String serialize(ResponseType response) throws JAXBException, UnsupportedEncodingException {

		if (response == null) return "";

		logger.debug("Serializing a Response object");

		JAXBContext context = JAXBContext.newInstance(ResponseType.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

		// Set it to true if you need to include the JSON root element in the JSON output
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		// Set it to true if you need the JSON output to formatted
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// Marshal the code list object to JSON and put the output in a string

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(response, baos);
	
		return baos.toString("UTF-8");
	}


}
