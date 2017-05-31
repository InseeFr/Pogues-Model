package fr.insee.pogues.mock;

import fr.insee.pogues.model.ComponentType;
import fr.insee.pogues.model.ControlCriticityEnum;
import fr.insee.pogues.model.ControlType;
import fr.insee.pogues.model.DeclarationPositionEnum;
import fr.insee.pogues.model.DeclarationType;
import fr.insee.pogues.model.DeclarationTypeEnum;
import fr.insee.pogues.model.ExpressionType;
import fr.insee.pogues.model.GoToType;
import fr.insee.pogues.model.QuestionType;

public class ComponentFactory {

	public ComponentFactory() {

	}

	/**
	 * Should be called after setting the component id.
	 * 
	 * @param component
	 */
	public void fleshoutComponent(ComponentType component) {

		if (component == null) return;

		int baseId = (int) Math.floor(Math.random() * 10000);

		// Add a declaration
		DeclarationType declaration = new DeclarationType();
		declaration.setDeclarationType(DeclarationTypeEnum.INSTRUCTION);
		declaration.setPosition(DeclarationPositionEnum.BEFORE_QUESTION_TEXT);
		declaration.setText("Instruction for component " + component.getId());
		component.getDeclaration().add(declaration);

		// Add controls (0 to 2) - 0 is 80%, 1 15% and 2 5%
		int numberOfControls = (Math.random() < 0.2) ? 1 : 0;
		if (numberOfControls == 1) numberOfControls = (Math.random() < 0.25) ? 2 : 1;
		for (int controlIndex = 0; controlIndex < numberOfControls; controlIndex++) {
			ControlType control = new ControlType();
			control.setId("CTL_" + baseId + controlIndex);
			control.setDescription("Description of control " + controlIndex);
			control.setCriticity((Math.random() < 0.5) ? ControlCriticityEnum.ERROR : ControlCriticityEnum.INFO);
			ExpressionType expression = new ExpressionType();
			expression.setValue("/Questionnaire/Sequence[1]/Sequence[2]/Question[1]/NumericResponse[1]/VariableName[1]");
			control.setExpression(expression);
			component.getControl().add(control);
		}

		// Add a go-to (30% of cases if component is a question)
		if ((Math.random() < 0.3) && (component instanceof QuestionType)) {
			GoToType goTo = new GoToType();
			goTo.setId("GTO_" + baseId);
			goTo.setDescription("Description for go-to GTO_0");
			goTo.setIfTrue("REF_TO_COMPONENT");
			ExpressionType expression = new ExpressionType();
			expression.setValue("/Questionnaire/Sequence[1]/Sequence[2]/Question[1]/NumericResponse[1]/VariableName[1]");
			goTo.setExpression(expression);
			component.getGoTo().add(goTo);
		}
	}

}
