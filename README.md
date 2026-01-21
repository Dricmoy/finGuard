

Planned java backend services at a glance:
| Service            | Input                                     | Output                       | Main Logic                        | Exposed Endpoints                  |
|-------------------|------------------------------------------|-------------------------------|----------------------------------|-----------------------------------|
| Transaction API    | Raw transaction                           | Kafka `transactions`          | Validation & ingestion           | `POST /transactions`              |
| Risk Aggregator    | Kafka `fraud_scores` + LLM outputs + rules | Kafka `alerts` + DB           | Consolidates risk, triggers alerts | `GET /alerts`, `GET /transactions/:id` |
| Compliance Service | Risk Aggregator + raw rules + LLM narratives | Audit logs, regulatory flags | AML/KYC enforcement              | Audit endpoints, reporting        |