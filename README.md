BookYourTickets Project
BookYourTickets is a web application inspired by BookMyShow, designed to facilitate the booking of tickets for movies, shows, and various events. The project consists of two main components: a frontend developed using React.js and a backend developed using Spring Boot. The data is stored in an Oracle Database, providing a robust and scalable solution.

Project Structure
The project is organized into two main folders in the main branch:

frontend:

Contains the React.js project for the frontend.
Responsible for providing a user-friendly interface for booking tickets.
backend:

Contains the Spring Boot project for the backend.
Developed to handle API requests from the frontend and interact with the Oracle Database.
Implements functionality for both the admin and user sections.
Features
Admin Section
Movie and Show Management:
Admins can upload details about movies and various types of shows.
Data Export:
Admins can download booked tickets data in both PDF and Excel formats for record-keeping.
User Section
Ticket Booking:

Users can easily browse and book tickets for movies, shows, and events.
Payment Gateway Integration:

Razorpay is integrated for secure and seamless payment transactions.

Getting Started
To run the project locally, follow these steps:

Clone the repository:

git clone https://github.com/your-username/BookYourTickets.git

Navigate to the frontend and backend folders separately and follow the setup instructions provided in their respective README files.

Ensure that the Oracle Database is properly configured and accessible.

Start the backend server and then the frontend to launch the application locally.

# Navigate to the backend folder and start the Spring Boot application
cd backend
./mvnw spring-boot:run


# Navigate to the frontend folder and start the React.js application
cd frontend
npm install
npm start


Technologies Used
React.js
Spring Boot
Oracle Database
Razorpay (Payment Gateway)

