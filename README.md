# To-Do Application Backend

A Spring Boot-based backend for managing tasks in a To-Do application.

## Features
- Add, update, delete, and retrieve tasks
- Mark tasks as completed

## Prerequisites
- Java 21
- Maven

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/T-Luxshan/ToDoBackend.git
   cd todo-backend

## API Endpoints

| Method | Endpoint          | Description               | Request Body Example              | Response Example                  |
|--------|-------------------|---------------------------|------------------------------------|------------------------------------|
| GET    | `/tasks`          | Fetch all tasks           | _None_                             | `[{"id":1,"task":"Test Task","completed":false}]` |
| POST   | `/tasks`          | Add a new task            | `{"task": "New Task", "completed": false}` | `{"id":1,"task":"New Task","completed":false}` |
| PATCH  | `/tasks/{id}`     | Update task details       | `{"task": "Updated Task", "completed": true}` | `{"id":1,"task":"Updated Task","completed":true}` |
| DELETE | `/tasks/{id}`     | Delete a task by ID       | _None_                             | `{"message": "Task deleted successfully"}` |
