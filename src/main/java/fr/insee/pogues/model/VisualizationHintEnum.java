package fr.insee.pogues.model;

public enum VisualizationHintEnum {


    /** Checkbox (each modality will be checkable or uncheckable, but only one answer possible). */
    CHECKBOX,

    /** Drop-down list (when the list of modalities is known to the respondents and particularly long, this type of
     * response translates into a free text field on the paper questionnaire. */
    DROPDOWN,

    /** Radio button (standard web ergonomics for this type of answer, you can't uncheck the answer to the question
     * (you can change the answer, but you can't delete an answer))
     */
    RADIO,

    /** For a large list of codes, such as a nomenclature, this component is used to suggest the sublist of codes whose
     * labels correspond to the text entered by the respondent and the suggester's rules. */
    SUGGESTER

}
