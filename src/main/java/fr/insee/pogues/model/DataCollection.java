package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * A data collection (or a data collection campaign) is a survey data collection realization period.
 * Each data collection can contain one ore several questionnaire. It's characterised by a statistical operation and
 * a period (M01 - January,...,T02 - Second quarter,etc.).
 * All these concepts are created outside Pogues.
 */
@JsonPropertyOrder({
        "id",
        "uri",
        "agency",
        "Name"
})
@Getter
@Setter
public class DataCollection {

    /** Data collection identifier. */
    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected String id;

    /** URI to external data collection reference. */
    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected String uri;

    /** Agency of the data collection. It's optional. Example: "fr.insee". */
    @JacksonXmlProperty(isAttribute = true)
    protected String agency;

    /** Data collection name (label). Example: "Enquête sectorielle annuelle 2018" */
    @JsonProperty(value = "Name", required = true)
    protected String name;

}
