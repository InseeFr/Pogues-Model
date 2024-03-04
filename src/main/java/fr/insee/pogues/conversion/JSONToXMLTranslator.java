package fr.insee.pogues.conversion;

import fr.insee.pogues.model.CodeLists;
import fr.insee.pogues.model.QuestionType;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.SequenceType;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class JSONToXMLTranslator {

	private static final Logger logger = LoggerFactory.getLogger(JSONToXMLTranslator.class);
	public static final String START_DEBUG_MESSAGE = "Preparing to translate from JSON to XML";
	public static final String POGUES_XML_NAMESPACE = "http://xml.insee.fr/schema/applis/pogues";

	private final boolean monitored;

	public JSONToXMLTranslator() {
		this(false);
	}

	public JSONToXMLTranslator(boolean monitored) {
		this.monitored = monitored;
	}

	public String translate(File jsonFile) throws JAXBException {

		if (jsonFile == null)
			return null;
		StreamSource json = new StreamSource(jsonFile);

		return this.translate(json);
	}

	public String translate(String jsonString) throws JAXBException {

		if ((jsonString == null) || (jsonString.isEmpty()))
			return null;
		StreamSource json = new StreamSource(new StringReader(jsonString));

		return this.translate(json);
	}

	public String translate(StreamSource jsonStream) throws JAXBException {

		if (jsonStream == null)
			return null;

		logger.debug(START_DEBUG_MESSAGE);

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, ConversionConstants.JSON_CONTENT_TYPE);
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		Questionnaire questionnaireNoRoot = unmarshaller.unmarshal(jsonStream, Questionnaire.class).getValue();
		logger.debug("Questionnaire unmarshalled from JSON source, questionnaire id: {}", questionnaireNoRoot.getId());

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, ConversionConstants.UTF_8_ENCODING);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// The JSON document does not specify the root element, so we have to
		// add it explicitly
		QName qName = new QName(POGUES_XML_NAMESPACE, "Questionnaire");
		JAXBElement<Questionnaire> questionnaire = new JAXBElement<>(qName, Questionnaire.class,
				questionnaireNoRoot);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(questionnaire, outputStream);

		logger.debug(ConversionConstants.TRANSLATION_COMPLETE_MESSAGE);

		return outputStream.toString(StandardCharsets.UTF_8);
	}

	public String translateQuestion(File jsonFile) throws JAXBException {

		if (jsonFile == null)
			return null;
		StreamSource json = new StreamSource(jsonFile);

		return this.translateQuestion(json);
	}

	public String translateQuestion(String jsonString) throws JAXBException {

		if ((jsonString == null) || (jsonString.isEmpty()))
			return null;
		StreamSource json = new StreamSource(new StringReader(jsonString));

		return this.translateQuestion(json);
	}

	public String translateQuestion(StreamSource jsonStream) throws JAXBException {

		if (jsonStream == null)
			return null;

		logger.debug(START_DEBUG_MESSAGE);

		JAXBContext context = JAXBContext.newInstance(QuestionType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, ConversionConstants.JSON_CONTENT_TYPE);
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		QuestionType questionNoRoot = unmarshaller.unmarshal(jsonStream, QuestionType.class).getValue();
		logger.debug("Question unmarshalled from JSON source, question id: {}", questionNoRoot.getId());

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, ConversionConstants.UTF_8_ENCODING);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// The JSON document does not specify the root element, so we have to
		// add it explicitly
		QName qName = new QName(POGUES_XML_NAMESPACE, "Question");
		JAXBElement<QuestionType> question = new JAXBElement<>(qName, QuestionType.class, questionNoRoot);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(question, outputStream);

		logger.debug(ConversionConstants.TRANSLATION_COMPLETE_MESSAGE);

		return outputStream.toString(StandardCharsets.UTF_8);
	}

	public String translateSequence(File jsonFile) throws JAXBException {

		if (jsonFile == null)
			return null;
		StreamSource json = new StreamSource(jsonFile);

		return this.translateSequence(json);
	}

	public String translateSequence(String jsonString) throws JAXBException {

		if ((jsonString == null) || (jsonString.isEmpty()))
			return null;
		StreamSource json = new StreamSource(new StringReader(jsonString));

		return this.translateSequence(json);
	}

	public String translateSequence(StreamSource jsonStream) throws JAXBException {

		if (jsonStream == null)
			return null;

		logger.debug(START_DEBUG_MESSAGE);

		JAXBContext context = JAXBContext.newInstance(SequenceType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, ConversionConstants.JSON_CONTENT_TYPE);
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		SequenceType sequenceNoRoot = unmarshaller.unmarshal(jsonStream, SequenceType.class).getValue();
		logger.debug("Sequence unmarshalled from JSON source, question id: {}", sequenceNoRoot.getId());

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, ConversionConstants.UTF_8_ENCODING);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// The JSON document does not specify the root element, so we have to
		// add it explicitly
		QName qName = new QName(POGUES_XML_NAMESPACE, "Sequence");
		JAXBElement<SequenceType> sequence = new JAXBElement<>(qName, SequenceType.class, sequenceNoRoot);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(sequence, outputStream);

		logger.debug(ConversionConstants.TRANSLATION_COMPLETE_MESSAGE);

		return outputStream.toString(StandardCharsets.UTF_8);
	}

	public String translateCodeLists(File jsonFile) throws JAXBException {

		if (jsonFile == null)
			return null;
		StreamSource json = new StreamSource(jsonFile);

		return this.translateCodeLists(json);
	}

	public String translateCodeLists(String jsonString) throws JAXBException {

		if ((jsonString == null) || (jsonString.isEmpty()))
			return null;
		StreamSource json = new StreamSource(new StringReader(jsonString));

		return this.translateCodeLists(json);
	}

	public String translateCodeLists(StreamSource jsonStream) throws JAXBException {

		if (jsonStream == null)
			return null;

		logger.debug(START_DEBUG_MESSAGE);

		JAXBContext context = JAXBContext.newInstance(CodeLists.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, ConversionConstants.JSON_CONTENT_TYPE);
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		CodeLists codeListsNoRoot = unmarshaller.unmarshal(jsonStream, CodeLists.class).getValue();
		logger.debug("CodeLists unmarshalled from JSON source");

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, ConversionConstants.UTF_8_ENCODING);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// The JSON document does not specify the root element, so we have to
		// add it explicitly
		QName qName = new QName(POGUES_XML_NAMESPACE, "CodeLists");
		JAXBElement<CodeLists> codeLists = new JAXBElement<>(qName, CodeLists.class, codeListsNoRoot);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshaller.marshal(codeLists, outputStream);

		logger.debug(ConversionConstants.TRANSLATION_COMPLETE_MESSAGE);

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