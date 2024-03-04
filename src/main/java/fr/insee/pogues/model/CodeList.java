package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * A structure used to associate a list of code values to specified categories. May be flat or hierarchical. See:
 * <a href="https://ddialliance.org/Specification/DDI-Lifecycle/3.3/XMLSchema/FieldLevelDocumentation/">
 *     DDI documentation</a>.
 * The elements of the code list are those of the DDI. You can refer to their definition in the DDI documentation.
 */
@JsonPropertyOrder({
        "id",
        "Name",
        "Label",
        "Code",
        "SuggesterParameters",
        "Urn"
})
@Getter
@Setter
public class CodeList {

    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected String id;

    @JsonProperty(value = "Name", required = true)
    protected String name;

    @JsonProperty(value = "Label", required = true)
    protected String label;

    @JsonProperty("Code")
    protected List<CodeType> code;

    @JsonProperty("SuggesterParameters")
    protected SuggesterParametersType suggesterParameters;

    @JsonProperty("Urn")
    protected String urn;

    public CodeList() {
        code = new ArrayList<>();
    }

}
