//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.02.13 à 11:40:22 PM CET 
//


package fr.insee.pogues.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour DatatypeType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="DatatypeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="typeName" use="required" type="{http://xml.insee.fr/schema/applis/pogues}DatatypeTypeEnum" /&gt;
 *       &lt;attribute name="visualizationHint" type="{http://xml.insee.fr/schema/applis/pogues}VisualizationHintEnum" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatatypeType")
@XmlSeeAlso({
    BooleanDatatypeType.class,
    DateDatatypeType.class,
    DurationDatatypeType.class,
    NumericDatatypeType.class,
    TextDatatypeType.class
})
public abstract class DatatypeType {

    @XmlAttribute(name = "typeName", required = true)
    protected DatatypeTypeEnum typeName;
    @XmlAttribute(name = "visualizationHint")
    protected VisualizationHintEnum visualizationHint;

    /**
     * Obtient la valeur de la propriété typeName.
     * 
     * @return
     *     possible object is
     *     {@link DatatypeTypeEnum }
     *     
     */
    public DatatypeTypeEnum getTypeName() {
        return typeName;
    }

    /**
     * Définit la valeur de la propriété typeName.
     * 
     * @param value
     *     allowed object is
     *     {@link DatatypeTypeEnum }
     *     
     */
    public void setTypeName(DatatypeTypeEnum value) {
        this.typeName = value;
    }

    /**
     * Obtient la valeur de la propriété visualizationHint.
     * 
     * @return
     *     possible object is
     *     {@link VisualizationHintEnum }
     *     
     */
    public VisualizationHintEnum getVisualizationHint() {
        return visualizationHint;
    }

    /**
     * Définit la valeur de la propriété visualizationHint.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualizationHintEnum }
     *     
     */
    public void setVisualizationHint(VisualizationHintEnum value) {
        this.visualizationHint = value;
    }

}
