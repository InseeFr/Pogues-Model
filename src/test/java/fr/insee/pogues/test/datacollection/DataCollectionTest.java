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

    private Operation createOperation(String id){
        Operation operation = new Operation();
        operation.setId(id);
        operation.setUri("http://id.insee.fr/operation/"+id);
        operation.setLabel(id +" - operation label");
        return operation;
    }

    @Test
    void serializeDataCollection() throws JAXBException, UnsupportedEncodingException, JSONException {
        Questionnaire questionnaire = new Questionnaire();
        DataCollection dataCollection = new DataCollection();

        Serie serie = createSerie();
        dataCollection.getOperations().add(createOperation("op-1"));
        dataCollection.getOperations().add(createOperation("op-2"));
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
                         },
                         "operations": [
                             {
                                 "id": "op-1",
                                 "uri": "http://id.insee.fr/operation/op-1",
                                 "label": "op-1 - operation label"
                             },
                             {
                                 "id": "op-2",
                                 "uri": "http://id.insee.fr/operation/op-2",
                                 "label": "op-2 - operation label"
                             }
                         ]
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
                         },
                         "operations": [
                             {
                                 "id": "op-1",
                                 "uri": "http://id.insee.fr/operation/op-1",
                                 "label": "op-1 - operation label"
                             },
                             {
                                 "id": "op-2",
                                 "uri": "http://id.insee.fr/operation/op-2",
                                 "label": "op-2 - operation label"
                             }
                         ]
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

        assertEquals(2, questionnaire.getDataCollection().getOperations().size());
        Operation secondOpe = questionnaire.getDataCollection().getOperations().get(1);
        assertEquals("op-2", secondOpe.getId());
        assertEquals("op-2 - operation label", secondOpe.getLabel());
        assertEquals("http://id.insee.fr/operation/op-2", secondOpe.getUri());
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
        assertEquals(0, questionnaire.getDataCollection().getOperations().size());
    }
}
