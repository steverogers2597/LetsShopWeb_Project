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
