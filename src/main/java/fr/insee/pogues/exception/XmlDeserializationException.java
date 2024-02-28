package fr.insee.pogues.exception;

public class XmlDeserializationException extends Exception {

    public XmlDeserializationException(String message) {
        super(message);
    }

    public XmlDeserializationException(String message, Exception e) {
        super(message, e);
    }

}
