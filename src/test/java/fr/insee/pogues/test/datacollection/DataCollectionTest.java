package fr.insee.pogues.test.datacollection;

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
import static org.junit.jupiter.api.Assertions.assertNull;


class DataCollectionTest {

    private Serie createSerie(){
        Serie serie = new Serie();
        serie.setId("s001");
        serie.setLabel("s001" +" - serie label");
        serie.setAltLabel("s001".toUpperCase()+"_ALT_LABEL");
        serie.setUri("http://id.insee.fr/serie/"+ "s001");
        return serie;
    }

    @Test
    void serializeDataCollection() throws JAXBException, UnsupportedEncodingException, JSONException {
        Questionnaire questionnaire = new Questionnaire();
        DataCollection dataCollection = new DataCollection();

        Serie serie = createSerie();
        dataCollection.setSerie(serie);
        questionnaire.setDataCollection(dataCollection);
        JSONSerializer serializer = new JSONSerializer(true);
        String result = serializer.serialize(questionnaire);
        String expectedJson = """
                {
                     "DataCollection": {
                         "serie": {
                             "id": "s001",
                             "uri": "http://id.insee.fr/serie/s001",
                             "label": "s001 - serie label",
                             "altLabel": "S001_ALT_LABEL"
                         }
                     }
                 }
				""";
        JSONAssert.assertEquals(expectedJson, result, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeDataCollection() throws JAXBException {
        String json = """
				{
                     "DataCollection": {
                         "serie": {
                             "id": "s001",
                             "uri": "http://id.insee.fr/serie/s001",
                             "label": "s001 - serie label",
                             "altLabel": "S001_ALT_LABEL"
                         }
                     }
                 }
				""";
        JSONDeserializer deserializer = new JSONDeserializer();
        Questionnaire questionnaire = deserializer.deserializeString(json);

        Serie serie = questionnaire.getDataCollection().getSerie();

        assertEquals("s001", serie.getId());
        assertEquals("http://id.insee.fr/serie/s001", serie.getUri());
        assertEquals("s001 - serie label", serie.getLabel());
        assertEquals("S001_ALT_LABEL", serie.getAltLabel());
    }

    @Test
    public void deserializeOldDataCollection_do_not_throw_error() throws JAXBException {
        String json = """
				{
                     "DataCollection": [
                        {
                            "id": "s2193-dc",
                            "uri": "http://ddi:fr.insee:DataCollection.s2193-dc"
                        }
                     ]
                 }
				""";
        JSONDeserializer deserializer = new JSONDeserializer();
        Questionnaire questionnaire = deserializer.deserializeString(json);
        assertNull(questionnaire.getDataCollection().getSerie());
    }
}
