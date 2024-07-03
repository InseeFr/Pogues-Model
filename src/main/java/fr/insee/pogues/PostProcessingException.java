package fr.insee.pogues;

public class PostProcessingException extends RuntimeException {

    public PostProcessingException(String message, Exception e) {
        super(message, e);
    }

}
