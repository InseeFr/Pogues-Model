package fr.insee.pogues.test;

import fr.insee.pogues.conversion.XMLSerializer;
import fr.insee.pogues.mock.CodeListFactory;
import fr.insee.pogues.mock.QuestionnaireFactory;
import fr.insee.pogues.mock.SequenceFactory;
import fr.insee.pogues.model.*;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.xmlunit.assertj3.XmlAssert;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.UnsupportedEncodingException;

class XMLSerializerTest {

	@Test
	void testQuestionnaire() throws Exception {

		QuestionnaireFactory factory = new QuestionnaireFactory();
		Questionnaire fakeQuestionnaire = factory.createQuestionnaire();

		long startTime = System.currentTimeMillis();

		XMLSerializer serializer = new XMLSerializer();
		String xmlQuestionnaire = serializer.serialize(fakeQuestionnaire);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/questionnaire-ser.xml"), xmlQuestionnaire, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testSequence() throws Exception {

		SequenceFactory factory = new SequenceFactory();
		SequenceType fakeSequence = factory.createSequence(2);

		long startTime = System.currentTimeMillis();

		XMLSerializer serializer = new XMLSerializer();
		String xmlSequence = serializer.serialize(fakeSequence);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/sequence-ser.xml"), xmlSequence, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testCodeList() throws Exception {

		CodeListFactory factory = new CodeListFactory();
		CodeList fakeCodeList = factory.createCodeList();

		long startTime = System.currentTimeMillis();

		XMLSerializer serializer = new XMLSerializer();
		String xmlCodeList = serializer.serialize(fakeCodeList);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/codelist-ser.xml"), xmlCodeList, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void testCodeLists() throws Exception {

		CodeListFactory factory = new CodeListFactory();
		CodeLists fakeCodeLists = factory.createCodeLists();

		long startTime = System.currentTimeMillis();

		XMLSerializer serializer = new XMLSerializer();
		String xmlCodeLists = serializer.serialize(fakeCodeLists);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/codelists-ser.xml"), xmlCodeLists, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
	}

	@Test
	void serializeCodeList() throws JAXBException, UnsupportedEncodingException, JSONException {
		// Given
		CodeList codeList = new CodeList();
		codeList.setId("code-list-id");
		codeList.setName("CODE_LIST_NAME");
		codeList.setLabel("Code list label.");
		CodeType code1 = new CodeType();
		code1.setLabel("CODE_1");
		code1.setValue("1");
		CodeType code2 = new CodeType();
		code2.setLabel("CODE_2");
		code2.setValue("2");
		codeList.getCode().add(code1);
		codeList.getCode().add(code2);
		// When
		XMLSerializer xmlSerializer = new XMLSerializer();
		String result = xmlSerializer.serialize(codeList);
		// Then
		String expectedXml = """
				<?xml version="1.0" encoding="UTF-8"?>
				<CodeList xmlns="http://xml.insee.fr/schema/applis/pogues" id="code-list-id">
				  <Name>CODE_LIST_NAME</Name>
				  <Label>Code list label.</Label>
				  <Code>
				    <Value>1</Value>
				    <Label>CODE_1</Label>
				  </Code>
				  <Code>
				    <Value>2</Value>
				    <Label>CODE_2</Label>
				  </Code>
				</CodeList>""";
		XmlAssert.assertThat(result).and(expectedXml).ignoreWhitespace().areIdentical();
	}

}
