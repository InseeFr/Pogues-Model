package fr.insee.pogues.mock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.insee.pogues.model.ComponentGroup;
import fr.insee.pogues.model.Questionnaire;
import fr.insee.pogues.model.SequenceType;
import fr.insee.pogues.model.Survey;

public class QuestionnaireFactory {

	private static final Logger logger = LogManager.getLogger(QuestionnaireFactory.class);

	public QuestionnaireFactory() {}

	public Questionnaire createQuestionnaire() {

		Questionnaire questionnaire = new Questionnaire();

		String questionnaireNumber =  String.format("%03d", (int) Math.floor(Math.random() * 1000));

		logger.debug("Creating questionnaire number " + questionnaireNumber);

		questionnaire.setId("FQ_" + questionnaireNumber);
		questionnaire.setName("Fake questionnaire number " + questionnaireNumber);
		questionnaire.getLabel().add("Label for fake questionnaire number " + questionnaireNumber);
		questionnaire.setAgency("fr.insee");

		// Creation of the fake survey
		String surveyNumber =  String.format("%02d", (int) Math.floor(Math.random() * 100));
		Survey survey = new Survey();
		survey.setId("FS_" + surveyNumber);
		survey.setName("Fake survey number " + surveyNumber);
		survey.setAgency("fr.insee");
		questionnaire.setSurvey(survey);
		logger.debug("Survey added to questionnaire number " + questionnaireNumber);

		// Create a sequence of level 0 and borrow its children
		SequenceFactory sequenceFactory = new SequenceFactory();
		SequenceType sequence = sequenceFactory.createSequence(1);
		questionnaire.getChild().addAll(sequence.getChild());

		// Create a component group
		ComponentGroup group = new ComponentGroup();
		group.setId("PENDING_COMPONENTS");
		group.setName("Questions waiting to be created");
		group.getLabel().add("Label for pending components group");
		SequenceType groupComponentContainer = sequenceFactory.createSequence(99);
		group.getMember().addAll(groupComponentContainer.getChild());
		questionnaire.getComponentGroup().add(group);
		logger.debug("Component group added to questionnaire number " + questionnaireNumber);

		// Create a code list container with one code list and one code list specification
		CodeListFactory codeListFactory = new CodeListFactory();
		questionnaire.setCodeLists(codeListFactory.createCodeLists());

		logger.debug("Code list container added to questionnaire number " + questionnaireNumber);

		return questionnaire;
	}
}
