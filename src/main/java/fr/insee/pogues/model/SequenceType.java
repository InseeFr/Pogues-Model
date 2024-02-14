//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.02.13 à 11:40:22 PM CET 
//


package fr.insee.pogues.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour SequenceType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="SequenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xml.insee.fr/schema/applis/pogues}ComponentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Child" type="{http://xml.insee.fr/schema/applis/pogues}ComponentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="depth" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="genericName" type="{http://xml.insee.fr/schema/applis/pogues}GenericNameEnum" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequenceType", propOrder = {
    "child"
})
@XmlSeeAlso({
    Questionnaire.class
})
public class SequenceType
    extends ComponentType
{

    @XmlElement(name = "Child")
    protected List<ComponentType> child;
    @XmlAttribute(name = "depth")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger depth;
    @XmlAttribute(name = "genericName")
    protected GenericNameEnum genericName;

    /**
     * Gets the value of the child property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the child property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChild().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComponentType }
     * 
     * 
     */
    public List<ComponentType> getChild() {
        if (child == null) {
            child = new ArrayList<ComponentType>();
        }
        return this.child;
    }

    /**
     * Obtient la valeur de la propriété depth.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDepth() {
        return depth;
    }

    /**
     * Définit la valeur de la propriété depth.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDepth(BigInteger value) {
        this.depth = value;
    }

    /**
     * Obtient la valeur de la propriété genericName.
     * 
     * @return
     *     possible object is
     *     {@link GenericNameEnum }
     *     
     */
    public GenericNameEnum getGenericName() {
        return genericName;
    }

    /**
     * Définit la valeur de la propriété genericName.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericNameEnum }
     *     
     */
    public void setGenericName(GenericNameEnum value) {
        this.genericName = value;
    }

}
