# Pogues model

Classes and converters for the Pogues questionnaire model.

## Introduction

The Pogues questionnaire model is specified as an XML Schema in the `Questionnaire.xsd` file.

The schema is transformed into Java classes with the JAXB compiler. The JAXB classes are then packaged with other components to produce a REST web service and an XQuery module ready to be installed in eXist.

The JAXB compilation and the packaging tasks are executed by Maven.

The "Pogues model" project contains the schema, the support classes for creating the web service and the XQuery module, and other useful classes like conversion tools and classes for generating mock questionnaires.

## Changing the model (short story)

Changing the model is done in two steps, that can also be realized in an IDE like Eclipse:
* modification of the schema
  * edit `src/main/resources/xsd/Questionnaire.xsd` to make the desired changes,
  * save the file.
* production of the output artifacts
  * open a command line at the project root and run `mvn package -DskipTests`
  * the rest service war file and XQuery module jar file should be produced in the `target` folder.

## Changing the model (longer story)

Most of the times, the simple procedure described above will result in a Maven build failure at the compilation step. This is because the changes on the model have to be reflected in the tools that use the generated JAXB classes corresponding to the model. For example, the mock classes use the setters of the JAXB objects, and the names of those setter methods are generated from the names of the elements and attributes in the schema.

Under Eclipse or equivalent, running the `generate-sources` Maven goal will show the compilation errors that are then easy to correct. If you just have the command line, you will have to run `mvn compile` and correct the errors reported one by one.

So the slightly longer story for changing the model is:

* modification of the schema
  * edit `src/main/resources/xsd/Questionnaire.xsd` to make the desired changes,
  * change the impacted Java classes accordingly
  * save the files.
* production of the output artifacts
  * open a command line at the project root and run `mvn package -DskipTests`
  * the rest service war file and XQuery module jar file should be produced in the `target` folder.
