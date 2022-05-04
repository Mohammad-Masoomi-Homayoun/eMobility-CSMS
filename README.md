# hst-to-be
## eMobility assignment

### Description
This project is a simple implementation of the eMobility assignment.

## How to run
``mvn spring-boot:run``

## Test service
```
curl --location --request POST 'localhost:8000/rate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "rate": {
        "energy": 0.3,
        "time": 2,
        "transaction": 1
        },
    "cdr": {
        "meterStart": 1204307,
        "timestampStart": "2021-04-05T10:04:00Z",
        "meterStop": 1215230,
        "timestampStop": "2021-04-05T11:27:00Z"
}
}'
```