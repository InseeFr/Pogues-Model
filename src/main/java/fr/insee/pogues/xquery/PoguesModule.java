package fr.insee.pogues.xquery;

import java.util.List;
import java.util.Map;

import org.exist.xquery.AbstractInternalModule;
import org.exist.xquery.FunctionDef;

public class PoguesModule extends AbstractInternalModule {

	public final static String NAMESPACE_URI = "http://id.insee.fr/apps/pogues";
	public final static String PREFIX = "pogues";
	public final static String DESCRIPTION = "Format converters for Pogues";
	public final static String EXIST_VERSION = "2.1";

	private final static FunctionDef[] functions = {
	    new FunctionDef(JSONToXMLFunction.J2X_SIGNATURE, JSONToXMLFunction.class),
	    new FunctionDef(XMLToJSONFunction.X2J_SIGNATURE, XMLToJSONFunction.class)
	};

	public PoguesModule(Map<String, List<? extends Object>> parameters) {
		super(functions, parameters);
	}

	@Override
	public String getDefaultPrefix() {
		return PREFIX;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public String getNamespaceURI() {
		return NAMESPACE_URI;
	}

	@Override
	public String getReleaseVersion() {
		return EXIST_VERSION;
	}

}
