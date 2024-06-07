# EMS-Back

## Introduction
**EMS-Back** is a backend service built with Java and Spring Boot, designed to power an Employee Management System (EMS). This service handles all business logic, database interactions, and API endpoints necessary for managing employee data, and roles.

## Features
- **Employee Management**: CRUD operations for employee data.
- **Role Management**: Assign and manage roles.

## Technologies Used
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MySQL** (or any other relational database)
- **Maven**

## Installation
To set up the project locally, follow these steps:

1. **Clone the repository**
    ```bash
    git clone https://github.com/urielsmp128/EMS-Back.git
    ```
2. **Navigate to the project directory**
    ```bash
    cd EMS-Back
    ```
3. **Configure the database**
   - Update the `application.properties` file in the `src/main/resources` directory with your database settings.
4. **Build the project**
    ```bash
    ./mvnw clean install
    ```
5. **Run the application**
    ```bash
    ./mvnw spring-boot:run
    ```

## Usage
Once the application is running, it listens on port `8080` by default. You can interact with the backend API using tools like Postman or through the frontend application.

## API Endpoints
Here are some key API endpoints:

- **Employee Management**
  - `GET /api/employees` - Get all employees
  - `POST /api/employees` - Create a new employee
  - `GET /api/employees/{id}` - Get employee by ID
  - `PUT /api/employees/{id}` - Update employee by ID
  - `DELETE /api/employees/{id}` - Delete employee by ID

## Contributing
We welcome contributions to enhance the project. Here’s how you can help:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a Pull Request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For any inquiries or feedback, please contact:
- **Uriel SMP** - [urielsmp128@example.com](mailto:urielsmp128@example.com)

---
