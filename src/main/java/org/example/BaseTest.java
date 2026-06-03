// filename: BaseTest.java

package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    // ── Static driver — shared across Hooks, StepDefs and Pages ──
    public static WebDriver driver;
    private static final Properties props = new Properties();

    // ── Load config.properties once ──────────────────────────────
    static {
        try (InputStream input = BaseTest.class
                .getClassLoader()
                .getResourceAsStream("config/config.properties")) {

            if (input == null)
                throw new RuntimeException("config/config.properties not found on classpath.");

            props.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }

    // ── Getters for config values ─────────────────────────────────
    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    // ── Driver Setup ──────────────────────────────────────────────
    public static void initDriver() {
        String browser = getProperty("browser").toLowerCase();

        switch (browser) {
            case "firefox" -> driver = new FirefoxDriver();
            default        -> driver = new ChromeDriver();   // default: chrome
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getProperty("url"));
    }

    // ── Driver Teardown ───────────────────────────────────────────
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
