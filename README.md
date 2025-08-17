Employee Management System 👨‍💼

This repository hosts a robust Employee Management System developed in Java, designed for streamlined deployment via Docker containers, and integrated with a phpMyAdmin database for intuitive data management.

✨ Features
Java Backend: A high-performance and scalable application built with Java.

Dockerized Deployment: The entire application is containerized using Docker, ensuring consistent, isolated, and portable environments for development, testing, and production.

phpMyAdmin Integration: Provides a user-friendly web interface for managing the underlying database, simplifying database interactions and administration.

Comprehensive Data Management: Efficiently stores, retrieves, updates, and deletes employee records, including personal details, contact information, job roles, and employment history.

CRUD Operations: Full support for Create, Read, Update, and Delete functionalities for all employee data.

🛠️ Technologies Used
Java: The core programming language for the backend logic.

Docker: For containerizing the application and its dependencies.

phpMyAdmin: A web-based administration tool for MySQL and MariaDB.

MySQL / MariaDB: The relational database used to store employee data.

🚀 Getting Started
Follow these steps to get the Employee Management System up and running on your local machine.

Prerequisites
Ensure you have the following installed:

Docker Desktop: Download Docker Desktop

📦 Setup and Run with Docker Compose
Clone the Repository:

git clone https://github.com/your-username/employee-management-system.git
cd employee-management-system

Build and Run Docker Containers:
This command will build the Java application image, set up the MySQL database, and launch phpMyAdmin, all orchestrated by Docker Compose.

docker-compose up --build -d

--build: Builds the images before starting containers (useful for the first run or after code changes).

-d: Runs the containers in detached mode (in the background).

Verify Running Containers:
You can check the status of your containers with:

docker-compose ps

You should see containers for your Java application, database, and phpMyAdmin.

📊 Database Setup (via phpMyAdmin)
Once your Docker containers are running, you can access phpMyAdmin to manage the database.

Access phpMyAdmin:
Open your web browser and navigate to http://localhost:8080 (or the port specified in your docker-compose.yml for phpMyAdmin).

Login to phpMyAdmin:

Username: root

Password: (Check your docker-compose.yml for the MYSQL_ROOT_PASSWORD environment variable for your database service. It might be root or a different value).

Create Database and Table:

Click on the "Databases" tab.

Create a new database (e.g., employee_db).

Select your newly created database.

Go to the "SQL" tab and execute the following SQL to create the employees table:

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(20),
    hire_date DATE,
    job_title VARCHAR(100),
    salary DECIMAL(10, 2)
);

💻 Usage
Access the Java Application:
The Java backend API will typically be exposed on a specific port (e.g., 8081 or 8080 depending on your docker-compose.yml). You can interact with it using tools like Postman, cURL, or a frontend application.

Example API Endpoint (adjust based on your Java application's routes):
http://localhost:8081/api/employees

API Endpoints (Examples):

GET /api/employees: Retrieve all employees.

GET /api/employees/{id}: Retrieve a specific employee by ID.

POST /api/employees: Add a new employee.

PUT /api/employees/{id}: Update an existing employee.

DELETE /api/employees/{id}: Delete an employee.

🤝 Contributing
Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/RiwmNCgJ)
