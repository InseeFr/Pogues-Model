//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.02.13 à 11:40:22 PM CET 
//


package fr.insee.pogues.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xml.insee.fr/schema/applis/pogues}SequenceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xml.insee.fr/schema/applis/pogues}DataCollection" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://xml.insee.fr/schema/applis/pogues}ComponentGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://xml.insee.fr/schema/applis/pogues}CodeLists" minOccurs="0"/&gt;
 *         &lt;element name="Variables" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Variable" type="{http://xml.insee.fr/schema/applis/pogues}VariableType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Iterations" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Iteration" type="{http://xml.insee.fr/schema/applis/pogues}IterationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="agency" type="{http://www.w3.org/2001/XMLSchema}token" default="com.example" /&gt;
 *       &lt;attribute name="final" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="flowLogic" type="{http://xml.insee.fr/schema/applis/pogues}FlowLogicEnum" /&gt;
 *       &lt;attribute name="formulasLanguage" type="{http://xml.insee.fr/schema/applis/pogues}FormulasLanguageEnum" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dataCollection",
    "componentGroup",
    "codeLists",
    "variables",
    "iterations"
})
@XmlRootElement(name = "Questionnaire")
@JacksonXmlRootElement(namespace = "http://xml.insee.fr/schema/applis/pogues")
public class Questionnaire
    extends SequenceType
{

    @XmlElement(name = "DataCollection", required = true)
    protected List<DataCollection> dataCollection;
    @XmlElement(name = "ComponentGroup")
    protected List<ComponentGroup> componentGroup;
    @XmlElement(name = "CodeLists")
    protected CodeLists codeLists;
    @XmlElement(name = "Variables")
    protected Questionnaire.Variables variables;
    @XmlElement(name = "Iterations")
    protected Questionnaire.Iterations iterations;
    @XmlAttribute(name = "agency")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String agency;
    @XmlAttribute(name = "final")
    protected Boolean _final;
    @XmlAttribute(name = "flowLogic")
    protected FlowLogicEnum flowLogic;
    @XmlAttribute(name = "formulasLanguage")
    protected FormulasLanguageEnum formulasLanguage;

    /**
     * Gets the value of the dataCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataCollection }
     * 
     * 
     */
    public List<DataCollection> getDataCollection() {
        if (dataCollection == null) {
            dataCollection = new ArrayList<DataCollection>();
        }
        return this.dataCollection;
    }

    /**
     * ComponentGroup currently contains the references of all objects in
     *                   the questionnaire. This object was originally created for pagination which is not
     *                   currently implemented in Pogues.Gets the value of the componentGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the componentGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponentGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComponentGroup }
     * 
     * 
     */
    public List<ComponentGroup> getComponentGroup() {
        if (componentGroup == null) {
            componentGroup = new ArrayList<ComponentGroup>();
        }
        return this.componentGroup;
    }

    /**
     * Obtient la valeur de la propriété codeLists.
     * 
     * @return
     *     possible object is
     *     {@link CodeLists }
     *     
     */
    public CodeLists getCodeLists() {
        return codeLists;
    }

    /**
     * Définit la valeur de la propriété codeLists.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeLists }
     *     
     */
    public void setCodeLists(CodeLists value) {
        this.codeLists = value;
    }

    /**
     * Obtient la valeur de la propriété variables.
     * 
     * @return
     *     possible object is
     *     {@link Questionnaire.Variables }
     *     
     */
    public Questionnaire.Variables getVariables() {
        return variables;
    }

    /**
     * Définit la valeur de la propriété variables.
     * 
     * @param value
     *     allowed object is
     *     {@link Questionnaire.Variables }
     *     
     */
    public void setVariables(Questionnaire.Variables value) {
        this.variables = value;
    }

    /**
     * Obtient la valeur de la propriété iterations.
     * 
     * @return
     *     possible object is
     *     {@link Questionnaire.Iterations }
     *     
     */
    public Questionnaire.Iterations getIterations() {
        return iterations;
    }

    /**
     * Définit la valeur de la propriété iterations.
     * 
     * @param value
     *     allowed object is
     *     {@link Questionnaire.Iterations }
     *     
     */
    public void setIterations(Questionnaire.Iterations value) {
        this.iterations = value;
    }

    /**
     * Obtient la valeur de la propriété agency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgency() {
        if (agency == null) {
            return "com.example";
        } else {
            return agency;
        }
    }

    /**
     * Définit la valeur de la propriété agency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgency(String value) {
        this.agency = value;
    }

    /**
     * Obtient la valeur de la propriété final.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFinal() {
        return _final;
    }

    /**
     * Définit la valeur de la propriété final.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFinal(Boolean value) {
        this._final = value;
    }

    /**
     * Obtient la valeur de la propriété flowLogic.
     * 
     * @return
     *     possible object is
     *     {@link FlowLogicEnum }
     *     
     */
    public FlowLogicEnum getFlowLogic() {
        return flowLogic;
    }

    /**
     * Définit la valeur de la propriété flowLogic.
     * 
     * @param value
     *     allowed object is
     *     {@link FlowLogicEnum }
     *     
     */
    public void setFlowLogic(FlowLogicEnum value) {
        this.flowLogic = value;
    }

    /**
     * Obtient la valeur de la propriété formulasLanguage.
     * 
     * @return
     *     possible object is
     *     {@link FormulasLanguageEnum }
     *     
     */
    public FormulasLanguageEnum getFormulasLanguage() {
        return formulasLanguage;
    }

    /**
     * Définit la valeur de la propriété formulasLanguage.
     * 
     * @param value
     *     allowed object is
     *     {@link FormulasLanguageEnum }
     *     
     */
    public void setFormulasLanguage(FormulasLanguageEnum value) {
        this.formulasLanguage = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Iteration" type="{http://xml.insee.fr/schema/applis/pogues}IterationType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "iteration"
    })
    public static class Iterations {

        @XmlElement(name = "Iteration")
        protected List<IterationType> iteration;

        /**
         * Gets the value of the iteration property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the iteration property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIteration().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IterationType }
         * 
         * 
         */
        public List<IterationType> getIteration() {
            if (iteration == null) {
                iteration = new ArrayList<IterationType>();
            }
            return this.iteration;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Variable" type="{http://xml.insee.fr/schema/applis/pogues}VariableType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "variable"
    })
    public static class Variables {

        @XmlElement(name = "Variable")
        protected List<VariableType> variable;

        /**
         * Gets the value of the variable property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the variable property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVariable().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VariableType }
         * 
         * 
         */
        public List<VariableType> getVariable() {
            if (variable == null) {
                variable = new ArrayList<VariableType>();
            }
            return this.variable;
        }

    }

}
