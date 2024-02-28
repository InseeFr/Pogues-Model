package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DurationDatatypeType extends DatatypeType {

    @JsonProperty("Minimum")
    protected String minimum;

    @JsonProperty("Maximum")
    protected String maximum;

    @JsonProperty("Format")
    protected String format;

    public DurationDatatypeType() {
        super(DatatypeTypeEnum.DURATION);
    }

}
