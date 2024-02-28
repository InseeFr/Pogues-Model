package fr.insee.pogues.conversion;

import fr.insee.pogues.exception.JsonDeserializationException;
import fr.insee.pogues.exception.XmlSerializationException;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Slf4j
public class JsonToXmlConverter {

	private final JsonDeserializer jsonDeserializer;
	private final XmlSerializer xmlSerializer;

	public JsonToXmlConverter() {
		jsonDeserializer = new JsonDeserializer();
		xmlSerializer = new XmlSerializer();
	}

	public String convertQuestionnaire(File jsonFile) throws IOException, JsonDeserializationException, XmlSerializationException {
		if (jsonFile == null) {
			log.warn("Given file is null. null returned.");
			return null;
		}
		String jsonContent = Files.readString(jsonFile.toPath());
		return convertQuestionnaire(jsonContent);
	}

	public String convertQuestionnaire(String jsonString) throws JsonDeserializationException, XmlSerializationException {

		log.info("About to convert json questionnaire to xml format...");

		if ((jsonString == null) || (jsonString.isEmpty())) {
			log.warn("null or empty string given. null returned");
			return null;
		}

		InputStream jsonInputStream = new ByteArrayInputStream(jsonString.getBytes());
		String xmlString = xmlSerializer.serialize(jsonDeserializer.deserialize(jsonInputStream));
		log.info("Questionnaire conversion from json to xml succeeded.");
		return xmlString;
	}

}