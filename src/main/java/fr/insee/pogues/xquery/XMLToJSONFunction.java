package fr.insee.pogues.xquery;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.exist.dom.QName;
import org.exist.xquery.BasicFunction;
import org.exist.xquery.Cardinality;
import org.exist.xquery.ErrorCodes;
import org.exist.xquery.FunctionSignature;
import org.exist.xquery.XPathException;
import org.exist.xquery.XQueryContext;
import org.exist.xquery.value.FunctionParameterSequenceType;
import org.exist.xquery.value.FunctionReturnSequenceType;
import org.exist.xquery.value.Sequence;
import org.exist.xquery.value.SequenceType;
import org.exist.xquery.value.StringValue;
import org.exist.xquery.value.Type;

import fr.insee.pogues.conversion.XMLToJSONTranslator;

public class XMLToJSONFunction extends BasicFunction {

	private static final Logger logger = LogManager.getLogger(XMLToJSONFunction.class);

	public final static FunctionSignature X2J_SIGNATURE = new FunctionSignature(
		new QName("x2j", PoguesModule.NAMESPACE_URI, PoguesModule.PREFIX),
		"Converts an XML questionnaire to JSON",
		new SequenceType[] { 
		    new FunctionParameterSequenceType("text", Type.STRING, Cardinality.EXACTLY_ONE, "The XML text")
		},
		new FunctionReturnSequenceType(Type.STRING, Cardinality.EXACTLY_ONE, "the JSON text"));

	public XMLToJSONFunction(XQueryContext context, FunctionSignature signature) {
		super(context, signature);
	}

	@Override
	public Sequence eval(Sequence[] args, Sequence contextSequence) throws XPathException {

		logger.debug("Entering eval method");

		XMLToJSONTranslator translator = new XMLToJSONTranslator();
		String jsonQuestionnaire = null;
		try {
			jsonQuestionnaire = translator.translate(args[0].itemAt(0).getStringValue());
		} catch (UnsupportedEncodingException | JAXBException e) {
			logger.error("Error during the XML -> JSON conversion: " + e.getMessage());
			throw new XPathException(ErrorCodes.EXXQDY0002, "Error during the XML -> JSON conversion: " + e.getMessage(), e);
		}

		logger.debug("Questionnaire conversion performed");

		return new StringValue(jsonQuestionnaire);
	}
}
