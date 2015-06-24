package fr.insee.pogues.mock;

import fr.insee.pogues.model.QuestionType;

public class QuestionFactory {

	ComponentFactory componentFactory = null;
	ResponseFactory responseFactory = null;

	public QuestionFactory() {
		componentFactory = new ComponentFactory();
		responseFactory = new ResponseFactory();
	}

	public QuestionType createQuestion(int number) {

		if (number < 0) return null;

		QuestionType question = this.createQuestionOnly(number);
		componentFactory.fleshoutComponent(question);

		question.getResponse().add(responseFactory.createResponse());

		return question;
		
	}

	public QuestionType createQuestionOnly(int number) {

		if (number < 0) return null;

		QuestionType question = new QuestionType();

		question.setId("FQU_" + number);
		question.setName("Question number " + number);
		question.getLabel().add("Label for question number " + number);

		// For now response is mandatory, so we just create a simple text response
		question.getResponse().add(responseFactory.createSimpleTextResponse());

		return question;
	}
}
