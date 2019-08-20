## API URLs

### 1. "http://localhost:8088/intializeAccounts"
###### RequestMethod: GET
###### Produces: JSON
###### Response Body:
    [{
        "accountId": 1,
        "customer": {
            "customerId": 1,
            "name": "cust1"
        },
        "balance": 100
    },
    {
        "accountId": 2,
        "customer": {
            "customerId": 2,
            "name": "cust2"
        },
        "balance": 0
    },
    {
        "accountId": 3,
        "customer": {
            "customerId": 3,
            "name": "Customer 3"
        },
        "balance": 2300
    }]

### 2. "http://localhost:8088/fetchAllAccounts"
###### RequestMethod: GET
###### Produces: JSON
###### Response Body:
    [{
        "accountId": 1,
        "customer": {
            "customerId": 1,
            "name": "cust1"
        },
        "balance": 100
    },
    {
        "accountId": 2,
        "customer": {
            "customerId": 2,
            "name": "cust2"
        },
        "balance": 0
    },
    {
        "accountId": 3,
        "customer": {
            "customerId": 3,
            "name": "Customer 3"
        },
        "balance": 2300
    }]

### 3. "http://localhost:8088/fetchAllCustomers"
###### RequestMethod: GET
###### Produces: JSON
###### Response Body:
    [{
        "customerId": 1,
        "name": "cust1"
    },
    {
        "customerId": 2,
        "name": "cust2"
    },
    {
        "customerId": 3,
        "name": "Customer 3"
    }]

### 4. "http://localhost:8088/addAccount"
###### RequestMethod: POST
###### Produces: JSON
###### Request Body:
    {
        "accountID": 6,
        "customer": {
            "customerID": 6,
            "name": "cust6"
        },
        "balance": 500
    }

###### Response Body:
    [{
        "customerId": 1,
        "name": "cust1"
    },
    {
        "customerId": 2,
        "name": "cust2"
    },
    {
        "customerId": 3,
        "name": "Customer 3"
    }]

### 5. "http://localhost:8088/getAccountBalance/{AccountNumber}"
###### RequestMethod: GET
###### Produces: JSON
###### Response Body:
    {
        "accountId": 1,
        "customer": {
            "customerId": 1,
            "name": "cust1"
        },
        "balance": 100
    }

### 6. "http://localhost:8088/transferFunds"
###### RequestMethod: POST
###### Produces: JSON
###### Request Body:
    {
        "fromAccount" : 3,
        "toAccount" : 2,
        "amount": 50
    }
###### Response Body(Success):
    SUCCESS
###### Response Body(Invalid Account Number):
    ID MISATCH
###### Response Body(Insufficient Funds):
    INSUFFICIENT FUNDS
