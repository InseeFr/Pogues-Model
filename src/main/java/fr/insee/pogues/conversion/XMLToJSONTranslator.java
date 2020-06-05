package fr.insee.pogues.conversion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import fr.insee.pogues.model.CodeLists;
import fr.insee.pogues.model.QuestionType;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.SequenceType;

public class XMLToJSONTranslator {

	private boolean monitored;

	public XMLToJSONTranslator() {
		this(false);
	}

	public XMLToJSONTranslator(boolean monitored) {
		this.monitored = monitored;
	}

	private static final Logger logger = LoggerFactory.getLogger(XMLToJSONTranslator.class);

	public String translate(File xmlFile) throws JAXBException, UnsupportedEncodingException {

		if (xmlFile == null)
			return null;
		StreamSource xml = new StreamSource(xmlFile);

		return this.translate(xml);
	}

	public String translate(String xmlString) throws JAXBException, UnsupportedEncodingException {

		if ((xmlString == null) || (xmlString.length() == 0))
			return null;
		StreamSource xml = new StreamSource(new StringReader(xmlString));

		return this.translate(xml);
	}

	public String translate(StreamSource xmlStream) throws JAXBException, UnsupportedEncodingException {

		if (xmlStream == null)
			return null;

		logger.debug("Preparing to translate from XML to JSON");

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		Questionnaire questionnaire = (Questionnaire) unmarshaller.unmarshal(xmlStream);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(questionnaire, baos);

		logger.debug("Translation complete");

		return baos.toString("UTF-8");
	}

	public String translateSequence(File xmlFile) throws JAXBException, UnsupportedEncodingException {

		if (xmlFile == null)
			return null;
		StreamSource xml = new StreamSource(xmlFile);

		return this.translateSequence(xml);
	}

	public String translateSequence(String xmlString) throws JAXBException, UnsupportedEncodingException {

		if ((xmlString == null) || (xmlString.length() == 0))
			return null;
		StreamSource xml = new StreamSource(new StringReader(xmlString));

		return this.translateSequence(xml);
	}

	public String translateSequence(StreamSource xmlStream) throws JAXBException, UnsupportedEncodingException {

		if (xmlStream == null)
			return null;

		logger.debug("Preparing to translate from XML to JSON");

		JAXBContext context = JAXBContext.newInstance(SequenceType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		JAXBElement<SequenceType> jeSequence = (JAXBElement<SequenceType>) unmarshaller.unmarshal(xmlStream);
		SequenceType sequence = jeSequence.getValue();

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(sequence, baos);

		logger.debug("Translation complete");

		return baos.toString("UTF-8");
	}

	public String translateQuestion(File xmlFile) throws JAXBException, UnsupportedEncodingException {

		if (xmlFile == null)
			return null;
		StreamSource xml = new StreamSource(xmlFile);

		return this.translateQuestion(xml);
	}

	public String translateQuestion(String xmlString) throws JAXBException, UnsupportedEncodingException {

		if ((xmlString == null) || (xmlString.length() == 0))
			return null;
		StreamSource xml = new StreamSource(new StringReader(xmlString));

		return this.translateQuestion(xml);
	}

	public String translateQuestion(StreamSource xmlStream) throws JAXBException, UnsupportedEncodingException {

		if (xmlStream == null)
			return null;

		logger.debug("Preparing to translate from XML to JSON");

		JAXBContext context = JAXBContext.newInstance(QuestionType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		JAXBElement<QuestionType> jeQuestion = (JAXBElement<QuestionType>) unmarshaller.unmarshal(xmlStream);
        QuestionType question = jeQuestion.getValue();

        Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(question, baos);

		logger.debug("Translation complete");

		return baos.toString("UTF-8");
	}

	public String translateCodeLists(File xmlFile) throws JAXBException, UnsupportedEncodingException {

		if (xmlFile == null)
			return null;
		StreamSource xml = new StreamSource(xmlFile);

		return this.translateCodeLists(xml);
	}

	public String translateCodeLists(String xmlString) throws JAXBException, UnsupportedEncodingException {

		if ((xmlString == null) || (xmlString.length() == 0))
			return null;
		StreamSource xml = new StreamSource(new StringReader(xmlString));

		return this.translateCodeLists(xml);
	}

	public String translateCodeLists(StreamSource xmlStream) throws JAXBException, UnsupportedEncodingException {

		if (xmlStream == null)
			return null;

		logger.debug("Preparing to translate from XML to JSON");

		JAXBContext context = JAXBContext.newInstance(CodeLists.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		CodeLists codeLists = (CodeLists) unmarshaller.unmarshal(xmlStream);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(codeLists, baos);

		logger.debug("Translation complete");

		return baos.toString("UTF-8");
	}

	private class UnmarshallLogger extends Unmarshaller.Listener {

		@Override
		public void beforeUnmarshal(Object target, Object parent) {
			logger.debug("Before unmarshalling object " + target);
		}

		@Override
		public void afterUnmarshal(Object target, Object parent) {
			logger.debug("After unmarshalling object " + target);
		}
	}
}
