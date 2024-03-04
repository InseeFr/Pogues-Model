package fr.insee.pogues.test;

import fr.insee.pogues.conversion.XmlDeserializer;
import fr.insee.pogues.conversion.XmlSerializer;
import fr.insee.pogues.exception.XmlDeserializationException;
import fr.insee.pogues.exception.XmlSerializationException;
import fr.insee.pogues.mock.CodeListFactory;
import fr.insee.pogues.mock.QuestionnaireFactory;
import fr.insee.pogues.mock.SequenceFactory;
import fr.insee.pogues.model.*;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.xmlunit.assertj3.XmlAssert;

import java.io.ByteArrayInputStream;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class XmlSerializerTest {

	@Test
	void testQuestionnaire() throws Exception {

		QuestionnaireFactory factory = new QuestionnaireFactory();
		Questionnaire fakeQuestionnaire = factory.createQuestionnaire();

		long startTime = System.currentTimeMillis();

		XmlSerializer serializer = new XmlSerializer();
		String xmlQuestionnaire = serializer.serialize(fakeQuestionnaire);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/questionnaire-ser.xml"), xmlQuestionnaire, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
		assertNotNull(xmlQuestionnaire);
	}

	@Test
	void testSequence() throws Exception {

		SequenceFactory factory = new SequenceFactory();
		SequenceType fakeSequence = factory.createSequence(2);

		long startTime = System.currentTimeMillis();

		XmlSerializer serializer = new XmlSerializer();
		String xmlSequence = serializer.serialize(fakeSequence);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/sequence-ser.xml"), xmlSequence, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
		assertNotNull(xmlSequence);
	}

	@Test
	void testCodeList() throws Exception {

		CodeListFactory factory = new CodeListFactory();
		CodeList fakeCodeList = factory.createCodeList();

		long startTime = System.currentTimeMillis();

		XmlSerializer serializer = new XmlSerializer();
		String xmlCodeList = serializer.serialize(fakeCodeList);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/codelist-ser.xml"), xmlCodeList, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
		assertNotNull(xmlCodeList);
	}

	@Test
	void testCodeLists() throws Exception {

		CodeListFactory factory = new CodeListFactory();
		CodeLists fakeCodeLists = factory.createCodeLists();

		long startTime = System.currentTimeMillis();

		XmlSerializer serializer = new XmlSerializer();
		String xmlCodeLists = serializer.serialize(fakeCodeLists);

		long elapsedTime = System.currentTimeMillis() - startTime;

		FileUtils.writeStringToFile(new File("src/test/resources/codelists-ser.xml"), xmlCodeLists, "UTF-8");
		System.out.println("Serialization time: " + elapsedTime);
		assertNotNull(xmlCodeLists);
	}

	@Test
	void serializeCodeList() throws XmlSerializationException {
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
		XmlSerializer xmlSerializer = new XmlSerializer();
		String result = xmlSerializer.serialize(codeList);
		// Then
		String expectedXml = """
				<?xml version="1.0" encoding="UTF-8"?>
				<CodeList id="code-list-id">
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

	@Test
	void serializeCodeListFromQuestionnaire() throws XmlSerializationException, XmlDeserializationException {
		// Given
		Questionnaire questionnaire = new Questionnaire();
		CodeLists codeLists = new CodeLists();
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
		codeLists.getCodeList().add(codeList);
		questionnaire.setCodeLists(codeLists);
		// When
		XmlSerializer xmlSerializer = new XmlSerializer();
		String result = xmlSerializer.serialize(questionnaire);
		// Then xmlns="http://xml.insee.fr/schema/applis/pogues"
		String expectedXml = """
				<Questionnaire type="Questionnaire">
				<CodeLists>
				<CodeList id="code-list-id">
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
				</CodeList>
				</CodeLists>
				</Questionnaire>""";
		new XmlDeserializer().deserialize(new ByteArrayInputStream(expectedXml.getBytes()));
		XmlAssert.assertThat(result).and(expectedXml).ignoreWhitespace().areIdentical();
	}

}
