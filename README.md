## 📂 Project Diagram

```text
LetsShopWeb_Project/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org.example/
│   │           ├── BaseTest.java
│   │           └── ExtentReportManager.java
│   │
│   └── test/
│       ├── java/
│       │   ├── hooks/
│       │   │   └── CucumberHooks.java
│       │   ├── pages/
│       │   │   └── AccountRegistrationPage.java
│       │   ├── runners/
│       │   │   └── TestRunner.java
│       │   └── stepdefinitions/
│       │       └── AccountRegistrationStepDefs.java
│       │
│       └── resources/
│           ├── Features/
│           │   └── AccountRegistration.feature
│           └── config/
│               └── config.properties
│
├── pom.xml
└── testng.xml

## ▶️ Execution Flow

1. **TestRunner.java**  
   - Entry point: triggers execution via TestNG.  

2. **AccountRegistration.feature**  
   - Cucumber reads scenarios written in Gherkin (Given/When/Then).  

3. **CucumberHooks.java (@Before)**  
   - Sets up WebDriver.  
   - Initializes ExtentReport.  

4. **BaseTest.java**  
   - Provides WebDriver instance.  
   - Loads configuration from `config.properties`.  

5. **AccountRegistrationStepDefs.java**  
   - Step definitions execute.  
   - Maps feature steps to Java methods.  

6. **AccountRegistrationPage.java**  
   - Performs UI actions on the browser (form filling, clicks, validations).  

7. **CucumberHooks.java (@After)**  
   - Captures screenshot on failure.  
   - Closes browser session.  

8. **ExtentReportManager.java**  
   - Generates final HTML report with logs, screenshots, and status.  


📦 Dependencies Overview

## 📦 Dependencies Overview

| Dependency        | Purpose             | Role in Project |
|-------------------|---------------------|-----------------|
| **selenium-java** 🌐 | Browser Automation   | Core engine for interacting with Chrome/Firefox. Used in `BaseTest.java` & `AccountRegistrationPage.java`. |
| **testng** 🧪       | Test Framework       | Manages test lifecycle (`@BeforeMethod`, `@AfterMethod`) and executes via `testng.xml`. |
| **cucumber-java** 🥒 | BDD                 | Maps `.feature` steps (Given/When/Then) to Java methods in `StepDefs.java`. |
| **cucumber-testng** 🥒 | BDD + TestNG Bridge | Integrates Cucumber with TestNG, enabling execution through `TestRunner.java`. |
| **extentreports** 📊 | Reporting           | Generates rich HTML reports with logs, screenshots, and timestamps. Managed by `ExtentReportManager.java` and triggered in `CucumberHooks.java`. |
