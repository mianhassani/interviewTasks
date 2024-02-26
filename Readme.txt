
This application uses Spring Boot to automate the process of importing the customer data from a CSV file, path to which is given as an argument through the command line when running the application. The application reads the data from the CSV file, creates ‘Customer’ objects from them and then pushes the data to the into a PostgreSQL database via a REST API.

Components
1-	Entity Class (Customer):
Represents the data model for customers, including attributes such as customer reference, name, address, etc.
2-	Repository Interface (CustomersRepository):
Provides CRUD operations for the Customer entity, utilizing Spring Data JPA to interact with the PostgreSQL database.
3-	Service Layer (CustomerService):
Implements business logic for managing customer data, including adding customers and retrieving customer information by reference.
4-	REST Controller (Controller):
Defines REST endpoints for adding customers (/customers/add) and retrieving customers by reference (/customers/{customerRef}).
5-	CSV Service (CSVService):
Handles the reading of a CSV file containing customer data, parsing its contents, and sending each row to the REST API endpoint for storage in the database.
6-	Configuration:
Configures the PostgreSQL database connection properties in the application.properties file.

Implementation Details
1-	Entity and Repository Setup:
An entity class (Customer) is defined to represent customer data, with corresponding annotations for entity mapping.
A repository interface (CustomersRepository) extends JpaRepository to enable database interactions for the Customer entity.
To visualize the data being added to the database, PGAdmin software was downloaded as it provides a nice GUI.
2-	Service and Controller Implementation:
CustomerService encapsulates the business logic for managing customer data, including CRUD operations. A RestTemplate bean was also created at start up to make a Post request to the addCustomers endpoint to populate the database.
Controller defines REST endpoints for adding and retrieving customers, delegating functionality to the CustomerService.
3-	CSV Data Processing:
CSVService is responsible for reading the CSV file, parsing its contents, and sending each row to the REST API endpoint for storage.
4-	Database Configuration:
Connection properties for the PostgreSQL database are specified in the application.properties file, including URL, username, password, and Hibernate configuration.

Testing Approach
Unit tests are developed for each component using Mockito and JUnit, adhering to the principles of Test-Driven Development (TDD).
Test cases cover various scenarios, including successful data insertion, error handling, and endpoint validation.

Furthermore, the Controller and the data entry aspects of the application were also tested using Postman.
Conclusion
This project showcases the implementation of an automated data import system using Spring Boot, PostgreSQL, and RESTful APIs. By following a structured approach to development and testing, the application ensures reliability, scalability, and maintainability, offering a robust solution for managing customer data effectively.

