package fr.insee.pogues.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

/**
 * Generic Pogues sequence.
 */
@Getter
@Setter
public class SequenceType extends ComponentType {

    /** Name that qualifies the type of sequence (e.g. questionnaire, sequence, subsequence). */
    protected GenericNameEnum genericName;

    /** Depth of the sequence in the questionnaire's hierarchy. */
    protected BigInteger depth;

}
