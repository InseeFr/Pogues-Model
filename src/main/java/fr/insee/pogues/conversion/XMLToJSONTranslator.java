package fr.insee.pogues.conversion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import fr.insee.pogues.model.Questionnaire;

public class XMLToJSONTranslator {

	public XMLToJSONTranslator() {}

	private static final Logger logger = LogManager.getLogger(XMLToJSONTranslator.class);

	public String translate(File xmlFile) throws JAXBException, UnsupportedEncodingException {

		if (xmlFile == null) return null;
		StreamSource xml = new StreamSource(xmlFile);
	
		return this.translate(xml);
	}

	public String translate(String xmlString) throws JAXBException, UnsupportedEncodingException {

		if ((xmlString == null) || (xmlString.length() == 0)) return null;
		StreamSource xml = new StreamSource(new StringReader(xmlString));

		return this.translate(xml);
	}

	public String translate(StreamSource xmlStream) throws JAXBException, UnsupportedEncodingException {

		if (xmlStream == null) return null;

		logger.debug("Preparing to translate from XML to JSON");

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		Questionnaire questionnaire = (Questionnaire) unmarshaller.unmarshal(xmlStream);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(questionnaire, baos);

		logger.debug("Translation complete");

		return baos.toString("UTF-8");
	}
}
