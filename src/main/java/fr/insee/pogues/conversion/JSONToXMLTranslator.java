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
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import fr.insee.pogues.model.CodeLists;
import fr.insee.pogues.model.QuestionType;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.SequenceType;

public class JSONToXMLTranslator {

	private boolean monitored;

	public JSONToXMLTranslator() {
		this(false);
	}

	public JSONToXMLTranslator(boolean monitored) {
		this.monitored = monitored;
	}

	private static final Logger logger = LogManager.getLogger(JSONToXMLTranslator.class);

	public String translate(File jsonFile) throws JAXBException, UnsupportedEncodingException {

		if (jsonFile == null)
			return null;
		StreamSource json = new StreamSource(jsonFile);

		return this.translate(json);
	}

	public String translate(String jsonString) throws JAXBException, UnsupportedEncodingException {

		if ((jsonString == null) || (jsonString.length() == 0))
			return null;
		StreamSource json = new StreamSource(new StringReader(jsonString));

		return this.translate(json);
	}

	public String translate(StreamSource jsonStream) throws JAXBException, UnsupportedEncodingException {

		if (jsonStream == null)
			return null;

		logger.debug("Preparing to translate from JSON to XML");

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		Questionnaire questionnaireNoRoot = unmarshaller.unmarshal(jsonStream, Questionnaire.class).getValue();
		logger.debug("Questionnaire unmarshalled from JSON source, questionnaire id:" + questionnaireNoRoot.getId());

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// The JSON document does not specify the root element, so we have to
		// add it explicitly
		QName qName = new QName("http://xml.insee.fr/schema/applis/pogues", "Questionnaire");
		JAXBElement<Questionnaire> questionnaire = new JAXBElement<Questionnaire>(qName, Questionnaire.class,
				questionnaireNoRoot);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(questionnaire, baos);

		logger.debug("Translation complete");

		return baos.toString("UTF-8");
	}

	public String translateQuestion(File jsonFile) throws JAXBException, UnsupportedEncodingException {

		if (jsonFile == null)
			return null;
		StreamSource json = new StreamSource(jsonFile);

		return this.translateQuestion(json);
	}

	public String translateQuestion(String jsonString) throws JAXBException, UnsupportedEncodingException {

		if ((jsonString == null) || (jsonString.length() == 0))
			return null;
		StreamSource json = new StreamSource(new StringReader(jsonString));

		return this.translateQuestion(json);
	}

	public String translateQuestion(StreamSource jsonStream) throws JAXBException, UnsupportedEncodingException {

		if (jsonStream == null)
			return null;

		logger.debug("Preparing to translate from JSON to XML");

		JAXBContext context = JAXBContext.newInstance(QuestionType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		QuestionType questionNoRoot = unmarshaller.unmarshal(jsonStream, QuestionType.class).getValue();
		logger.debug("Question unmarshalled from JSON source, question id:" + questionNoRoot.getId());

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// The JSON document does not specify the root element, so we have to
		// add it explicitly
		QName qName = new QName("http://xml.insee.fr/schema/applis/pogues", "Question");
		JAXBElement<QuestionType> question = new JAXBElement<QuestionType>(qName, QuestionType.class, questionNoRoot);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(question, baos);

		logger.debug("Translation complete");

		return baos.toString("UTF-8");
	}

	public String translateSequence(File jsonFile) throws JAXBException, UnsupportedEncodingException {

		if (jsonFile == null)
			return null;
		StreamSource json = new StreamSource(jsonFile);

		return this.translateSequence(json);
	}

	public String translateSequence(String jsonString) throws JAXBException, UnsupportedEncodingException {

		if ((jsonString == null) || (jsonString.length() == 0))
			return null;
		StreamSource json = new StreamSource(new StringReader(jsonString));

		return this.translateSequence(json);
	}

	public String translateSequence(StreamSource jsonStream) throws JAXBException, UnsupportedEncodingException {

		if (jsonStream == null)
			return null;

		logger.debug("Preparing to translate from JSON to XML");

		JAXBContext context = JAXBContext.newInstance(SequenceType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		SequenceType sequenceNoRoot = unmarshaller.unmarshal(jsonStream, SequenceType.class).getValue();
		logger.debug("Sequence unmarshalled from JSON source, question id:" + sequenceNoRoot.getId());

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// The JSON document does not specify the root element, so we have to
		// add it explicitly
		QName qName = new QName("http://xml.insee.fr/schema/applis/pogues", "Sequence");
		JAXBElement<SequenceType> sequence = new JAXBElement<SequenceType>(qName, SequenceType.class, sequenceNoRoot);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(sequence, baos);

		logger.debug("Translation complete");

		return baos.toString("UTF-8");
	}

	public String translateCodeLists(File jsonFile) throws JAXBException, UnsupportedEncodingException {

		if (jsonFile == null)
			return null;
		StreamSource json = new StreamSource(jsonFile);

		return this.translateCodeLists(json);
	}

	public String translateCodeLists(String jsonString) throws JAXBException, UnsupportedEncodingException {

		if ((jsonString == null) || (jsonString.length() == 0))
			return null;
		StreamSource json = new StreamSource(new StringReader(jsonString));

		return this.translateCodeLists(json);
	}

	public String translateCodeLists(StreamSource jsonStream) throws JAXBException, UnsupportedEncodingException {

		if (jsonStream == null)
			return null;

		logger.debug("Preparing to translate from JSON to XML");

		JAXBContext context = JAXBContext.newInstance(CodeLists.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
		if (monitored)
			unmarshaller.setListener(new UnmarshallLogger());

		CodeLists codeListsNoRoot = unmarshaller.unmarshal(jsonStream, CodeLists.class).getValue();
		logger.debug("CodeLists unmarshalled from JSON source");

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// The JSON document does not specify the root element, so we have to
		// add it explicitly
		QName qName = new QName("http://xml.insee.fr/schema/applis/pogues", "CodeLists");
		JAXBElement<CodeLists> codeLists = new JAXBElement<CodeLists>(qName, CodeLists.class, codeListsNoRoot);

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