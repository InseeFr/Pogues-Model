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
 * <p>Classe Java pour FormulasLanguageEnum.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="FormulasLanguageEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="XPATH"/&gt;
 *     &lt;enumeration value="VTL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FormulasLanguageEnum")
@XmlEnum
public enum FormulasLanguageEnum {


    /**
     * XPATH : Xforms/Orbeon technologies tools (V1 tools) need formulas
     *             written in pseudo-xpath.
     * 
     */
    XPATH,

    /**
     * The tools based on JavaScript and Lunatic (V2 tools) need formulas
     *             written in VTL. VTL (Validation and Transformation Language) is a programming language
     *             born in the bosom of the SDMX aggregate data description standard.
     * 
     */
    VTL;

    public String value() {
        return name();
    }

    public static FormulasLanguageEnum fromValue(String v) {
        return valueOf(v);
    }

}
