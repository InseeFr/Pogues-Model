package fr.insee.pogues.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.insee.pogues.model.QuestionType;

public class QuestionFactory {

	private static final Logger logger = LoggerFactory.getLogger(QuestionFactory.class);

	ResponseFactory responseFactory = null;

	public QuestionFactory() {
		responseFactory = new ResponseFactory();
	}

	public QuestionType createQuestion(int number) {

		if (number < 0) return null;

		QuestionType question = this.createQuestionOnly(number);
		ComponentFactory componentFactory = new ComponentFactory();
		componentFactory.fleshoutComponent(question);

		logger.debug("Question fleshed out");

		question.getResponse().add(responseFactory.createResponse());

		logger.debug("Response added to the question");

		return question;
	}

	public QuestionType createQuestionOnly(int number) {

		if (number < 0) return null;

		logger.debug("Creating question number " + number);

		QuestionType question = new QuestionType();

		question.setId("FQU_" + number);
		question.setName("Question number " + number);
		question.getLabel().add("Label for question number " + number);

		// For now response is mandatory, so we just create a simple text response
		question.getResponse().add(responseFactory.createSimpleTextResponse());

		return question;
	}
}
