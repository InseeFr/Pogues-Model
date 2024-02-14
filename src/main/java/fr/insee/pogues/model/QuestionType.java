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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour QuestionType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="QuestionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xml.insee.fr/schema/applis/pogues}ComponentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{http://xml.insee.fr/schema/applis/pogues}ResponseType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="ResponseStructure" type="{http://xml.insee.fr/schema/applis/pogues}ResponseStructureType" minOccurs="0"/&gt;
 *         &lt;element name="ClarificationQuestion" type="{http://xml.insee.fr/schema/applis/pogues}QuestionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Scope" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="questionType" type="{http://xml.insee.fr/schema/applis/pogues}QuestionTypeEnum" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionType", propOrder = {
    "response",
    "responseStructure",
    "clarificationQuestion",
    "scope"
})
public class QuestionType
    extends ComponentType
{

    @XmlElement(name = "Response", required = true)
    protected List<ResponseType> response;
    @XmlElement(name = "ResponseStructure")
    protected ResponseStructureType responseStructure;
    @XmlElement(name = "ClarificationQuestion")
    protected List<QuestionType> clarificationQuestion;
    @XmlElement(name = "Scope")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String scope;
    @XmlAttribute(name = "questionType")
    protected QuestionTypeEnum questionType;

    /**
     * Gets the value of the response property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the response property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseType }
     * 
     * 
     */
    public List<ResponseType> getResponse() {
        if (response == null) {
            response = new ArrayList<ResponseType>();
        }
        return this.response;
    }

    /**
     * Obtient la valeur de la propriété responseStructure.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStructureType }
     *     
     */
    public ResponseStructureType getResponseStructure() {
        return responseStructure;
    }

    /**
     * Définit la valeur de la propriété responseStructure.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStructureType }
     *     
     */
    public void setResponseStructure(ResponseStructureType value) {
        this.responseStructure = value;
    }

    /**
     * Gets the value of the clarificationQuestion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clarificationQuestion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClarificationQuestion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuestionType }
     * 
     * 
     */
    public List<QuestionType> getClarificationQuestion() {
        if (clarificationQuestion == null) {
            clarificationQuestion = new ArrayList<QuestionType>();
        }
        return this.clarificationQuestion;
    }

    /**
     * Obtient la valeur de la propriété scope.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScope() {
        return scope;
    }

    /**
     * Définit la valeur de la propriété scope.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * Obtient la valeur de la propriété questionType.
     * 
     * @return
     *     possible object is
     *     {@link QuestionTypeEnum }
     *     
     */
    public QuestionTypeEnum getQuestionType() {
        return questionType;
    }

    /**
     * Définit la valeur de la propriété questionType.
     * 
     * @param value
     *     allowed object is
     *     {@link QuestionTypeEnum }
     *     
     */
    public void setQuestionType(QuestionTypeEnum value) {
        this.questionType = value;
    }

}
