package fr.insee.pogues.mock;

import java.math.BigInteger;

import fr.insee.pogues.model.SequenceType;

public class SequenceFactory {

	public static int ONLY_SEQUENCES_DEPTH = 1;
	public static int ONLY_QUESTIONS_DEPTH = 3;
	public static int MAX_CHILDREN_NUMBER = 5;

	public SequenceFactory() {

	}

	public SequenceType createSequence(int number) {

		if (number <= 0) return null;

		int depth = String.valueOf(number).length();
		if (depth > ONLY_QUESTIONS_DEPTH) return null;

		SequenceType sequence = new SequenceType();
		ComponentFactory componentFactory = new ComponentFactory();
		QuestionFactory questionFactory = new QuestionFactory();

		sequence.setId("FSQ_" + number);
		sequence.setName("Sequence number " + number);
		sequence.getLabel().add("Label for sequence number " + number);
		// TODO See http://stackoverflow.com/questions/16280273/jaxb-javatype-customization-on-xsinteger-produces-xmlelement-with-type-string
		sequence.setDepth(BigInteger.valueOf(depth));
		componentFactory.fleshoutComponent(sequence);

		int numberOfChildren = (int) Math.floor(Math.random() * (MAX_CHILDREN_NUMBER + 1));
		for (int childIndex = 0; childIndex <= numberOfChildren; childIndex++) {
			int childNumber = number * 10 + childIndex;
			boolean childIsSequence = (depth <= ONLY_SEQUENCES_DEPTH) || ((depth != ONLY_QUESTIONS_DEPTH) && (Math.random() < 0.5));
			if (childIsSequence) sequence.getChildren().add((this.createSequence(childNumber)));
			else sequence.getChildren().add(questionFactory.createQuestion(childNumber));
		}

		return sequence;
		
	}

}
