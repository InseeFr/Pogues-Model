package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that contains a list of variables... Exists for legacy reasons.
 */
@JacksonXmlRootElement(namespace = "http://xml.insee.fr/schema/applis/pogues")
@Getter
@Setter
public class CodeLists {

    @JsonProperty("CodeList")
    protected List<CodeList> codeList;

    public CodeLists() {
        codeList = new ArrayList<>();
    }

}
