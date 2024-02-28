package fr.insee.pogues.model;

/**
 * Optional Enum to make the difference between an ex-Goto FlowControl and a Clarification FlowControl.
 * Only a single value for now. This enum exists for legacy reasons.
 */
public enum FlowControlTypeEnum {

    /** Jump to a clarification question ('other, please specify') */
    CLARIFICATION;

}
