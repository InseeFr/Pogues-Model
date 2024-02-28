package fr.insee.pogues.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

/**
 * Generic Pogues sequence.
 */
@JacksonXmlRootElement(namespace = "http://xml.insee.fr/schema/applis/pogues")
@Getter
@Setter
public class SequenceType extends ComponentType {

    /** Name that qualifies the type of sequence (e.g. questionnaire, sequence, subsequence). */
    protected GenericNameEnum genericName;

    /** Depth of the sequence in the questionnaire's hierarchy. */
    protected BigInteger depth;

}
