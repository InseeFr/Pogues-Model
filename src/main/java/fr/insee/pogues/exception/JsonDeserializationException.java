package fr.insee.pogues.exception;

/** Exception to be thrown if something gets wrong during the deserialization of a questionnaire. */
public class JsonDeserializationException extends Exception {

    public JsonDeserializationException(String message) {
        super(message);
    }

    public JsonDeserializationException(String message, Exception e) {
        super(message, e);
    }

}
