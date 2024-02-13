package fr.insee.pogues.conversion;

import fr.insee.pogues.model.*;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class XMLToJSONTranslator {

	private static final Logger logger = LoggerFactory.getLogger(XMLToJSONTranslator.class);
	public static final String START_DEBUG_MESSAGE = "Preparing to translate from XML to JSON";
	public static final String END_DEBUG_MESSAGE = "Translation complete";
	public static final String JSON_CONTENT_TYPE = "application/json";
	public static final String UTF_8_ENCODING = "UTF-8";

	private final boolean monitored;

	public XMLToJSONTranslator() {
		this(false);
	}

	public XMLToJSONTranslator(boolean monitored) {
		this.monitored = monitored;
	}

	public String translate(File xmlFile) throws JAXBException {

		if (xmlFile == null)
			return null;
		StreamSource xml = new StreamSource(xmlFile);

		return this.translate(xml);
	}

	public String translate(String xmlString) throws JAXBException {

		if ((xmlString == null) || (xmlString.isEmpty()))
			return null;
		StreamSource xml = new StreamSource(new StringReader(xmlString));

		return this.translate(xml);
	}

	public String translate(StreamSource xmlStream) throws JAXBException {

		if (xmlStream == null)
			return null;

		logger.debug(START_DEBUG_MESSAGE);

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		Questionnaire questionnaire = (Questionnaire) unmarshaller.unmarshal(xmlStream);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, JSON_CONTENT_TYPE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, UTF_8_ENCODING);
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(questionnaire, outputStream);

		logger.debug(END_DEBUG_MESSAGE);

		return outputStream.toString(StandardCharsets.UTF_8);
	}

	public String translateSequence(File xmlFile) throws JAXBException {

		if (xmlFile == null)
			return null;
		StreamSource xml = new StreamSource(xmlFile);

		return this.translateSequence(xml);
	}

	public String translateSequence(String xmlString) throws JAXBException {

		if ((xmlString == null) || (xmlString.isEmpty()))
			return null;
		StreamSource xml = new StreamSource(new StringReader(xmlString));

		return this.translateSequence(xml);
	}

	public String translateSequence(StreamSource xmlStream) throws JAXBException {

		if (xmlStream == null)
			return null;

		logger.debug(START_DEBUG_MESSAGE);

		JAXBContext context = JAXBContext.newInstance(SequenceType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		JAXBElement<SequenceType> jeSequence = unmarshaller.unmarshal(xmlStream, SequenceType.class);
		SequenceType sequence = jeSequence.getValue();

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, JSON_CONTENT_TYPE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, UTF_8_ENCODING);
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(sequence, outputStream);

		logger.debug(END_DEBUG_MESSAGE);

		return outputStream.toString(StandardCharsets.UTF_8);
	}

	public String translateQuestion(File xmlFile) throws JAXBException {

		if (xmlFile == null)
			return null;
		StreamSource xml = new StreamSource(xmlFile);

		return this.translateQuestion(xml);
	}

	public String translateQuestion(String xmlString) throws JAXBException {

		if ((xmlString == null) || (xmlString.isEmpty()))
			return null;
		StreamSource xml = new StreamSource(new StringReader(xmlString));

		return this.translateQuestion(xml);
	}

	public String translateQuestion(StreamSource xmlStream) throws JAXBException {

		if (xmlStream == null)
			return null;

		logger.debug(START_DEBUG_MESSAGE);

		JAXBContext context = JAXBContext.newInstance(QuestionType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		JAXBElement<QuestionType> jeQuestion = unmarshaller.unmarshal(xmlStream, QuestionType.class);
        QuestionType question = jeQuestion.getValue();

        Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, JSON_CONTENT_TYPE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, UTF_8_ENCODING);
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(question, outputStream);

		logger.debug(END_DEBUG_MESSAGE);

		return outputStream.toString(StandardCharsets.UTF_8);
	}

	public String translateCodeLists(File xmlFile) throws JAXBException {

		if (xmlFile == null)
			return null;
		StreamSource xml = new StreamSource(xmlFile);

		return this.translateCodeLists(xml);
	}

	public String translateCodeLists(String xmlString) throws JAXBException {

		if ((xmlString == null) || (xmlString.isEmpty()))
			return null;
		StreamSource xml = new StreamSource(new StringReader(xmlString));

		return this.translateCodeLists(xml);
	}

	public String translateCodeLists(StreamSource xmlStream) throws JAXBException {

		if (xmlStream == null)
			return null;

		logger.debug(START_DEBUG_MESSAGE);

		JAXBContext context = JAXBContext.newInstance(CodeLists.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		CodeLists codeLists = (CodeLists) unmarshaller.unmarshal(xmlStream);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, JSON_CONTENT_TYPE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, UTF_8_ENCODING);
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(codeLists, outputStream);

		logger.debug(END_DEBUG_MESSAGE);

		return outputStream.toString(StandardCharsets.UTF_8);
	}
	
	public String translateCodeList(File xmlFile) throws JAXBException {

		if (xmlFile == null)
			return null;
		StreamSource xml = new StreamSource(xmlFile);

		return this.translateCodeList(xml);
	}

	public String translateCodeList(String xmlString) throws JAXBException {

		if ((xmlString == null) || (xmlString.isEmpty()))
			return null;
		StreamSource xml = new StreamSource(new StringReader(xmlString));

		return this.translateCodeList(xml);
	}

	public String translateCodeList(StreamSource xmlStream) throws JAXBException {

		if (xmlStream == null)
			return null;

		logger.debug(START_DEBUG_MESSAGE);

		JAXBContext context = JAXBContext.newInstance(CodeLists.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		CodeList codeList = (CodeList) unmarshaller.unmarshal(xmlStream);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, JSON_CONTENT_TYPE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, UTF_8_ENCODING);
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(codeList, outputStream);

		logger.debug(END_DEBUG_MESSAGE);

		return outputStream.toString(StandardCharsets.UTF_8);
	}

	private static class UnmarshallLogger extends Unmarshaller.Listener {
		@Override
		public void beforeUnmarshal(Object target, Object parent) {
			logger.debug("Before unmarshalling object {}", target);
		}
		@Override
		public void afterUnmarshal(Object target, Object parent) {
			logger.debug("After unmarshalling object {}", target);
		}
	}

}
