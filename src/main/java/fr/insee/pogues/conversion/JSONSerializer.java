package fr.insee.pogues.conversion;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;

import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.SequenceType;

public class JSONSerializer {

	public JSONSerializer() {

	}

	public String serialize(Questionnaire questionnaire) throws JAXBException, UnsupportedEncodingException {

		if (questionnaire == null) return "";

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

		// Set it to true if you need to include the JSON root element in the JSON output
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		// Set it to true if you need the JSON output to formatted
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// Marshal the employee object to JSON and print the output to console

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(questionnaire, baos);
	
		return baos.toString("UTF-8");

	}

	public String serialize(SequenceType sequence) throws JAXBException, UnsupportedEncodingException {

		if (sequence == null) return "";

		JAXBContext context = JAXBContext.newInstance(SequenceType.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

		// Set it to true if you need to include the JSON root element in the JSON output
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		// Set it to true if you need the JSON output to formatted
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// Marshal the employee object to JSON and print the output to console

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(sequence, baos);
	
		return baos.toString("UTF-8");

	}

}
