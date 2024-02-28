package fr.insee.pogues.model;

/**
 * Enum to qualify a type of question.
 */
public enum QuestionTypeEnum {

    /** A SIMPLE question is a question made of a label and only one response domain whichever its type be:
     * text, numeric, date, boolean, or less frequently any type available in the DDI schemas. */
    SIMPLE,

    /** A SINGLE_CHOICE question is a question made of a label and a response domain typed as a code list.
     * This type of question allows to the respondent to select one single response from a predefined list. */
    SINGLE_CHOICE,

    /** A MULTIPLE_CHOICE question is a question whose label is the mutual part of several sub-questions (constituting
     * a coherent whole i.e. an information axis). Each modality of the information axis is peculiar to a specific
     * response domain. This type of question allows to the respondent to select the best possible answers out of a
     * number of choices from a predefined list. */
    MULTIPLE_CHOICE,

    /** A TABLE is a two-way table. It's a question made of a label and a response domain defined by two dimensions.
     * The information located at the intersection of a row and a column corresponds to a response. */
    TABLE,

    /** When surveying households, we distinguish the household and the individual members of the household.
     * In order to properly set up the questionnaire, we want to map individuals relationships, in fact pairing them.
     * Moreover, as far as possible we would like to infer some relationships instead of asking redundant questions.
     * For example, if Alice is the mother of Bob, then Bob is the child of Alice. */
    PAIRWISE

}
