# Choice questions with variable options

## Unique choice question

A unique choice question or can have its options dynamically defined by the responses of a variable.

The variable that defines the options must be in an iteration, i.e. it must have the scope of a loop or dynamic table.

Example:

With a text question "What's your name?" (variable `NAME`) defined in a loop, it is possible to create a unique choice question whose options will be the reponses to the `NAME` variable : 

> Who's the best Mario Kart player?
> - ( ) Alex
> - ( ) Sam
> - ( ) Jordan

```json
{
  "id": "ucq-id",
  "type": "QuestionType",
  "questionType": "SINGLE_CHOICE",
  "Name": "UCQ_VARIABLE_OPTIONS",
  "Label": [
    "\"Who's the best Mario Kart player?\""
  ],
  "Response": [
    {
      "id": "ucq-response-id",
      "Datatype": {
        "typeName": "TEXT",
        "type": "TextDatatypeType",
        "visualizationHint": "RADIO",
        "MaxLength": 1
      },
      "choiceType": "VARIABLE",
      "VariableReference": "name-variable-id",
      "CollectedVariableReference": "ucq-variable-id"
    }
  ]
}
```

with variables:

```json
{
  "id": "name-variable-id",
  "type": "CollectedVariableType",
  "Name": "NAME",
  "Datatype": {
    "typeName": "TEXT",
    "type": "TextDatatypeType",
    "MaxLength": 50
  },
  "Scope": "loop-id"
},
{
  "id": "ucq-variable-id",
  "type": "CollectedVariableType",
  "Name": "UCQ_VARIABLE_OPTIONS",
  "Datatype": {
    "typeName": "TEXT",
    "type": "TextDatatypeType",
    "MaxLength": 1
  },
  "Scope": "loop-id",
  "VariableReference": "name-variable-id"
},
```

and `"loop-id"` being the identifier of some `"Iteration"`.


## Multiple choice question

To date, this feature is not supported for multiple choice questions.
