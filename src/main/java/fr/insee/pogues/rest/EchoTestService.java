package fr.insee.pogues.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.insee.pogues.conversion.JSONToXMLTranslator;
import fr.insee.pogues.conversion.XMLToJSONTranslator;

@Path("echo")
public class EchoTestService {

	private static final Logger logger = LogManager.getLogger(EchoTestService.class);

    @POST
    @Path("json")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response echoJSON(String jsonContent) {

    	if ((jsonContent == null) || (jsonContent.length() == 0)) {
    		logger.error("Null or empty content received, returning BAD REQUEST response");
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	logger.debug("Echoing JSON contents starting with " + jsonContent.substring(0, 30));

    	return Response.status(Status.OK).entity(jsonContent).build();	
    }

    @POST
    @Path("xml-json")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response echoXML(String xmlContent) {

    	if ((xmlContent == null) || (xmlContent.length() == 0)) {
    		logger.error("Null or empty content received, returning BAD REQUEST response");
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	logger.debug("Echoing XML contents starting with " + xmlContent.substring(0, 50));

    	return Response.status(Status.OK).entity(xmlContent).build();		
    }

}
