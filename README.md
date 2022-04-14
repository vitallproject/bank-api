# Spring Boot REST API

## Description:<br>
Service that looks like a bank.<br>

## Details:<br>
The ability to transfer money.<br>
Store all transaction data on local storage(PostgreSQL).<br>


## Features
- ##### Written Postman collection for testing


## Technologies
- ##### Java 17
- ##### Spring Boot (Web, Data JPA)
- ##### Lombok
- ##### Gradle
- ##### PostgreSQL
  
  
  

| Method   |     URL   |   Response    |
| ---      | ---       | ---
| GET      |     api/users      |      receiving all users        |
| GET     |     api/users/{identification}      |     receiving user      |
| POST      |     api/transaction/fund-transfer      |  fund transfer            |
| GET      |     api/account/bank-account/{account_number}     |      receiving bank account      |


### Database

<img width="1077" alt="Снимок экрана 2022-04-07 в 20 34 29" src="https://user-images.githubusercontent.com/81253629/162263057-bf0b7898-96c0-4e9d-9418-0a025ee1cfa7.png">



### Written Postman collection

<img width="1177" alt="Снимок экрана 2022-04-14 в 13 05 05" src="https://user-images.githubusercontent.com/81253629/163363810-e952ab83-bd00-499e-8ad4-476e103cc365.png">
<img width="1177" alt="Снимок экрана 2022-04-14 в 13 04 35" src="https://user-images.githubusercontent.com/81253629/163363669-89518578-626d-4b14-bb6f-b961f655b117.png">
