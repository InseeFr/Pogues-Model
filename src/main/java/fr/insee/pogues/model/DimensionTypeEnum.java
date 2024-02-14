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
 * <p>Classe Java pour DimensionTypeEnum.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="DimensionTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="PRIMARY"/&gt;
 *     &lt;enumeration value="SECONDARY"/&gt;
 *     &lt;enumeration value="MEASURE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DimensionTypeEnum")
@XmlEnum
public enum DimensionTypeEnum {


    /**
     * In a roster question (without a first column row header and with the
     *             ability to dynamically add a row to the table), the primary information is the main (and
     *             single) axis of information.
     * 
     */
    PRIMARY,

    /**
     * In a fixed table with double entry, the secondary information axis
     *             corresponds to the information in the column header (secondary axis).
     * 
     */
    SECONDARY,

    /**
     * This is the information measured (only one if secondary information
     *             axis, one or more possible otherwise). Simple Answer or Single Choice Response
     *             Information.
     * 
     */
    MEASURE;

    public String value() {
        return name();
    }

    public static DimensionTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
