package fr.insee.pogues.mock;

import java.math.BigInteger;

import fr.insee.pogues.model.DatatypeTypeEnum;
import fr.insee.pogues.model.DateDatatypeType;
import fr.insee.pogues.model.NumericDatatypeType;
import fr.insee.pogues.model.ResponseType;
import fr.insee.pogues.model.TextDatatypeType;

public class ResponseFactory {

	public ResponseFactory() {

	}

	public ResponseType createSimpleTextReponse() {

		ResponseType response = new ResponseType();
		response.setSimple(true);
		response.setMandatory(false);
		TextDatatypeType textType = new TextDatatypeType();
		textType.setTypeName(DatatypeTypeEnum.TEXT);
		textType.setMaxLength(BigInteger.valueOf(100));
		response.setDatatype(textType);

		return response;
		
	}

	public ResponseType createReponse() {

		ResponseType response = new ResponseType();
		response.setSimple(true);
		response.setMandatory(false);
		// Chose datatype at random
		double datatypeSelector =  Math.random();
		if (datatypeSelector < 0.33) {
			TextDatatypeType textType = new TextDatatypeType();
			textType.setTypeName(DatatypeTypeEnum.TEXT);
			textType.setMaxLength(BigInteger.valueOf(100));
			response.setDatatype(textType);
			// Predefined values in 1/4 of cases
			if (Math.random() < 0.25) {
				int numberOfLabels = (int) Math.floor(Math.random() * 4) + 1;
				for (int labelIndex = 1; labelIndex <= numberOfLabels; labelIndex++) {
					response.getPredefinedLabel().add("Predefined answer number " + labelIndex);
				}
			}
			
		} else if (datatypeSelector < 0.66) {
			NumericDatatypeType numericType = new NumericDatatypeType();
			numericType.setTypeName(DatatypeTypeEnum.NUMERIC);
			numericType.setMinimum(BigInteger.valueOf(0));
			numericType.setMaximum(BigInteger.valueOf(100));
			response.setDatatype(numericType);		
		} else {
			DateDatatypeType dateType = new DateDatatypeType();
			dateType.setTypeName(DatatypeTypeEnum.DATE);
			dateType.setFormat("yyyy-MM-dd");
			response.setDatatype(dateType);
		}


		return response;
		
	}


}
