# Personal Finance Tracker with Budget Recommendations

Personal Finance Tracker is a full-stack web application designed to help users manage their finances. The app allows users to securely track their income and expenses, visualize financial trends over time, and receive personalized budget recommendations. It features a user-friendly dashboard, secure authentication, and intuitive data visualization.

## Features
### Core Features
- **User Authentication**: Secure login and registration using JSON Web Tokens (JWT) for authentication.
- **Income Tracking**: Users can add, update, delete, and view their income entries.
- **Expense Tracking**: Users can add, update, delete, and view their expense entries.
- **Data Visualization**: Real-time charts and graphs displaying income and expenses over time.
- **User-Specific Data**: Income and expense data are specific to each user, ensuring data privacy.
- **Personalized Budget Recommendations**: Offers suggestions based on the user's financial trends and history.
### Security Features
- **JWT Authentication**: Token-based authentication to secure API endpoints.
- **Data Encryption**: Passwords are stored securely using industry-standard encryption techniques.
- **Role-Based Access**: User data is protected and accessible only to the authenticated user.

## Technologies Used
### Frontend
- **Angular**: For building the user interface.
- **Chart.js**: For rendering interactive charts and graphs.
- **Bootstrap**: For responsive design and styling.
### Backend
- **Spring Boot**: For the RESTful API and backend logic.
- **Spring Security**: For implementing authentication and authorization.
- **JSON Web Tokens (JWT)**: For secure token-based authentication.
- **Hibernate/JPA**: For data persistence and database interactions.
### Database
- **MySQL**: Used as the relational database to store user data, income, and expenses.

## Architecture
The architecture of the project follows a three-tier design:
- **Presentation Layer**: Angular frontend, including forms for data entry and dynamic charts.
- **Business Logic Layer**: Spring Boot services that handle data manipulation and business logic.
- **Data Layer**: MySQL database accessed through Hibernate/JPA.

## Installation and Setup
### Prerequisites
- **Node.js**: Ensure Node.js is installed on your system.
- **Java 11 or higher**: Required for running the Spring Boot backend.
- **MySQL**: Set up a local or remote MySQL instance.
- **Angular CLI**: For building and running the frontend.
### Setup Instructions
1. **Clone the Repository**

`git clone https://github.com/your-username/personal-finance-tracker.git `

`cd personal-finance-tracker`

2. **Backend Setup**
- Navigate the backend directory:

`cd backend`

- Configure the database connection in the `application.properties` file:

`spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name`

`spring.datasource.username=your-username`

`spring.datasource.password=your-password`

- Build and run the Spring Boot application:

`./mvnw spring-boot:run`

3. **Frontend Setup**
- Navigate the frontend directory:

`cd frontend`

- Install the required packages:

`npm install`

- Start the angular application:

`ng serve`

4. **Access the Application**
- Open your web browser and go to `http://localhost:4200/`.

## Usage
### User Authentication
1. **Register**: Create an account using a unique username and email.
2. **Login**: Enter your credentials to receive a JWT token.
3. **Dashboard**: Access the dashboard with personalized income and expense data.
### Adding Income and Expenses
- Navigate to the dashboard and click on "Add Income" or "Add Expense" buttons to record new financial entries.
- View a list of your income and expenses, with options to edit or delete individual records.
### Data Visualization
- Interactive charts display your financial trends over time, showing income and expenses for easy analysis.

## API Endpoints
### Authentication
- **POST** `/api/auth/register`: Register a new user.
- **POST** `/api/auth/login`: User login and JWT token generation.
### Income
- **GET** `/api/income`: Retrieve user-specific income data.
- **POST** `/api/income`: Add a new income entry.
- **PUT** `/api/income/{id}`: Update an existing income entry.
- **DELETE** `/api/income/{id}`: Delete an income entry.
### Expense
- **GET** `/api/expense`: Retrieve user-specific expense data.
- **POST** `/api/expense`: Add a new expense entry.
- **PUT** `/api/expense/{id}`: Update an existing expense entry.
- **DELETE** `/api/expense/{id}`: Delete an expense entry.

## Security
### JWT Token-Based Authentication
- **Access Control**: Tokens are required to access secured API endpoints.
- **Secure Data Transmission**: All sensitive data is transmitted securely using JWT tokens.

## Future Enhancements
- **Budget Recommendation Algorithms**: Use AI to offer better budgeting advice.
- **Multi-Currency Support**: Add support for various currencies based on the user's location.
- **Mobile App Integration**: Create a mobile app version for on-the-go tracking.
- **Notifications**: Alerts for approaching budget limits and irregular spending.

## Contributing
We welcome contributions from the community! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a Pull Request.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

## Contact
For questions or support, please contact [snannra03@gmail.com](snannra03@gmail.com).
