package fr.insee.pogues.model;

/**
 * Type of declaration.
 */
public enum DeclarationTypeEnum {


    /** When the declaration concerns only the interviewer (CAPI or CATI mode). */
    INSTRUCTION,

    /** When the declaration concerns the respondent, whatever the mode. */
    HELP,

    /** For questions where the interviewer will be required to present a code card to the respondent (CAPI mode). */
    CODECARD

}
