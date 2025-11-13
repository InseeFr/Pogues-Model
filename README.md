# Pogues Model

Classes and converters for the Pogues questionnaire model.

## Implementation

The Pogues questionnaire model is specified as an XML Schema in the `Questionnaire.xsd` file.

Path: `src/main/resources/xsd/Questionnaire.xsd` 

The schema is transformed into Java classes with the JAXB compiler. The JAXB classes are then packaged with other 
components to produce a REST web service and an XQuery module ready to be installed in eXist.

The JAXB compilation and the packaging tasks are executed by Maven.

The "Pogues model" project contains the schema, the support classes for creating the web service and the XQuery module, 
and other useful classes like conversion tools and classes for generating mock questionnaires.

## Model documentation

The way Pogues features are described in the model is documented in the [`docs`](./docs) folder.
