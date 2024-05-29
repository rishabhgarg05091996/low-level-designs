# Expense Sharing Application

## Overview
This project is a simplified version of the Splitwise application. It allows users to manage shared expenses by dividing costs equally, exactly, or by percentage. The application is built using Java, adhering to object-oriented principles, SOLID principles, and design patterns, with an emphasis on reducing boilerplate code using Lombok.

## Features
- Add users to the system.
- Create expenses split by equal, exact, or percentage amounts.
- Display individual user balances.
- Display all balances between users.

## Key Classes and Responsibilities

### `User.java`
Represents a user with fields for ID, name, email, and phone number. Uses Lombok to reduce boilerplate code.

### `Split.java`
Abstract base class for different types of splits (EqualSplit, ExactSplit, PercentSplit). Contains common attributes like user and amount.

### `Expense.java`
Abstract base class for different types of expenses (EqualExpense, ExactExpense, PercentExpense). Contains common attributes like amount, paidBy, splits, and metadata.

### `ExpenseService.java`
Service class responsible for creating expenses based on the type (EQUAL, EXACT, PERCENT).

### `UserService.java`
Service class for managing users. Provides methods to add and retrieve users.

### `ExpenseManager.java`
Manages expenses and user balances. Provides methods to add expenses and display balances.

### `Driver.java`
Main class to demonstrate the functionality of the application.

## Best Practices
- **Adherence to SOLID Principles**: Ensuring the code is modular, scalable, and maintainable.
- **Use of Lombok**: Reducing boilerplate code for model classes.
- **Functional Programming**: Utilizing Java Streams and lambda expressions for concise code.
- **Clear Project Structure**: Organizing code into packages based on functionality.

## Contributing
Contributions are welcome! Please fork the repository and submit pull requests.

## Contact
For any questions or suggestions, please contact [rishabhgarg6257@gmail.com].

