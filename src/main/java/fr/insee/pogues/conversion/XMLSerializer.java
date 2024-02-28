package fr.insee.pogues.conversion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import fr.insee.pogues.exception.XmlSerializationException;
import fr.insee.pogues.model.CodeList;
import fr.insee.pogues.model.CodeLists;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.SequenceType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlSerializer {

	private final XmlMapper xmlMapper;

	public XmlSerializer() {
		xmlMapper = new XmlMapper();
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
