package fr.insee.pogues.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.insee.pogues.conversion.JSONToXMLTranslator;
import fr.insee.pogues.conversion.XMLToJSONTranslator;

@Path("questionnaire")
public class QuestionnaireTranslator {

	private static final Logger logger = LogManager.getLogger(QuestionnaireTranslator.class);

    @POST
    @Path("json-xml")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response jsonToXML(String jsonQuestionnaire, @DefaultValue("false") @QueryParam("monitor") boolean monitor) {

    	if ((jsonQuestionnaire == null) || (jsonQuestionnaire.length() == 0)) {
    		logger.error("Null or empty content received, returning BAD REQUEST response");
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	if (logger.isDebugEnabled()) {
        	String jsonStart = (jsonQuestionnaire.length() < 30) ? jsonQuestionnaire : jsonQuestionnaire.substring(0, 30);
        	logger.debug("Trying to translate to XML questionnaire starting with " + jsonStart);
        	if (monitor) logger.debug("Monitoring in on");
    	}
    	String xmlQuestionnaire;
    	try {
    		JSONToXMLTranslator translator = new JSONToXMLTranslator(monitor);
    		xmlQuestionnaire = translator.translate(jsonQuestionnaire);
    	} catch (Exception e) {
    		logger.error("Error during translation", e);
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    	}
    	return Response.status(Status.OK).entity(xmlQuestionnaire).build();	
    }

    @POST
    @Path("xml-json")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_XML)
    public Response xmlToJSON(String xmlQuestionnaire, @DefaultValue("false") @QueryParam("monitor") boolean monitor) {

    	if ((xmlQuestionnaire == null) || (xmlQuestionnaire.length() == 0)) {
    		logger.error("Null or empty content received, returning BAD REQUEST response");
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	if (logger.isDebugEnabled()) {
    		String xmlStart = (xmlQuestionnaire.length() < 50) ? xmlQuestionnaire : xmlQuestionnaire.substring(0, 50);
        	logger.debug("Trying to translate to JSON questionnaire starting with " + xmlStart);
        	if (monitor) logger.debug("Monitoring in on");
    	}
    	String jsonQuestionnaire;
    	try {
    		XMLToJSONTranslator translator = new XMLToJSONTranslator(monitor);
    		jsonQuestionnaire = translator.translate(xmlQuestionnaire);
    	} catch (Exception e) {
    		logger.error("Error during translation", e);
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    	}
    	return Response.status(Status.OK).entity(jsonQuestionnaire).build();	
    }
}
