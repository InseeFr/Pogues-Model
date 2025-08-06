package fr.insee.pogues.test.multimode;

import fr.insee.pogues.conversion.JSONDeserializer;
import fr.insee.pogues.conversion.JSONSerializer;
import fr.insee.pogues.model.*;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import javax.xml.bind.JAXBException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultimodeTest {

    private Rule createRule(MultimodeRuleNameEnum ruleName, ValueTypeEnum type, String value){
        Rule rule = new Rule();
        rule.setName(ruleName);
        rule.setType(type);
        rule.setValue(value);
        return rule;
    }

    @Test
    void serializeMultimode() throws JAXBException, UnsupportedEncodingException, JSONException {
        Questionnaire questionnaire = new Questionnaire();
        Multimode multimode = new Multimode();

        // set questionnaire rules
        Rules questionnaireRules = new Rules();
        questionnaireRules.getRules().add(
                createRule(MultimodeRuleNameEnum.IS_MOVED, ValueTypeEnum.VTL, "nvl(HABITEZ_VOUS_ICI, true)")
        );
        multimode.setQuestionnaire(questionnaireRules);

        // set leaf rules
        Rules leafRules = new Rules();
        leafRules.getRules().add(
                createRule(MultimodeRuleNameEnum.IS_MOVED, ValueTypeEnum.VTL, "nvl(PRENOM_HABITE_PLUS_LA, false)")
        );
        multimode.setLeaf(leafRules);
        questionnaire.setMultimode(multimode);
        JSONSerializer serializer = new JSONSerializer(true);
        String result = serializer.serialize(questionnaire);
        String expectedJson = """
				{
				  "multimode": {
                          "questionnaire": {
                              "rules": [
                                  {
                                      "name": "IS_MOVED",
                                      "type": "VTL",
                                      "value": "nvl(HABITEZ_VOUS_ICI, true)"
                                  }
                              ]
                          },
                          "leaf": {
                              "rules": [
                                  {
                                      "name": "IS_MOVED",
                                      "type": "VTL",
                                      "value": "nvl(PRENOM_HABITE_PLUS_LA, false)"
                                  }
                              ]
                          }
                      }
				}
				""";
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeMultimode() throws JAXBException {
        String json = """
				{
				  "multimode": {
                          "questionnaire": {
                              "rules": [
                                  {
                                      "name": "IS_MOVED",
                                      "type": "VTL",
                                      "value": "nvl(HABITEZ_VOUS_ICI, true)"
                                  }
                              ]
                          },
                          "leaf": {
                              "rules": [
                                  {
                                      "name": "IS_MOVED",
                                      "type": "VTL",
                                      "value": "nvl(PRENOM_HABITE_PLUS_LA, false)"
                                  }
                              ]
                          }
                      }
				}
				""";
        JSONDeserializer deserializer = new JSONDeserializer();
        Questionnaire questionnaire = deserializer.deserializeString(json);

        // Questionnaire rules
        assertEquals(1, questionnaire.getMultimode().getQuestionnaire().getRules().size());
        Rule questionnaireRule = questionnaire.getMultimode().getQuestionnaire().getRules().getFirst();
        assertEquals(MultimodeRuleNameEnum.IS_MOVED, questionnaireRule.getName());
        assertEquals(ValueTypeEnum.VTL, questionnaireRule.getType());
        assertEquals("nvl(HABITEZ_VOUS_ICI, true)", questionnaireRule.getValue());

        // Leaf rules
        assertEquals(1, questionnaire.getMultimode().getLeaf().getRules().size());
        Rule leafRule = questionnaire.getMultimode().getLeaf().getRules().getFirst();
        assertEquals(MultimodeRuleNameEnum.IS_MOVED, leafRule.getName());
        assertEquals(ValueTypeEnum.VTL, leafRule.getType());
        assertEquals("nvl(PRENOM_HABITE_PLUS_LA, false)", leafRule.getValue());
    }
}
