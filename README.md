** --- Project Diagram ---**
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

**---Execution Sequence---**

1. TestRunner.java          → Triggers test execution
       │
2. AccountRegistration      → Cucumber reads scenarios
   .feature
       │
3. CucumberHooks.java       → @Before fires → Sets up WebDriver
       │                                       & ExtentReport
4. BaseTest.java            → Provides WebDriver instance
       │                      Reads config.properties
5. AccountRegistration      → @Step methods fire
   StepDefs.java
       │
6. AccountRegistration      → UI actions performed
   Page.java                  on browser
       │
7. CucumberHooks.java       → @After fires → Captures screenshot
       │                                     & closes browser
8. ExtentReportManager      → Generates final HTML report
   .java

**---What each of my dependency is doing---**
┌────────────────────────────┬─────────────┬──────────────────────────────────────────────────┐
│ Dependency                 │ Group       │ What It Does In Your Project                     │
├────────────────────────────┼─────────────┼──────────────────────────────────────────────────┤
│ selenium-java              │ 🌐 Browser  │ The engine that opens Chrome/Firefox, clicks     │
│                            │ Automation  │ buttons, fills forms and reads page content.     │
│                            │             │ Used directly in BaseTest.java &                 │
│                            │             │ AccountRegistrationPage.java                     │
├────────────────────────────┼─────────────┼──────────────────────────────────────────────────┤
│ testng                     │ 🧪 Test     │ Runs your tests, manages @BeforeMethod /         │
│                            │ Framework   │ @AfterMethod lifecycle hooks and produces        │
│                            │             │ test result summaries. Wired via testng.xml      │
├────────────────────────────┼─────────────┼──────────────────────────────────────────────────┤
│ cucumber-java              │ 🥒 Cucumber │ Reads your .feature files and maps               │
│                            │ BDD         │ Given/When/Then steps to Java methods            │
│                            │             │ in AccountRegistrationStepDefs.java              │
├────────────────────────────┼─────────────┼──────────────────────────────────────────────────┤
│ cucumber-testng            │ 🥒 Cucumber │ Bridges Cucumber and TestNG together so          │
│                            │ BDD         │ TestRunner.java can trigger Cucumber scenarios   │
│                            │             │ through TestNG's execution engine                │
├────────────────────────────┼─────────────┼──────────────────────────────────────────────────┤
│ extentreports              │ 📊 Reporting│ Generates a rich HTML report with pass/fail      │
│                            │             │ status, screenshots, logs and timestamps.        │
│                            │             │ Managed by ExtentReportManager.java &            │
│                            │             │ triggered in CucumberHooks.java                  │
└────────────────────────────┴─────────────┴──────────────────────────────────────────────────┘
