package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class NumericDatatypeType extends DatatypeType {

    @JsonProperty("Minimum")
    protected BigDecimal minimum;

    @JsonProperty("Maximum")
    protected BigDecimal maximum;

    /** Number of decimal places. */
    @JsonProperty("Decimals")
    protected BigInteger decimals;

    /** Unit name. Note: DDI-Access-Services provides a list of units. */
    @JsonProperty("Unit")
    protected String unit;

    public NumericDatatypeType() {
        super(DatatypeTypeEnum.NUMERIC);
    }

}
