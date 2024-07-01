# Movie Ticket Booking System

## Overview
A modular and scalable movie ticket booking system, designed following best practices and SOLID principles. The system supports functionalities for booking, payment processing, and notifications.


## Modules

### Booking
- **Model**: Contains the data models (`Booking`, `Movie`, `Show`, `Seat`, `Theater`, etc.).
- **Service**: Handles booking logic (`MovieTicketBookingService`).

### User
- **Model**: Contains user data model (`User`).

### Payment
- **Model**: Contains payment-related models (`Payment`, `PaymentStatus`).
- **Service**: Handles payment processing (`PaymentService`).

### Notification
- **Model**: Contains notification-related models (`Notification`, `NotificationStatus`, `NotificationType`).
- **Service**: Handles sending notifications (`NotificationService`).

### Utility
- **IdGenerator**: Utility class for generating unique IDs.

### Demo
- **MovieTicketBookingDemo**: Demonstrates how to use the system.

### Booking Tickets
1. **Add Movies, Theaters, and Shows**:
    ```java
    MovieTicketBookingService bookingService = MovieTicketBookingService.getInstance();
    bookingService.addMovie(new Movie("M1", "Movie 1", "Description 1", 120));
    bookingService.addTheater(new Theater("T1", "Theater 1", "Location 1", new ArrayList<>()));
    bookingService.addShow(new Show("S1", movie1, theater1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie1.getDurationInMinutes()), createSeats(10, 10)));
    ```

2. **Book and Confirm Tickets**:
    ```java
    User user = new User("U1", "John Doe", "john@example.com");
    List<Seat> selectedSeats = Arrays.asList(show1.getSeats().get("1-5"), show1.getSeats().get("1-6"));
    Booking booking = bookingService.bookTickets(user, show1, selectedSeats);
    if (booking != null) {
        bookingService.confirmBooking(booking.getId());
    }
    ```

3. **Cancel Booking**:
    ```java
    bookingService.cancelBooking(booking.getId());
    ```

## Contributing
Contributions are welcome! Please fork the repository and submit pull requests.

## Contact
For any questions or suggestions, please contact [rishabhgarg6257@gmail.com].
