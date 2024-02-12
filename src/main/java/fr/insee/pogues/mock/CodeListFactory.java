package fr.insee.pogues.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.insee.pogues.model.CodeList;
import fr.insee.pogues.model.CodeLists;
import fr.insee.pogues.model.CodeType;

public class CodeListFactory {

	public static int MAX_CODE_NUMBER = 7;

	private static final Logger logger = LoggerFactory.getLogger(CodeListFactory.class);

	public CodeListFactory() {}

	public CodeList createCodeList() {

		CodeList codeList = new CodeList();

		String listId = "CL_" + (int) Math.floor(Math.random() * 10000);

		logger.debug("Creating code list " + listId);

		codeList.setId(listId);
		codeList.setName("Code list " + listId);
		codeList.setLabel("Label for code list number " + listId);

		int numberOfCodes = (int) Math.floor(Math.random() * (MAX_CODE_NUMBER + 1));
		for (int codeIndex = 0; codeIndex <= numberOfCodes; codeIndex++) {
			CodeType codeType = new CodeType(); 
			codeType.setLabel("Label for code number " + listId + "_" + codeIndex);
			codeType.setValue(listId + "_" + codeIndex);
			codeList.getCode().add(codeType);
		}
		logger.debug("Number of codes in list: " + numberOfCodes);

		return codeList;
	}
	public CodeLists createCodeLists(int codeListNumber, int codeListSpecificationNumber) {

		logger.debug("Creating (" + codeListNumber + "," + codeListSpecificationNumber + ") CodeLists object");

		CodeLists codeLists = new CodeLists();

		if (codeListNumber >= 1) {
			for (int codeListIndex = 0; codeListIndex < codeListNumber; codeListIndex++) {
				codeLists.getCodeList().add(this.createCodeList());
			}
		}
		return codeLists;
	}

	public CodeLists createCodeLists() {

		return createCodeLists(1, 2);
	}
}
