package fr.insee.pogues.conversion;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.insee.pogues.model.CodeList;
import fr.insee.pogues.model.CodeLists;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.SequenceType;

public class XMLSerializer {

	public XMLSerializer() { }

	private static final Logger logger = LogManager.getLogger(XMLSerializer.class);

	public String serialize(Questionnaire questionnaire) throws JAXBException, UnsupportedEncodingException {

		if (questionnaire == null) return "";

		logger.debug("Serializing questionnaire " + questionnaire.getId());

		JAXBContext context = JAXBContext.newInstance(Questionnaire.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(questionnaire, baos);
	
		return baos.toString("UTF-8");

	}

	public String serialize(SequenceType sequence) throws JAXBException, UnsupportedEncodingException {

		if (sequence == null) return "";

		logger.debug("Serializing sequence " + sequence.getId());

		JAXBContext context = JAXBContext.newInstance(SequenceType.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(sequence, baos);

		return baos.toString("UTF-8");
	}

	public String serialize(CodeList codeList) throws JAXBException, UnsupportedEncodingException {

		if (codeList == null) return "";

		logger.debug("Serializing code list " + codeList.getId());

		JAXBContext context = JAXBContext.newInstance(CodeList.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(codeList, baos);
	
		return baos.toString("UTF-8");
	}

	public String serialize(CodeLists codeLists) throws JAXBException, UnsupportedEncodingException {

		if (codeLists == null) return "";

		logger.debug("Serializing CodeLists object");

		JAXBContext context = JAXBContext.newInstance(CodeLists.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(codeLists, baos);
	
		return baos.toString("UTF-8");
	}


}
