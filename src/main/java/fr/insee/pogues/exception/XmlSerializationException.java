package fr.insee.pogues.exception;

public class XmlSerializationException extends Exception {

    public XmlSerializationException(String message) {
        super(message);
    }

    public XmlSerializationException(String message, Exception e) {
        super(message, e);
    }

}
