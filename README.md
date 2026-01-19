# Pogues

Navigation: [Client][1] | [Back-office][2] | **Pogues model**

[1]: https://github.com/InseeFr/Pogues
[2]: https://github.com/InseeFr/Pogues-Back-Office

## Introduction

Pogues is a tool that allow to design questionnaires with components that are structural (sequences, questions...) and dynamic (filters, controls, loops...).

This repository hosts the Pogues questionnaire model which then generates classes and converter.

The model has its own [documentation](./src/main/resources/xsd/Questionnaire.xsd) that describe its attributes, and some features have additional [explanations](./docs) in `/docs`.

## Implementation

The Pogues questionnaire model is specified as an XML Schema in [Questionnaire.xsd](./src/main/resources/xsd/Questionnaire.xsd).

The schema is transformed into Java classes with the JAXB compiler. The JAXB classes are then packaged with other components to produce a REST web service and an XQuery module ready to be installed in eXist.

The JAXB compilation and the packaging tasks are executed by Maven.

This repository contains the schema, the support classes for creating the web service and the XQuery module, and other useful classes like conversion tools and classes for generating mock questionnaires.
