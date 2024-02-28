package fr.insee.pogues.model;

public enum DimensionTypeEnum {

    /**
     * <p> In a fixed table (with row header in the first column and without the possibility of dynamically adding a
     * row to the table), the primary information axis corresponds to the left column.</p>
     * <p> In a roster question (without a first column row header and with the ability to dynamically add a row to
     * the table), the primary information is the main (and single) axis of information.</p>
     */
    PRIMARY,

    /**
     * In a fixed table with double entry, the secondary information axis corresponds to the information in the
     * column header (secondary axis).
     */
    SECONDARY,

    /**
     * This is the information measured (only one if secondary information axis, one or more possible otherwise).
     * Simple Answer or Single Choice Response Information.
     */
    MEASURE

}
