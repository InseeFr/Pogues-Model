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

import fr.insee.pogues.conversion.JSONToXMLTranslator;

public class JSONToXMLFunction extends BasicFunction {

	private static final Logger logger = LogManager.getLogger(JSONToXMLFunction.class);

	public final static FunctionSignature J2X_SIGNATURE = new FunctionSignature(
		new QName("j2x", PoguesModule.NAMESPACE_URI, PoguesModule.PREFIX),
		"Converts a JSON questionnaire to XML",
		new SequenceType[] { 
		    new FunctionParameterSequenceType("text", Type.STRING, Cardinality.EXACTLY_ONE, "The JSON text")
		},
		new FunctionReturnSequenceType(Type.STRING, Cardinality.EXACTLY_ONE, "the XML text"));

	public JSONToXMLFunction(XQueryContext context, FunctionSignature signature) {
		super(context, signature);
	}

	@Override
	public Sequence eval(Sequence[] args, Sequence contextSequence) throws XPathException {

		logger.debug("Entering eval method");

		JSONToXMLTranslator translator = new JSONToXMLTranslator();
		String xmlQuestionnaire = null;
		try {
			xmlQuestionnaire = translator.translate(args[0].itemAt(0).getStringValue());
		} catch (UnsupportedEncodingException | JAXBException e) {
			logger.error("Error during the JSON -> XML conversion: " + e.getMessage());
			// This is a proprietary error code
			throw new XPathException(new ErrorCodes.ErrorCode("XPOG001", "Error parsing JSON."), "Error during the JSON -> XML conversion", e);
		}

		logger.debug("Questionnaire conversion performed");

		return new StringValue(xmlQuestionnaire);
	}
}
