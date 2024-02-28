package fr.insee.pogues.conversion;

import fr.insee.pogues.exception.JsonSerializationException;
import fr.insee.pogues.exception.XmlDeserializationException;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Slf4j
public class XmlToJsonConverter {

	private final XmlDeserializer xmlDeserializer;
	private final JsonSerializer jsonSerializer;

	public XmlToJsonConverter() {
		xmlDeserializer = new XmlDeserializer();
		jsonSerializer = new JsonSerializer();
	}

	public String convertQuestionnaire(File xmlFile) throws IOException, XmlDeserializationException, JsonSerializationException {
		if (xmlFile == null) {
			log.warn("Given file is null. null returned.");
			return null;
		}
		String jsonContent = Files.readString(xmlFile.toPath());
		return convertQuestionnaire(jsonContent);
	}

	public String convertQuestionnaire(String xmlString) throws XmlDeserializationException, JsonSerializationException {

		log.info("About to convert xml questionnaire to json format...");

		if ((xmlString == null) || (xmlString.isEmpty())) {
			log.warn("null or empty string given. null returned");
			return null;
		}

		InputStream xmlInputStream = new ByteArrayInputStream(xmlString.getBytes());
		String jsonString = jsonSerializer.serialize(xmlDeserializer.deserialize(xmlInputStream));
		log.info("Questionnaire conversion from xml to json succeeded.");
		return jsonString;
	}

}
