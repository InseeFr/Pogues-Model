package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateDatatypeType extends DatatypeType {

    @JsonProperty("Minimum")
    protected String minimum;

    @JsonProperty("Maximum")
    protected String maximum;

    /** {@link DateFormatEnum} */
    @JsonProperty("Format")
    protected DateFormatEnum format;

    public DateDatatypeType() {
        super(DatatypeTypeEnum.DATE);
    }

}
