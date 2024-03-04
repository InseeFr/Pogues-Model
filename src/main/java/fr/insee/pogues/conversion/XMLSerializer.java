package fr.insee.pogues.conversion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import fr.insee.pogues.exception.XmlSerializationException;
import fr.insee.pogues.model.CodeList;
import fr.insee.pogues.model.CodeLists;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.SequenceType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlSerializer {

	private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	private final XmlMapper xmlMapper;

	public XmlSerializer() {
		xmlMapper = XmlMapper.builder().defaultUseWrapper(false).build();
		xmlMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
	}

	public String serialize(Questionnaire questionnaire) throws XmlSerializationException {
		if (questionnaire == null) return "";

		log.debug("Serializing questionnaire {}", questionnaire.getId());

        try {
            return xmlMapper.writeValueAsString(questionnaire);
        } catch (JsonProcessingException e) {
            throw new XmlSerializationException("Unable to deserialize given questionnaire.", e);
        }
    }

	public String serialize(SequenceType sequence) throws XmlSerializationException {
		if (sequence == null) return "";

		log.debug("Serializing sequence {}", sequence.getId());

		try {
			return xmlMapper.writeValueAsString(sequence);
		} catch (JsonProcessingException e) {
			throw new XmlSerializationException("Unable to deserialize given sequence.", e);
		}
	}

	public String serialize(CodeList codeList) throws XmlSerializationException {

		if (codeList == null) return "";

		log.debug("Serializing code list {}", codeList.getId());

		try {
			return xmlMapper.writeValueAsString(codeList);
		} catch (JsonProcessingException e) {
			throw new XmlSerializationException("Unable to deserialize given code list.", e);
		}
	}

	public String serialize(CodeLists codeLists) throws XmlSerializationException {

		if (codeLists == null) return "";

		log.debug("Serializing CodeLists object");

		try {
			return xmlMapper.writeValueAsString(codeLists);
		} catch (JsonProcessingException e) {
			throw new XmlSerializationException("Unable to deserialize given code lists.", e);
		}
	}

}
