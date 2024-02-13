package fr.insee.pogues.exception;

// TODO: make this exception a checked expression and don't throw jaxb exceptions anymore.
// Note: not done yet since it has possible impacts in Pogues-Back-Office and possible other client of the lib.

/** Exception to be thrown if something gets wrong during the deserialization of a questionnaire. */
public class PoguesDeserializationException extends RuntimeException {

    public PoguesDeserializationException(String message) {
        super(message);
    }

}
