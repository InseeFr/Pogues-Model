package fr.insee.pogues.model;

/**
 * Survey designer should have the possibility to choose if they prefer to describe the dynamic of their questionnaire
 * (jump directly to a question, a sequence or a subsequence according to a condition on some variables) with a GoTo
 * or an IfThenElse logic.
 */
public enum FlowLogicEnum {

    /**
     * GoTo logic: condition the hiding of certain elements of the questionnaire: jump from a starting element to a
     * target element according to a certain condition.
     * @deprecated GoTo logic is deprecated.
     */
    @Deprecated
    REDIRECTION,

    /**
     * IfThenElse logic: condition the display of a sequence, sub-sequence or a set of questions.
     */
    FILTER

}
