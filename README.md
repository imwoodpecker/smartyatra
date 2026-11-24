# SMART YATRA - Smart Travel Planner

One-stop solution for travel planning with tourist destinations, hotel bookings, train schedules, and more.

## Tech Stack
- **Backend**: Spring Boot with Microservices Architecture
- **Frontend**: ReactJS with Vite
- **Database**: PostgreSQL
- **Authentication**: JWT with Role-based Access Control
- **APIs**: Google Maps/Places, IRCTC for live train data
- **Schema Versioning**: Flyway
- **Testing**: Postman (30+ APIs)

## Features
- Dynamic destination search with Google Maps/Places APIs
- Live train data integration via IRCTC API
- Secure JWT authentication with enum-based roles (User, Host, Admin)
- Admin dashboard for system control
- Tourist package booking system
- Favorite destinations management
- Hotel search and booking

## Project Structure
- `smart-yatra-backend/` - Spring Boot backend application
- `smart-yatra-frontend/` - ReactJS frontend application