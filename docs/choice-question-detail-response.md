# Detail response in choice questions

A unique choice question or multiple choice question can have a _detail response_ ("Please, specify") attached to one 
of its modality.

This is represented by a `"ClarificationQuestion"`. The link between the detail response and its modality is 
described using a magic formula in a `"FlowControl""` description with this syntax: 
`"$MODALITY_VARIABLE$ = '1' : DETAIL_VARIABLE"` (see examples below).

## Unique choice question

_todo_

## Multiple choice question

Example: boolean multiple choice question with 2 modalities. The _detail response_ ("Please specify") is attached to 
the 2nd modality.

```json
{
    "id": "question-id",
    "questionType": "MULTIPLE_CHOICE",
    "type": "QuestionType",
    "Name": "MCQ_WITH_DETAIL",
    "Label": [
        "\"Multiple choice question, with 'please specify'\""
    ],
    "Declaration": [],
    "Control": [],
    "FlowControl": [
        {
            "id": "clarification-flow-control-id",
            "flowControlType": "CLARIFICATION",
            "Description": "$MCQ_WITH_DETAIL2$ = '1' : MCQ_WITH_DETAIL2CL",
            "Expression": "$MCQ_WITH_DETAIL2$ = '1'",
            "IfTrue": "detail-question-id"
        }
    ],
    "TargetMode": [
        "CAPI",
        "CAWI",
        "CATI",
        "PAPI"
    ],
    "Response": [
        {
            "id": "response-1-id",
            "Datatype": {
                "typeName": "BOOLEAN",
                "type": "BooleanDatatypeType"
            },
            "CollectedVariableReference": "boolean-var-1-id"
        },
        {
            "id": "response-2-id",
            "Datatype": {
                "typeName": "BOOLEAN",
                "type": "BooleanDatatypeType"
            },
            "CollectedVariableReference": "boolean-var-2-id"
        }
    ],
    "ResponseStructure": {
        "Dimension": [
            {
                "dimensionType": "PRIMARY",
                "dynamic": "NON_DYNAMIC",
                "CodeListReference": "some-code-list-id"
            },
            {
                "dimensionType": "MEASURE"
            }
        ],
        "Attribute": [],
        "Mapping": [
            {
                "MappingSource": "response-1-id",
                "MappingTarget": "1"
            },
            {
                "MappingSource": "response-2-id",
                "MappingTarget": "2"
            }
        ]
    },
    "ClarificationQuestion": [
        {
            "id": "detail-question-id",
            "questionType": "SIMPLE",
            "Name": "MCQ_WITH_DETAIL2CL",
            "Label": [
                "\"Please, specify: \""
            ],
            "TargetMode": [
                "CAPI",
                "CAWI",
                "CATI",
                "PAPI"
            ],
            "Response": [
                {
                    "id": "detail-response-id",
                    "mandatory": false,
                    "Datatype": {
                        "typeName": "TEXT",
                        "type": "TextDatatypeType",
                        "MaxLength": 249
                    },
                    "CollectedVariableReference": "detail-variable-id"
                }
            ]
        }
    ],
    "codeFilters": []
}
```
