package fr.insee.pogues.exception;

public class JsonSerializationException extends Exception {

    public JsonSerializationException(String message) {
        super(message);
    }

    public JsonSerializationException(String message, Exception e) {
        super(message, e);
    }

}
