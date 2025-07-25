# Selenide Test Automation Framework

A robust and scalable test automation framework built with **Selenide**, **JUnit 5**, and **Java** for web application testing. This framework follows the Page Object Model (POM) design pattern and includes comprehensive test data management, configuration handling, and reporting capabilities.

## 🚀 Features

- **Page Object Model (POM)** - Clean separation of test logic and page elements
- **Data-Driven Testing** - Dynamic test data generation using JavaFaker and PODAM
- **Configuration Management** - Externalized configuration using Owner library
- **Parallel Test Execution** - JUnit 5 parallel execution support
- **Allure Reporting** - Comprehensive test reporting with screenshots and logs
- **Custom Annotations** - Tagged test execution for Web and API tests
- **Flexible Test Data** - Strategy-based test data generation
- **Cross-Browser Support** - Configurable browser execution

## 🛠️ Tech Stack

- **Java** - Programming language
- **Selenide** - Web automation framework
- **JUnit 5** - Testing framework
- **Maven** - Build and dependency management
- **Allure** - Test reporting
- **JavaFaker** - Test data generation
- **PODAM** - POJO data manufacturing
- **Owner** - Configuration management
- **RestAssured** - API testing support
- **Lombok** - Boilerplate code reduction

## 📁 Project Structure

```
src/
├── main/java/com/remwaste/
│   ├── config/
│   │   ├── FrameworkConfig.java          # Configuration interface
│   │   └── factory/
│   │       └── ConfigFactory.java        # Configuration factory
│   ├── entity/
│   │   ├── LoginDetails.java             # Login data model
│   │   ├── UserDetails.java              # User data model
│   │   └── strategy/                     # Data generation strategies
│   │       ├── EmailStrategy.java
│   │       ├── FirstNameStrategy.java
│   │       ├── LastNameStrategy.java
│   │       ├── MobileNumberStrategy.java
│   │       ├── PasswordStrategy.java
│   │       └── UsernameStrategy.java
│   ├── pages/                            # Page Object classes
│   │   ├── DashboardPage.java
│   │   ├── ForgotPasswordPage.java
│   │   ├── LoginPage.java
│   │   ├── ProfilePage.java
│   │   └── SignUpPage.java
│   ├── tags/testtype/                    # Custom test annotations
│   │   ├── ApiTest.java
│   │   └── WebTest.java
│   ├── testdata/                         # Test data factories
│   │   ├── LoginTestData.java
│   │   └── UserTestData.java
│   └── utils/
│       └── Utilities.java                # Utility methods
└── test/java/com/remwaste/tests/
    ├── base/                             # Base test classes
    │   ├── TestSetup.java
    │   ├── WebTestSetup.java
    │   └── ApiTestSetUp.java
    └── web/                              # Web test classes
        ├── LoginTest.java
        ├── RegisterUserTest.java
        ├── ResetPasswordTest.java
        └── UserDetailsTest.java
```

## ⚙️ Prerequisites

- **Java 11** or higher
- **Maven 3.6+**
- **Chrome/Firefox** browser installed
- **Allure CLI** (optional, for local report generation)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/avinashkare/SelenideFramework.git
cd SelenideFramework
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Configuration

Update the configuration file at `src/test/resources/config.properties`:

```properties
# Application URLs
web.url=https://swift.techwithjatin.com/
api.baseurl=http://64.227.160.186:8080/

# Parallel execution settings
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.mode.default=concurrent
junit.jupiter.execution.parallel.config.strategy=fixed
junit.jupiter.execution.parallel.config.fixed.parallelism=2

# Selenide settings
selenide.timeout=10000
selenide.browser=chrome
```

## 🧪 Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Web Tests Only
```bash
mvn clean test -Dgroups="web"
```

### Run API Tests Only
```bash
mvn clean test -Dgroups="api"
```

### Run Tests in Headless Mode
```bash
mvn clean test -Dselenide.headless=true
```

### Run Tests with Specific Browser
```bash
mvn clean test -Dselenide.browser=firefox
```

## 📊 Test Reporting

### Generate Allure Report
```bash
mvn allure:serve
```

### Generate Allure Report (Static)
```bash
mvn allure:report
```

The reports will be available at `target/site/allure-maven-plugin/index.html`

## 🏗️ Framework Architecture

### Page Object Model
Each page is represented by a separate class containing:
- Page elements as `SelenideElement`
- Page-specific methods
- Fluent interface for method chaining

### Test Data Management
- **Strategy Pattern** - Custom data generation strategies
- **PODAM Integration** - Automatic POJO population
- **JavaFaker** - Realistic test data generation

### Configuration Management
- **Owner Library** - Type-safe configuration
- **Multiple Sources** - System properties, environment variables, and files
- **Merge Strategy** - Flexible configuration override

## 📝 Writing Tests

### Example Test Class
```java
public class LoginTest extends WebTestSetup {
    
    private final LoginDetails loginDetails = LoginTestData.getValidLoginDetails();
    
    @WebTest
    void testValidLogin() {
        LoginPage.getInstance()
                .validLogin(loginDetails)
                .verifyUserLoggedInSuccessfully(loginDetails.getUserName())
                .logout();
    }
}
```

### Example Page Object
```java
public class LoginPage {
    
    private static final SelenideElement USERNAME = $(byId("username"));
    private static final SelenideElement PASSWORD = $(byId("password"));
    private static final SelenideElement SIGN_IN_BUTTON = $(withTagAndText("button", "Sign In"));
    
    public DashboardPage validLogin(LoginDetails loginDetails) {
        USERNAME.setValue(loginDetails.getUserName());
        PASSWORD.setValue(loginDetails.getPassword());
        SIGN_IN_BUTTON.click();
        return new DashboardPage();
    }
}
```

## 🔧 Customization

### Adding New Page Objects
1. Create a new class in `src/main/java/com/remwaste/pages/`
2. Define page elements using Selenide selectors
3. Implement page-specific methods
4. Follow the singleton pattern with `getInstance()` method

### Adding Test Data Strategies
1. Create a new strategy class implementing `AttributeStrategy<T>`
2. Use JavaFaker to generate realistic data
3. Apply the strategy using `@PodamStrategyValue` annotation

### Custom Test Tags
1. Create annotation in `src/main/java/com/remwaste/tags/`
2. Use `@Tag` and `@Test` annotations
3. Run tagged tests using Maven groups

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request


## 👨‍💻 Author

**Avinash Kare**
- GitHub: [@avinashkare](https://github.com/avinashkare)

## 🙏 Acknowledgments

- [Selenide](https://selenide.org/) - For the excellent web automation framework
- [JUnit 5](https://junit.org/junit5/) - For the modern testing platform
- [Allure](https://docs.qameta.io/allure/) - For beautiful test reporting
- [JavaFaker](https://github.com/DiUS/java-faker) - For realistic test data generation

---

⭐ **Star this repository if you find it helpful!**
