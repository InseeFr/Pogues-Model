package fr.insee.pogues.xquery;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.exist.dom.QName;
import org.exist.xquery.BasicFunction;
import org.exist.xquery.Cardinality;
import org.exist.xquery.FunctionSignature;
import org.exist.xquery.XPathException;
import org.exist.xquery.XQueryContext;
import org.exist.xquery.value.FunctionParameterSequenceType;
import org.exist.xquery.value.FunctionReturnSequenceType;
import org.exist.xquery.value.Sequence;
import org.exist.xquery.value.SequenceType;
import org.exist.xquery.value.StringValue;
import org.exist.xquery.value.Type;

public class EchoTestFunction extends BasicFunction {

	private static final Logger logger = LogManager.getLogger(EchoTestFunction.class);

	public final static FunctionSignature ECHO_SIGNATURE = new FunctionSignature(
		new QName("echo", PoguesModule.NAMESPACE_URI, PoguesModule.PREFIX),
		"Echoes the content received",
		new SequenceType[] { 
		    new FunctionParameterSequenceType("text", Type.STRING, Cardinality.EXACTLY_ONE, "The input text")
		},
		new FunctionReturnSequenceType(Type.STRING, Cardinality.EXACTLY_ONE, "the echo of the text"));

	public EchoTestFunction(XQueryContext context, FunctionSignature signature) {
		super(context, signature);
	}

	@Override
	public Sequence eval(Sequence[] args, Sequence contextSequence) throws XPathException {

		logger.debug("Entering eval method");

		String textReceived = args[0].itemAt(0).getStringValue();

		logger.debug("Text received is " + textReceived);

		return new StringValue(textReceived);
	}
}
