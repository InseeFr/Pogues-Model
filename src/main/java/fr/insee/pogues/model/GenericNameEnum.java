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
 * <p>Classe Java pour GenericNameEnum.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="GenericNameEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="QUESTIONNAIRE"/&gt;
 *     &lt;enumeration value="MODULE"/&gt;
 *     &lt;enumeration value="SUBMODULE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "GenericNameEnum")
@XmlEnum
public enum GenericNameEnum {


    /**
     * 
     *             
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;xs:documentation xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://xml.insee.fr/schema/applis/pogues"&gt;In DDI, type of Sequence "template"&lt;/xs:documentation&gt;
     * </pre>
     * 
     *           
     * 
     */
    QUESTIONNAIRE,

    /**
     * 
     *             
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;xs:documentation xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://xml.insee.fr/schema/applis/pogues"&gt;In DDI, type of Sequence "module"&lt;/xs:documentation&gt;
     * </pre>
     * 
     *           
     * 
     */
    MODULE,

    /**
     * 
     *             
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;xs:documentation xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://xml.insee.fr/schema/applis/pogues"&gt;In DDI, type of Sequence "submodule"&lt;/xs:documentation&gt;
     * </pre>
     * 
     *           
     * 
     */
    SUBMODULE;

    public String value() {
        return name();
    }

    public static GenericNameEnum fromValue(String v) {
        return valueOf(v);
    }

}
