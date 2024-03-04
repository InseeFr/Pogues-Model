package fr.insee.pogues.test.questionnaire;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HelloTest {
    @Getter
    @Setter
    static class QuestionnaireFoo {
        @JsonProperty("CodeLists")
        protected CodeListsFoo codeListsFoo;
    }
    @Getter @Setter
    static class CodeListsFoo {
        @JsonProperty("CodeList")
        protected List<CodeListFoo> codeListFoo;
        public CodeListsFoo() {
            codeListFoo = new ArrayList<>();
        }
    }
    @Getter @Setter
    static class CodeListFoo {
        @JsonProperty(required = true)
        @JacksonXmlProperty(isAttribute = true)
        protected String id;
        @JsonProperty(value = "Name", required = true)
        protected String name;
        @JsonProperty("Code")
        protected List<String> someStrings;
        public CodeListFoo() {
            someStrings = new ArrayList<>();
        }
    }
    @Test
    void serializeXml() throws JsonProcessingException {
        QuestionnaireFoo questionnaireFoo = new QuestionnaireFoo();
        CodeListsFoo codeListsFoo = new CodeListsFoo();
        CodeListFoo codeListFoo1 = new CodeListFoo();
        codeListFoo1.setId("id1");
        codeListFoo1.setName("baz1");
        CodeListFoo codeListFoo2 = new CodeListFoo();
        codeListFoo2.setId("id2");
        codeListFoo2.setName("baz2");
        codeListsFoo.getCodeListFoo().add(codeListFoo1);
        codeListsFoo.getCodeListFoo().add(codeListFoo2);
        questionnaireFoo.setCodeListsFoo(codeListsFoo);
        String result = XmlMapper.builder().defaultUseWrapper(false).build().writeValueAsString(questionnaireFoo);
        assertNotNull(result);
    }
    @Test
    void deserializeXml() throws JsonProcessingException {
        String xmlString = """
                <Questionnaire>
				<CodeLists>
				<CodeList id="toto">
				</CodeList>
				</CodeLists>
				</Questionnaire>""";
        QuestionnaireFoo questionnaireFoo = XmlMapper.builder().defaultUseWrapper(false).build().readValue(xmlString, QuestionnaireFoo.class);
        //assertEquals(2, questionnaireFoo.getCodeListsFoo().getCodeListFooList().size());
    }
}
