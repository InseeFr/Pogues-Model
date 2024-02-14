//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.02.13 à 11:40:22 PM CET 
//


package fr.insee.pogues.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour ResponseType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodeListReference" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="Datatype" type="{http://xml.insee.fr/schema/applis/pogues}DatatypeType"/&gt;
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="NonResponseModality" type="{http://xml.insee.fr/schema/applis/pogues}NonResponseModalityType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CollectedVariableReference" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;attribute name="simple" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="mandatory" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseType", propOrder = {
    "codeListReference",
    "datatype",
    "value",
    "nonResponseModality",
    "collectedVariableReference"
})
public class ResponseType {

    @XmlElement(name = "CodeListReference")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String codeListReference;
    @XmlElement(name = "Datatype", required = true)
    protected DatatypeType datatype;
    @XmlElement(name = "Value")
    protected List<Object> value;
    @XmlElement(name = "NonResponseModality")
    protected List<NonResponseModalityType> nonResponseModality;
    @XmlElement(name = "CollectedVariableReference", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String collectedVariableReference;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "simple")
    protected Boolean simple;
    @XmlAttribute(name = "mandatory")
    protected Boolean mandatory;

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
     * Obtient la valeur de la propriété datatype.
     * 
     * @return
     *     possible object is
     *     {@link DatatypeType }
     *     
     */
    public DatatypeType getDatatype() {
        return datatype;
    }

    /**
     * Définit la valeur de la propriété datatype.
     * 
     * @param value
     *     allowed object is
     *     {@link DatatypeType }
     *     
     */
    public void setDatatype(DatatypeType value) {
        this.datatype = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getValue() {
        if (value == null) {
            value = new ArrayList<Object>();
        }
        return this.value;
    }

    /**
     * Gets the value of the nonResponseModality property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonResponseModality property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNonResponseModality().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NonResponseModalityType }
     * 
     * 
     */
    public List<NonResponseModalityType> getNonResponseModality() {
        if (nonResponseModality == null) {
            nonResponseModality = new ArrayList<NonResponseModalityType>();
        }
        return this.nonResponseModality;
    }

    /**
     * Obtient la valeur de la propriété collectedVariableReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectedVariableReference() {
        return collectedVariableReference;
    }

    /**
     * Définit la valeur de la propriété collectedVariableReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectedVariableReference(String value) {
        this.collectedVariableReference = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété simple.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSimple() {
        return simple;
    }

    /**
     * Définit la valeur de la propriété simple.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSimple(Boolean value) {
        this.simple = value;
    }

    /**
     * Obtient la valeur de la propriété mandatory.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMandatory() {
        return mandatory;
    }

    /**
     * Définit la valeur de la propriété mandatory.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMandatory(Boolean value) {
        this.mandatory = value;
    }

}
