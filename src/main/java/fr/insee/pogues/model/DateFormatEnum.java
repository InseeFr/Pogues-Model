package fr.insee.pogues.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Date output format among YYYY-MM-DD, YYYY-MM and YYYY.
 */
public enum DateFormatEnum {

    YYYY_MM_DD("YYYY-MM-DD"),
    YYYY_MM("YYYY-MM"),
    YYYY("YYYY");

    private final String value;

    DateFormatEnum(String v) {
        value = v;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static DateFormatEnum fromValue(String v) {
        for (DateFormatEnum c: DateFormatEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
