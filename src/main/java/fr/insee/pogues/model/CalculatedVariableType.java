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
 *  A calculated variable is a variable calculated from others variables
 *         including the calculated variables. 
 * 
 * <p>Classe Java pour CalculatedVariableType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="CalculatedVariableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xml.insee.fr/schema/applis/pogues}VariableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Formula" type="{http://xml.insee.fr/schema/applis/pogues}ExpressionType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalculatedVariableType", propOrder = {
    "formula"
})
public class CalculatedVariableType
    extends VariableType
{

    @XmlElement(name = "Formula", required = true)
    protected ExpressionType formula;

    /**
     * Obtient la valeur de la propriété formula.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getFormula() {
        return formula;
    }

    /**
     * Définit la valeur de la propriété formula.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setFormula(ExpressionType value) {
        this.formula = value;
    }

}
