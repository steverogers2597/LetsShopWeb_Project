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
