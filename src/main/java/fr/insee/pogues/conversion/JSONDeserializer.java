package fr.insee.pogues.conversion;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import fr.insee.pogues.model.Questionnaire;

public class JSONDeserializer {

	public JSONDeserializer() {

	}

	public Questionnaire deserialize(String fileName) throws JAXBException {

		if ((fileName == null) || (fileName.length() == 0)) return null;

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);

		StreamSource json = new StreamSource(fileName);
		Questionnaire questionnaire = unmarshaller.unmarshal(json, Questionnaire.class).getValue();

		return questionnaire;

	}

}
