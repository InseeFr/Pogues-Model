//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.02.13 à 11:40:22 PM CET 
//


package fr.insee.pogues.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.insee.pogues.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Question_QNAME = new QName("http://xml.insee.fr/schema/applis/pogues", "Question");
    private final static QName _Sequence_QNAME = new QName("http://xml.insee.fr/schema/applis/pogues", "Sequence");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.insee.pogues.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Questionnaire }
     * 
     */
    public Questionnaire createQuestionnaire() {
        return new Questionnaire();
    }

    /**
     * Create an instance of {@link DataCollection }
     * 
     */
    public DataCollection createDataCollection() {
        return new DataCollection();
    }

    /**
     * Create an instance of {@link SequenceType }
     * 
     */
    public SequenceType createSequenceType() {
        return new SequenceType();
    }

    /**
     * Create an instance of {@link DeclarationType }
     * 
     */
    public DeclarationType createDeclarationType() {
        return new DeclarationType();
    }

    /**
     * Create an instance of {@link ControlType }
     * 
     */
    public ControlType createControlType() {
        return new ControlType();
    }

    /**
     * Create an instance of {@link FlowControlType }
     * 
     */
    public FlowControlType createFlowControlType() {
        return new FlowControlType();
    }

    /**
     * Create an instance of {@link GoToType }
     * 
     */
    public GoToType createGoToType() {
        return new GoToType();
    }

    /**
     * Create an instance of {@link ComponentGroup }
     * 
     */
    public ComponentGroup createComponentGroup() {
        return new ComponentGroup();
    }

    /**
     * Create an instance of {@link CodeLists }
     * 
     */
    public CodeLists createCodeLists() {
        return new CodeLists();
    }

    /**
     * Create an instance of {@link CodeList }
     * 
     */
    public CodeList createCodeList() {
        return new CodeList();
    }

    /**
     * Create an instance of {@link CodeType }
     * 
     */
    public CodeType createCodeType() {
        return new CodeType();
    }

    /**
     * Create an instance of {@link SuggesterParametersType }
     * 
     */
    public SuggesterParametersType createSuggesterParametersType() {
        return new SuggesterParametersType();
    }

    /**
     * Create an instance of {@link Questionnaire.Variables }
     * 
     */
    public Questionnaire.Variables createQuestionnaireVariables() {
        return new Questionnaire.Variables();
    }

    /**
     * Create an instance of {@link Questionnaire.Iterations }
     * 
     */
    public Questionnaire.Iterations createQuestionnaireIterations() {
        return new Questionnaire.Iterations();
    }

    /**
     * Create an instance of {@link QuestionType }
     * 
     */
    public QuestionType createQuestionType() {
        return new QuestionType();
    }

    /**
     * Create an instance of {@link DynamicIterationType }
     * 
     */
    public DynamicIterationType createDynamicIterationType() {
        return new DynamicIterationType();
    }

    /**
     * Create an instance of {@link CollectedVariableType }
     * 
     */
    public CollectedVariableType createCollectedVariableType() {
        return new CollectedVariableType();
    }

    /**
     * Create an instance of {@link CalculatedVariableType }
     * 
     */
    public CalculatedVariableType createCalculatedVariableType() {
        return new CalculatedVariableType();
    }

    /**
     * Create an instance of {@link ExternalVariableType }
     * 
     */
    public ExternalVariableType createExternalVariableType() {
        return new ExternalVariableType();
    }

    /**
     * Create an instance of {@link ResponseStructureType }
     * 
     */
    public ResponseStructureType createResponseStructureType() {
        return new ResponseStructureType();
    }

    /**
     * Create an instance of {@link DimensionType }
     * 
     */
    public DimensionType createDimensionType() {
        return new DimensionType();
    }

    /**
     * Create an instance of {@link AttributeType }
     * 
     */
    public AttributeType createAttributeType() {
        return new AttributeType();
    }

    /**
     * Create an instance of {@link MappingType }
     * 
     */
    public MappingType createMappingType() {
        return new MappingType();
    }

    /**
     * Create an instance of {@link ResponseType }
     * 
     */
    public ResponseType createResponseType() {
        return new ResponseType();
    }

    /**
     * Create an instance of {@link NonResponseModalityType }
     * 
     */
    public NonResponseModalityType createNonResponseModalityType() {
        return new NonResponseModalityType();
    }

    /**
     * Create an instance of {@link ExpressionType }
     * 
     */
    public ExpressionType createExpressionType() {
        return new ExpressionType();
    }

    /**
     * Create an instance of {@link SuggesterField }
     * 
     */
    public SuggesterField createSuggesterField() {
        return new SuggesterField();
    }

    /**
     * Create an instance of {@link FieldSynonym }
     * 
     */
    public FieldSynonym createFieldSynonym() {
        return new FieldSynonym();
    }

    /**
     * Create an instance of {@link SuggesterOrder }
     * 
     */
    public SuggesterOrder createSuggesterOrder() {
        return new SuggesterOrder();
    }

    /**
     * Create an instance of {@link SuggesterQueryParser }
     * 
     */
    public SuggesterQueryParser createSuggesterQueryParser() {
        return new SuggesterQueryParser();
    }

    /**
     * Create an instance of {@link SuggesterQueryParserParams }
     * 
     */
    public SuggesterQueryParserParams createSuggesterQueryParserParams() {
        return new SuggesterQueryParserParams();
    }

    /**
     * Create an instance of {@link BooleanDatatypeType }
     * 
     */
    public BooleanDatatypeType createBooleanDatatypeType() {
        return new BooleanDatatypeType();
    }

    /**
     * Create an instance of {@link DateDatatypeType }
     * 
     */
    public DateDatatypeType createDateDatatypeType() {
        return new DateDatatypeType();
    }

    /**
     * Create an instance of {@link DurationDatatypeType }
     * 
     */
    public DurationDatatypeType createDurationDatatypeType() {
        return new DurationDatatypeType();
    }

    /**
     * Create an instance of {@link NumericDatatypeType }
     * 
     */
    public NumericDatatypeType createNumericDatatypeType() {
        return new NumericDatatypeType();
    }

    /**
     * Create an instance of {@link TextDatatypeType }
     * 
     */
    public TextDatatypeType createTextDatatypeType() {
        return new TextDatatypeType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QuestionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://xml.insee.fr/schema/applis/pogues", name = "Question")
    public JAXBElement<QuestionType> createQuestion(QuestionType value) {
        return new JAXBElement<QuestionType>(_Question_QNAME, QuestionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SequenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SequenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://xml.insee.fr/schema/applis/pogues", name = "Sequence")
    public JAXBElement<SequenceType> createSequence(SequenceType value) {
        return new JAXBElement<SequenceType>(_Sequence_QNAME, SequenceType.class, null, value);
    }

}
