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
 * <p>Classe Java pour DeclarationTypeEnum.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="DeclarationTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="INSTRUCTION"/&gt;
 *     &lt;enumeration value="HELP"/&gt;
 *     &lt;enumeration value="CODECARD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DeclarationTypeEnum")
@XmlEnum
public enum DeclarationTypeEnum {


    /**
     *  INSTRUCTION : when the declaration concerns only the interviewer (CAPI
     *             or CATI mode). 
     * 
     */
    INSTRUCTION,

    /**
     *  HELP : when the declaration concerns the respondent, whatever the mode.
     *           
     * 
     */
    HELP,

    /**
     *  CODECARD : for questions where the interviewer will be required to
     *             present a code card to the respondent (CAPI Mode). 
     * 
     */
    CODECARD;

    public String value() {
        return name();
    }

    public static DeclarationTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
