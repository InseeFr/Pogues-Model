package fr.insee.pogues.conversion;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import fr.insee.pogues.model.Questionnaire;

import java.io.InputStream;

public class JSONDeserializer {

	public JSONDeserializer() {	}

	private static final Logger logger = LoggerFactory.getLogger(JSONDeserializer.class);

	public Questionnaire deserialize(String fileName) throws JAXBException {

		if ((fileName == null) || (fileName.length() == 0)) return null;

		logger.debug("Deserializing questionnaire from file " + fileName);
		StreamSource jsonSource = new StreamSource(fileName);
		return deserialize(jsonSource);
	}

	public Questionnaire deserialize(InputStream inputStream) throws JAXBException {
		logger.debug("Deserializing questionnaire from input stream");
		StreamSource jsonSource = new StreamSource(inputStream);
		return deserialize(jsonSource);
	}

	private Questionnaire deserialize(StreamSource jsonSource) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);

		Questionnaire questionnaire = unmarshaller.unmarshal(jsonSource, Questionnaire.class).getValue();

		logger.debug("Questionnaire " + questionnaire.getId() + " successfully deserialized");

		return questionnaire;
	}

}
