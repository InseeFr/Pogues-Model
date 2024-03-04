package fr.insee.pogues;

public class PreProcessingException extends RuntimeException {

    public PreProcessingException(String message, Exception e) {
        super(message, e);
    }

}
