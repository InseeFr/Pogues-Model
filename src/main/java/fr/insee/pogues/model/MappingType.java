//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.02.13 à 11:40:22 PM CET 
//


package fr.insee.pogues.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour MappingType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="MappingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MappingSource" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MappingTarget" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MappingType", propOrder = {
    "mappingSource",
    "mappingTarget"
})
public class MappingType {

    @XmlElement(name = "MappingSource", required = true)
    protected String mappingSource;
    @XmlElement(name = "MappingTarget", required = true)
    protected String mappingTarget;

    /**
     * Obtient la valeur de la propriété mappingSource.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMappingSource() {
        return mappingSource;
    }

    /**
     * Définit la valeur de la propriété mappingSource.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMappingSource(String value) {
        this.mappingSource = value;
    }

    /**
     * Obtient la valeur de la propriété mappingTarget.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMappingTarget() {
        return mappingTarget;
    }

    /**
     * Définit la valeur de la propriété mappingTarget.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMappingTarget(String value) {
        this.mappingTarget = value;
    }

}
