# 🎮 Video Game Management System

**My first backend project using Java, Maven, and Hibernate ORM**

A console-based application to manage video games, pricing, reviews, and reviewers with complete database persistence.

## 🛠️ Technologies Used

- **Java 17+** - Core programming language
- **Maven** - Dependency management and build tool
- **Hibernate ORM** - Object-relational mapping framework
- **JPA Annotations** - Entity relationship mapping
- **PostgreSQL** - Database (configurable for other databases)
- **IntelliJ IDEA** - Development environment

## 🏗️ Features

### Core Functionality
- ✅ **Video Game Management** - Add games with detailed information
- ✅ **System Requirements** - Embedded system specifications for each game
- ✅ **Pricing Management** - Handle different editions and pricing strategies
- ✅ **Review System** - Complete reviewer profiles and game reviews
- ✅ **Menu-Driven Interface** - User-friendly console interaction

### Technical Features
- 🔄 **Generic DAO Pattern** - Reusable data access layer
- 🗃️ **Complex Entity Relationships** - One-to-Many, One-to-One, and Embedded entities
- 💾 **Automatic Database Schema Generation** - Hibernate handles table creation
- 🔗 **Bidirectional Mapping** - Proper relationship management between entities

## 📊 Database Schema

```
VideoGame (Main Entity)
├── game_id (Primary Key)
├── title, genre, platform
├── rating, release_year
├── developer, publisher
└── SystemRequirements (Embedded)
    ├── minRam, minStorage
    ├── multiplayerSupported
    ├── OSRequirement
    └── graphicsRequirement

VideoGamePrice (One-to-One with VideoGame)
├── id (Primary Key)
├── edition, basePrice, discount, currency
└── game_id (Foreign Key)

Reviewer
├── reviewer_id (Primary Key)
├── displayName, email
├── total_reviews, joinedDate
└── reviews (One-to-Many)

VideoGameReviews (Junction Entity)
├── Links VideoGame and Reviewer
├── rating, comment
└── Many-to-One relationships
```

## 🚀 Key Learning Achievements

### Hibernate & JPA Mastery
- ✅ Configured SessionFactory and Hibernate properties
- ✅ Implemented `@OneToMany`, `@OneToOne`, `@Embedded` relationships
- ✅ Used `@GeneratedValue` strategies and proper ID management
- ✅ Handled bidirectional mapping with `mappedBy`
- ✅ Applied cascade operations and orphan removal

### Clean Architecture
- ✅ **Controller Layer** - Input handling and business logic coordination
- ✅ **Model Layer** - Entity definitions and relationships
- ✅ **DAO Layer** - Generic data access pattern
- ✅ **Helper Classes** - Modular input processing

### Advanced Concepts
- ✅ Generic programming with DAO pattern
- ✅ Maven project structure and dependency management
- ✅ Database transaction management
- ✅ Object-relational mapping principles

## 💻 Project Structure

```
src/main/java/com/frostyFox/
├── controller/
│   ├── Main.java              # Application entry point
│   ├── InputController.java   # Business object creation
│   ├── InputHelper.java       # User input utilities
│   └── GenericDAO.java        # Reusable data access layer
└── model/
    ├── VideoGame.java         # Main game entity
    ├── SystemRequirements.java # Embedded system specs
    ├── VideoGamePrice.java    # Pricing information
    ├── VideoGameReviews.java  # Review junction entity
    └── Reviewer.java          # Reviewer profiles

src/main/resources/
└── hibernate.cfg.xml          # Database configuration
```

## 🔧 How to Run

### Prerequisites
- Java 17+ installed
- Maven installed
- PostgreSQL database running
- Git for version control

### Setup Steps
1. **Clone the repository**
   ```bash
   git clone https://github.com/gowtham-m-2005/VideoGameManagementHibernate.git
   cd VideoGameManagementHibernate
   ```

2. **Configure Database**
   - Update `src/main/resources/hibernate.cfg.xml` with your database credentials:
   ```xml
   <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/YourDatabase</property>
   <property name="hibernate.connection.username">your_username</property>
   <property name="hibernate.connection.password">your_password</property>
   ```

3. **Build and Run**
   ```bash
   mvn clean compile
   mvn exec:java -Dexec.mainClass="com.frostyFox.controller.Main"
   ```

4. **Follow the Menu**
   - Choose from 4 options to add games, prices, reviews, or reviewers
   - The application will guide you through data entry

## 📝 Usage Example

```
Choose an option to enter details
1. VideoGame Details
2. VideoGame Price Details  
3. VideoGame Review Details
4. VideoGame Reviewer Details

Enter the choice: 1

Enter VideoGame Details:
Title: The Witcher 3
Genre: RPG
Platform: PC
Rating: 9.5
Release Year: 2015
Developer: CD Projekt RED
Publisher: CD Projekt

Enter System Requirements:
OS: Windows 10
Multiplayer Supported: false
Minimum Storage: 35
Minimum Memory: 8
Graphics: GTX 770
```

## 🎯 What's Next?

This project served as my foundation for understanding backend development. Next learning goals:

- **Spring Framework** - Dependency injection and enterprise patterns
- **Spring Boot** - Modern application development
- **REST APIs** - Web service development
- **Spring Data JPA** - Advanced repository patterns
- **Unit Testing** - JUnit and Mockito

## 🤝 What I Learned

### Technical Skills
- Object-relational mapping concepts
- Database design and relationships
- Maven build tool and dependency management
- Generic programming and design patterns
- Transaction management and persistence

### Development Practices
- Clean code organization and separation of concerns
- Reusable component design
- User input validation and error handling
- Version control with Git and GitHub

## 📬 Connect With Me

- **GitHub**: [gowtham-m-2005](https://github.com/gowtham-m-2005)
- **LinkedIn**: [Connect with me](https://linkedin.com/in/your-profile)

---

⭐ **Star this repo if it helped you learn Hibernate!**

*This project represents my journey from frontend development into full-stack backend technologies. Every line of code taught me something new about enterprise Java development.*
