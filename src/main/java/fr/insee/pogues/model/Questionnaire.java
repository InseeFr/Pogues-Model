package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
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
@JacksonXmlRootElement(namespace = "http://xml.insee.fr/schema/applis/pogues")
public class Questionnaire extends SequenceType {

    /** Xml namespace of Pogues questionnaires. */
    public static final String XML_NAMESPACE = "http://xml.insee.fr/schema/applis/pogues";

    /** Default value that exists for legacy reasons. */
    private static final String AGENCY_DEFAULT_VALUE = "com.example";


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
    protected String agency;

    /** Boolean attribute indicating if the questionnaire is final or not. */
    @JsonProperty("final")
    protected Boolean finalOrNot;

    /** Type of filters used in the questionnaire. */
    protected FlowLogicEnum flowLogic;

    /** Language used for expressions in the questionnaire. */
    protected FormulasLanguageEnum formulasLanguage;

    public Questionnaire() {
        super();
        dataCollection = new ArrayList<>();
        componentGroup = new ArrayList<>();
        codeLists = new CodeLists();
        variables = new Variables();
        iterations = new Iterations();
        agency = AGENCY_DEFAULT_VALUE;
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
