package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * In some cases it makes sense to have full components (e.g. components imported from repository and not yet placed
 * on the questionnaire), so to have both "Member" (a list of members which could be empty) and "MemberReference"
 * (a list of member references).
 */
@JsonPropertyOrder({
        "id",
        "Name",
        "Label",
        "Member",
        "MemberReference"
})
@Getter
@Setter
public class ComponentGroup {

    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    protected String id;

    @JsonProperty(value = "Name", required = true)
    protected String name;

    @JsonProperty(value = "Label", required = true)
    protected List<String> label;

    @JsonProperty("Member")
    protected List<ComponentType> member;

    @JsonProperty("MemberReference")
    protected List<String> memberReference;

    public ComponentGroup() {
        label = new ArrayList<>();
        member = new ArrayList<>();
        memberReference = new ArrayList<>();
    }

}
