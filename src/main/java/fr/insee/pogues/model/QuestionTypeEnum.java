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
 * <p>Classe Java pour QuestionTypeEnum.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="QuestionTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="SIMPLE"/&gt;
 *     &lt;enumeration value="SINGLE_CHOICE"/&gt;
 *     &lt;enumeration value="MULTIPLE_CHOICE"/&gt;
 *     &lt;enumeration value="TABLE"/&gt;
 *     &lt;enumeration value="PAIRWISE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "QuestionTypeEnum")
@XmlEnum
public enum QuestionTypeEnum {


    /**
     * a SIMPLE question is a question made of a label and only one response
     *             domain whichever its type be: text, numeric, date, boolean, or less frequently any type
     *             available in the DDI schemas.
     * 
     */
    SIMPLE,

    /**
     * a SINGLE_CHOICE question is a question made of a label and a response
     *             domain typed as a code list. This type of question allows to the respondent to select
     *             one single response from a predefined list.
     * 
     */
    SINGLE_CHOICE,

    /**
     * A MULTIPLE_CHOICE question is a question whose label is the mutual part
     *             of several sub-questions (constituting a coherent whole i.e an information axis). Each
     *             modality of the information axis is peculiar to a specific response domain. This type of
     *             question allows to the respondent to select the best possible answers out of a number of
     *             choices from a predefined list.
     * 
     */
    MULTIPLE_CHOICE,

    /**
     * A TABLE is a two-way table. It's a question made of a label and a
     *             response domain defined by two dimensions. The information located at the intersection
     *             of a row and a column corresponds to a response. 
     * 
     */
    TABLE,

    /**
     * When surveying households, we distinguish the household and the individual members of the household.
     *             In order to properly set up the questionnaire, we want to map individuals relationships, in fact pairing them.
     *             Moreover, as far as possible we would like to infer some relationships instead of asking redundant questions.
     *             For example, if Alice is the mother of Bob, then Bob is the child of Alice.
     * 
     */
    PAIRWISE;

    public String value() {
        return name();
    }

    public static QuestionTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
