In this repository , I have created three services. 

* account service
* transaction service
* statement service

All three services are spring boot application and it will be in separate repository in real scenario.


The Account service is running on port 8091, 
http://localhost:8091/accountservice/account?id=234


The statement service is running on port 8092,
http://localhost:8092/statementservice/statement?id=234

The transaction service is running on port 8093,
http://localhost:8093/transactionservice/transaction?id=234


The account service is consuming statement service ( using Webclient) for statement data and also consuming
transaction service for transaction data using Rest template. 


