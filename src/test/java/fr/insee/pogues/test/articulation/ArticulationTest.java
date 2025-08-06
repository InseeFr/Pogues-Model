package fr.insee.pogues.test.articulation;

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


class ArticulationTest {

    private Item createItem(String label, ValueTypeEnum type, String value){
        Item item = new Item();
        item.setLabel(label);
        item.setType(type);
        item.setValue(value);
        return item;
    }

    @Test
    void serializeArticulation() throws JAXBException, UnsupportedEncodingException, JSONException {
        Questionnaire questionnaire = new Questionnaire();
        Articulation articulation = new Articulation();
        articulation.getItems().add(createItem("Prénom", ValueTypeEnum.VTL_MD, "**PRENOMS**"));
        articulation.getItems().add(createItem("Sexe", ValueTypeEnum.VTL, "if SEXE = \"H\" then \"Homme\" else \"Femme\""));
        articulation.getItems().add(createItem("Age", ValueTypeEnum.VTL, "cast(AGE, string) || \" ans\""));
        questionnaire.setArticulation(articulation);
        JSONSerializer serializer = new JSONSerializer(true);
        String result = serializer.serialize(questionnaire);
        String expectedJson = """
				{
				  "articulation": {
                    "items": [
                        {
                            "label": "Prénom",
                            "type": "VTL|MD",
                            "value": "**PRENOMS**"
                        },
                        {
                            "label": "Sexe",
                            "type": "VTL",
                            "value": "if SEXE = \\"H\\" then \\"Homme\\" else \\"Femme\\""
                        },
                        {
                            "label": "Age",
                            "type": "VTL",
                            "value": "cast(AGE, string) || \\" ans\\""
                        }
                    ]
                  }
				}
				""";
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeArticulation() throws JAXBException {
        String json = """
				{
				  "articulation": {
                    "items": [
                        {
                            "label": "Prénom",
                            "type": "VTL|MD",
                            "value": "**PRENOMS**"
                        },
                        {
                            "label": "Sexe",
                            "type": "VTL",
                            "value": "if SEXE = \\"H\\" then \\"Homme\\" else \\"Femme\\""
                        },
                        {
                            "label": "Age",
                            "type": "VTL",
                            "value": "cast(AGE, string) || \\" ans\\""
                        }
                    ]
                  }
				}
				""";
        JSONDeserializer deserializer = new JSONDeserializer();
        Questionnaire questionnaire = deserializer.deserializeString(json);
        assertEquals(3, questionnaire.getArticulation().getItems().size());
        Item thirdItem = questionnaire.getArticulation().getItems().get(2);
        assertEquals("Age", thirdItem.getLabel());
        assertEquals(ValueTypeEnum.VTL, thirdItem.getType());
        assertEquals("cast(AGE, string) || \" ans\"", thirdItem.getValue());
    }
}
