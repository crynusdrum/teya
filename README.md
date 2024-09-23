# Tiny Bank Assessment 2.0


# About the project


From a functional perspective, the following features should be implemented:
- Creation and deactivation of users.
- Ability for users to deposit/withdraw money from their accounts.
- Ability for users to transfer money to another user's account.
- View account balances.
- View transaction history.

From a technical perspective:
- We expect you to deliver a functional web application that can be run
  locally.
- You can use any programming language and framework of your choice
  (although we would prefer if you used Java or Go).
- The application should use in memory storage (eg: maps or dictionaries),
  and it should not be necessary to install any database software to run it.

You are free to make assumptions whenever you feel it is necessary, but please
document them.
Please try to keep it simple. The objective is to understand your approach to
problems and your thought process rather than a test of your technical
knowledge, even if it means having to make trade-offs.

# Technologies used
## Backend
- Java 21
- Spring Boot 3
- JPA / Hibernate
- Maven
- Database H2


Prerequisites:
- Java 21
- Spring Boot 3


OBS:
- There is no frontend.
- It's not necessary to create anythhing because it is using a H2 memory configured with import file data.


# How to use
## Run the project
```bash
# Github repository
git clone https://github.com/crynusdrum/teya.git

# get into project folder
cd teya

# run the project
./mvnw spring-boot:run
```
## Examples of the features - Tutorial

1. Get the collection "Teya.postman_collection.json" from the project and import it to the postman

**Create user - Example**

`curl --location 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data '{
"username":  "username1"
}'`

**Deactivate user - Example**

`curl --location 'http://localhost:8080/users/1/status' \
--header 'Content-Type: application/json' \
--data '{
"username":  "username1"
}'`

**Create account - Example**

`curl --location 'http://localhost:8080/accounts/users/1?accountName=accountName1' \
--header 'Content-Type: application/json' \
--data '{
"accountName":  "accountName2",
"balance":  "200.0"
}'`

**Retrieve accounts - Example**

`curl --location --request GET 'http://localhost:8080/accounts' \
--header 'Content-Type: application/json' \
--data '{
"description":  "description"
}'`






```

# Autor

Thiago Baldês
