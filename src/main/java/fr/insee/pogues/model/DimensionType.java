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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour DimensionType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="DimensionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodeListReference" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="dimensionType" use="required" type="{http://xml.insee.fr/schema/applis/pogues}DimensionTypeEnum" /&gt;
 *       &lt;attribute name="dynamic" use="required" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DimensionType", propOrder = {
    "codeListReference",
    "label",
    "totalLabel"
})
public class DimensionType {

    @XmlElement(name = "CodeListReference")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String codeListReference;
    @XmlElement(name = "Label")
    protected String label;
    @XmlElement(name = "TotalLabel")
    protected String totalLabel;
    @XmlAttribute(name = "dimensionType", required = true)
    protected DimensionTypeEnum dimensionType;
    @XmlAttribute(name = "dynamic", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String dynamic;

    /**
     * Obtient la valeur de la propriété codeListReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeListReference() {
        return codeListReference;
    }

    /**
     * Définit la valeur de la propriété codeListReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeListReference(String value) {
        this.codeListReference = value;
    }

    /**
     * Obtient la valeur de la propriété label.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Définit la valeur de la propriété label.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Obtient la valeur de la propriété totalLabel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalLabel() {
        return totalLabel;
    }

    /**
     * Définit la valeur de la propriété totalLabel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalLabel(String value) {
        this.totalLabel = value;
    }

    /**
     * Obtient la valeur de la propriété dimensionType.
     * 
     * @return
     *     possible object is
     *     {@link DimensionTypeEnum }
     *     
     */
    public DimensionTypeEnum getDimensionType() {
        return dimensionType;
    }

    /**
     * Définit la valeur de la propriété dimensionType.
     * 
     * @param value
     *     allowed object is
     *     {@link DimensionTypeEnum }
     *     
     */
    public void setDimensionType(DimensionTypeEnum value) {
        this.dimensionType = value;
    }

    /**
     * Obtient la valeur de la propriété dynamic.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDynamic() {
        return dynamic;
    }

    /**
     * Définit la valeur de la propriété dynamic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDynamic(String value) {
        this.dynamic = value;
    }

}
