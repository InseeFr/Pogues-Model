package fr.insee.pogues.model;

/**
 * Enum to qualify a type of sequence.
 */
public enum GenericNameEnum {

    /** Questionnaire. Corresponds to the "template" type of sequence in DDI. */
    QUESTIONNAIRE,

    /** Sequence. Corresponds to the "module" type of sequence in DDI. */
    MODULE,

    /** Subsequence. Corresponds to the "submodule" type of sequence in DDI. */
    SUBMODULE

}
