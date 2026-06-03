LetsShopWeb_Project/
│
├── src/
│   │
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
│       │   │
│       │   ├── pages/
│       │   │   └── AccountRegistrationPage.java
│       │   │
│       │   ├── runners/
│       │   │   └── TestRunner.java
│       │   │
│       │   └── stepdefinitions/
│       │       └── AccountRegistrationStepDefs.java
│       │
│       └── resources/
│           ├── Features/
│           │   └── AccountRegistration.feature
│           │
│           └── config/                          ⬅️ New subfolder
│               └── config.properties
│
├── pom.xml
└── testng.xml
