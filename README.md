# Service-Request-Assignment
## Local Setup
- Install Postgres, configure it to run on port 5432.
- Create DB with name 'serviceapi_db'
- Create Tables in the db as mentioned in resoureces/tables.sql file.
- run 
```bash
mvn clean install
```
- run the main method of the project in ``` class ServiceRequestAssignmentApplication ```
- go to http://localhost:8080/swagger-ui.html
- first create ServiceDefinition Object then create Service Object for the ServiceDefinitionId
