package fr.insee.pogues.conversion;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import fr.insee.pogues.model.Questionnaire;

public class JSONDeserializer {

	public JSONDeserializer() {	}

	private static final Logger logger = LogManager.getLogger(JSONDeserializer.class);

	public Questionnaire deserialize(String fileName) throws JAXBException {

		if ((fileName == null) || (fileName.length() == 0)) return null;

		logger.debug("Deserializing questionnaire from file " + fileName);

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);

		StreamSource json = new StreamSource(fileName);
		Questionnaire questionnaire = unmarshaller.unmarshal(json, Questionnaire.class).getValue();

		logger.debug("Questionnaire " + questionnaire.getId() + " successfully deserialized");

		return questionnaire;
	}

}
