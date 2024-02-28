package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "id",
        "name",
        "fields",
        "max",
        "stopWords",
        "order",
        "queryParser"
})
@Getter
@Setter
public class SuggesterParametersType {

    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected String id;

    @JsonProperty(required = true)
    protected String name;

    @JsonProperty(required = true)
    protected List<SuggesterField> fields;

    protected BigInteger max;

    protected List<String> stopWords;

    protected SuggesterOrder order;

    @JsonProperty(required = true)
    protected SuggesterQueryParser queryParser;

    public SuggesterParametersType() {
        fields = new ArrayList<>();
        stopWords = new ArrayList<>();
    }

}
