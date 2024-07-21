
# Project Learning Navigator

A RESTful API service using Spring Boot to manage a Learning Management System while using MySQL to persist the data. This project is designed for a service for managing the exam registration service.

## Project Features

The APIs handles the CRUD operations for Students, Subjects, and Exams.

- **CRUD operations** -- CRUD operations handles the basic features like create, delete, update and read for all Students, Subjects, and Exams.
- **Exam Registration Logic** -- Students can register for the exam only after enrolling in the corresponding subject.
- **Error handling** -- Handle common errors gracefully and return appropriate HTTP codes.
- **Global Exception Handle** -- Use GlobalExceptionHandler and @ControllerAdvice to organize and streamline Exception Handling
- **Easter Egg Feature** -- Generate a fact about the number which is passed as the path parameter through the [Numbers API](http://numbersapi.com) documentation


## API EndPoints

#### For Exam Module:-
- **GET /exams** - Retrieve a list of all exams.
- **GET /exams/{id}** - Retrieve the details of a specific exam.
- **POST /exams** - Create a new exam.
- **DELETE /exams/{id}** - Delete the specific exam.

#### For Student Module:-
- **GET /student** - Retrieve a list of all students.
- **GET /student/{id}** - Retrieve the details of a specific student.
- **POST /student** - Create a new student.
- **DELETE /student/{id}** - Delete the specific student.
- **PUT /student/{studentid}/exam/{examid}** - Update the exam list for the specific student with specific examid.
- **PUT /student/{studentid}/subject/{subjectid}** - Update the subject list for the specific student with specific subjectid.

#### For Subject Module:-
- **GET /subject** - Retrieve a list of all subjects.
- **GET /subject/{id}** - Retrieve the details of a specific subject.
- **POST /subject** - Create a new subject.
- **DELETE /subject/{id}** - Delete the specific subject.

#### Easter Egg Feature:-
- **GET /hidden-feature/{number}** -  Generate a fact about the number which is passed as the path parameter from Numbers API documentation.


### Installation Prequisite

- Java 17 or higher
- MySQL workbench
- PostMan to test the APIs

## Getting Started

#### Clone this project to your local system.

```bash
  git clone https://github.com/sbarman7593/LearningNav.git
```
#### Go to the path LearningNav.

```bash
  cd LearningNav
```
#### Configure the application.properties file with below lines to connect with your MySQL DB

```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/learningnav?useSSL=false
    spring.datasource.username= <give the username to connect with the DB>
    spring.datasource.password= <give the password for your specific username>
```

#### Build the project using below command, or run the project from CoderHackApplication main class.

```bash
  ./gradlew bootrun
```
