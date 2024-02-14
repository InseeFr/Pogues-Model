//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.02.13 à 11:40:22 PM CET 
//


package fr.insee.pogues.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour NumericDatatypeType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="NumericDatatypeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xml.insee.fr/schema/applis/pogues}DatatypeType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Minimum" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Maximum" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Decimals" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/&gt;
 *         &lt;element name="Unit" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumericDatatypeType", propOrder = {
    "minimum",
    "maximum",
    "decimals",
    "unit"
})
public class NumericDatatypeType
    extends DatatypeType
{

    @XmlElement(name = "Minimum")
    protected BigDecimal minimum;
    @XmlElement(name = "Maximum")
    protected BigDecimal maximum;
    @XmlElement(name = "Decimals")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger decimals;
    @XmlElement(name = "Unit")
    @XmlSchemaType(name = "anyURI")
    protected String unit;

    /**
     * Obtient la valeur de la propriété minimum.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimum() {
        return minimum;
    }

    /**
     * Définit la valeur de la propriété minimum.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimum(BigDecimal value) {
        this.minimum = value;
    }

    /**
     * Obtient la valeur de la propriété maximum.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaximum() {
        return maximum;
    }

    /**
     * Définit la valeur de la propriété maximum.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaximum(BigDecimal value) {
        this.maximum = value;
    }

    /**
     * Obtient la valeur de la propriété decimals.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDecimals() {
        return decimals;
    }

    /**
     * Définit la valeur de la propriété decimals.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDecimals(BigInteger value) {
        this.decimals = value;
    }

    /**
     * Obtient la valeur de la propriété unit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Définit la valeur de la propriété unit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

}
