//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.02.13 à 11:40:22 PM CET 
//


package fr.insee.pogues.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour VisualizationHintEnum.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="VisualizationHintEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="CHECKBOX"/&gt;
 *     &lt;enumeration value="DROPDOWN"/&gt;
 *     &lt;enumeration value="RADIO"/&gt;
 *     &lt;enumeration value="SUGGESTER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VisualizationHintEnum")
@XmlEnum
public enum VisualizationHintEnum {


    /**
     * Checkbox (each modality will be checkable or uncheckable, but only one
     *             answer possible)
     * 
     */
    CHECKBOX,

    /**
     * Drop-down list (when the list of modalities is known to the respondents
     *             and particularly long, this type of response translates into a free text field on the
     *             paper questionnaire
     * 
     */
    DROPDOWN,

    /**
     * Radio button (standard web ergonomics for this type of answer, you can't
     *             uncheck the answer to the question (you can change the answer, but you can't delete an
     *             answer))
     * 
     */
    RADIO,

    /**
     * For a large list of codes, such as a nomenclature, this component is used to suggest the sublist of codes
     *             whose labels correspond to the text entered by the respondent and the suggester's rules
     * 
     */
    SUGGESTER;

    public String value() {
        return name();
    }

    public static VisualizationHintEnum fromValue(String v) {
        return valueOf(v);
    }

}
