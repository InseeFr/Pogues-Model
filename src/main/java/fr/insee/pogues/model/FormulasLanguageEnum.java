package fr.insee.pogues.model;

/**
 * Choice of formula input language (VTL or XPATH). It applies to the entire questionnaire, the mix of languages is
 * not supported.
 */
public enum FormulasLanguageEnum {

    /**
     * XPATH : Xforms/Orbeon technologies tools (V1 tools) need formulas written in pseudo-xpath.
     * @deprecated The usage of XPath language in questionnaires will no longer be supported.
     */
    @Deprecated
    XPATH,

    /**
     * The tools based on JavaScript and Lunatic (V2 tools) need formulas written in VTL. VTL (Validation and
     * Transformation Language) is a programming language born in the bosom of the SDMX aggregate data description
     * standard.
     */
    VTL

}
