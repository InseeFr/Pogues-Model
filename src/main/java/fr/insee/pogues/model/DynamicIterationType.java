//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.02.13 à 11:40:22 PM CET 
//


package fr.insee.pogues.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour DynamicIterationType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="DynamicIterationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xml.insee.fr/schema/applis/pogues}IterationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Minimum" type="{http://xml.insee.fr/schema/applis/pogues}ExpressionType" minOccurs="0"/&gt;
 *         &lt;element name="Maximum" type="{http://xml.insee.fr/schema/applis/pogues}ExpressionType" minOccurs="0"/&gt;
 *         &lt;element name="Step" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/&gt;
 *         &lt;element name="IterableReference" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="Filter" type="{http://xml.insee.fr/schema/applis/pogues}ExpressionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DynamicIterationType", propOrder = {
    "minimum",
    "maximum",
    "step",
    "iterableReference",
    "filter"
})
public class DynamicIterationType
    extends IterationType
{

    @XmlElement(name = "Minimum")
    protected ExpressionType minimum;
    @XmlElement(name = "Maximum")
    protected ExpressionType maximum;
    @XmlElement(name = "Step")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger step;
    @XmlElement(name = "IterableReference", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String iterableReference;
    @XmlElement(name = "Filter")
    protected ExpressionType filter;

    /**
     * Obtient la valeur de la propriété minimum.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getMinimum() {
        return minimum;
    }

    /**
     * Définit la valeur de la propriété minimum.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setMinimum(ExpressionType value) {
        this.minimum = value;
    }

    /**
     * Obtient la valeur de la propriété maximum.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getMaximum() {
        return maximum;
    }

    /**
     * Définit la valeur de la propriété maximum.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setMaximum(ExpressionType value) {
        this.maximum = value;
    }

    /**
     * Obtient la valeur de la propriété step.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStep() {
        return step;
    }

    /**
     * Définit la valeur de la propriété step.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStep(BigInteger value) {
        this.step = value;
    }

    /**
     * Obtient la valeur de la propriété iterableReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIterableReference() {
        return iterableReference;
    }

    /**
     * Définit la valeur de la propriété iterableReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIterableReference(String value) {
        this.iterableReference = value;
    }

    /**
     * Obtient la valeur de la propriété filter.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getFilter() {
        return filter;
    }

    /**
     * Définit la valeur de la propriété filter.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setFilter(ExpressionType value) {
        this.filter = value;
    }

}
