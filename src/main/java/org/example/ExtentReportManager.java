// filename: ExtentReportManager.java

package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    // ── Initialize report (called once in @BeforeSuite / first @Before) ──
    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/TestReport.html");
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("LetsShop Test Report");
            spark.config().setReportName("Account Registration Suite");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Application", "LetsShop Web");
            extent.setSystemInfo("Browser",     BaseTest.getProperty("browser"));
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }

    // ── Create a new test entry ───────────────────────────────────
    public static ExtentTest createTest(String testName) {
        ExtentTest test = getInstance().createTest(testName);
        testThread.set(test);
        return test;
    }

    // ── Get current test (for logging inside step defs) ──────────
    public static ExtentTest getTest() {
        return testThread.get();
    }

    // ── Flush writes report to disk ───────────────────────────────
    public static void flushReport() {
        if (extent != null) extent.flush();
    }
}
