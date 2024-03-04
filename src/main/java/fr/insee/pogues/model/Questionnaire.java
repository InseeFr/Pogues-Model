package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Pogues questionnaire. A questionnaire in the sense of Pogues is an entire questionnaire template or an
 * independent part of a questionnaire.
 */
@Getter
@Setter
public class Questionnaire extends SequenceType {

    // Note: @JacksonXmlRootElement(namespace = ...) doesn't work
    // https://github.com/FasterXML/jackson-dataformat-xml/issues/18
    @JsonIgnore
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns")
    private String xmlNamespace = "http://xml.insee.fr/schema/applis/pogues";


    @JsonProperty(value = "DataCollection", required = true)
    protected List<DataCollection> dataCollection;

    /** ComponentGroup currently contains the references of all objects in the questionnaire. This object was
     * originally created for pagination which is not currently implemented in Pogues. */
    @JsonProperty("ComponentGroup")
    protected List<ComponentGroup> componentGroup;

    /** Code lists defined in the questionnaire. */
    @JsonProperty("CodeLists")
    protected CodeLists codeLists;

    /** Questionnaire variables. Contains all questionnaire's variables (external, collected, etc). */
    @JsonProperty("Variables")
    protected Questionnaire.Variables variables;

    /** Iterations (i.e.) loops defined in the questionnaire. */
    @JsonProperty("Iterations")
    protected Questionnaire.Iterations iterations;

    /** Agency that produces the questionnaire. Optional. Example: "fr.insee". */
    @JacksonXmlProperty(isAttribute = true)
    protected String agency;

    /** Boolean attribute indicating if the questionnaire is final or not. */
    @JsonProperty("final")
    @JacksonXmlProperty(isAttribute = true, localName = "final")
    protected Boolean finalOrNot;

    /** Type of filters used in the questionnaire. */
    @JacksonXmlProperty(isAttribute = true)
    protected FlowLogicEnum flowLogic;

    /** Language used for expressions in the questionnaire. */
    @JacksonXmlProperty(isAttribute = true)
    protected FormulasLanguageEnum formulasLanguage;

    public Questionnaire() {
        super();
        dataCollection = new ArrayList<>();
        componentGroup = new ArrayList<>();
    }


    /** Class that contains a list of iterations.
     * Exists for legacy reasons. */
    public static class Iterations {

        /** <p> A loop is an iteration (according to one criterion) on a group of questions.</p>
         * <p>The group of questions is equivalent to a sequence (module) or a sub-sequence (sub-module).</p>
         * <p>An iteration criterion is a condition defining the number of times the question group is repeated. It
         * can simply be (considering that by default we start at 1 and that the step is 1).</p> */
        @JsonProperty("Iteration")
        protected List<IterationType> iteration;

        public Iterations() {
            iteration = new ArrayList<>();
        }

    }


    /** Class that contains a list of variables.
     * Exists for legacy reasons. */
    public static class Variables {

        @JsonProperty("Variable")
        protected List<VariableType> variable;

        public Variables() {
            variable = new ArrayList<>();
        }

    }

}
