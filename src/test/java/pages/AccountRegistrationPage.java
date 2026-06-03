// filename: AccountRegistrationPage.java

package pages;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage {

    private final WebDriver driver;

    // ── Locators ──────────────────────────────────────────────────
    private final By firstNameField   = By.xpath("//input[@placeholder='First Name']");
    private final By lastNameField    = By.xpath("//input[@placeholder='Last Name']");
    private final By emailField       = By.xpath("//input[@placeholder='email@example.com']");
    private final By phoneField       = By.xpath("//input[@placeholder='enter your number']");
    private final By occupationDrop   = By.xpath("//select[@name='occupation']");
    private final By passwordField    = By.xpath("//input[@placeholder='Passsword']");
    private final By confirmPassField = By.xpath("//input[@placeholder='Confirm Passsword']");
    private final By ageCheckbox      = By.xpath("//input[@type='checkbox']");
    private final By registerButton   = By.xpath("//input[@value='Register']");

    // ── Constructor ───────────────────────────────────────────────
    public AccountRegistrationPage() {
        this.driver = BaseTest.driver;
    }

    // ── Action Methods ────────────────────────────────────────────
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPhoneNumber(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void selectOccupation(String occupation) {
        new Select(driver.findElement(occupationDrop)).selectByVisibleText(occupation);
    }

    public void selectGender(String gender) {
        // Finds the radio button whose sibling text matches Male or Female
        driver.findElement(By.xpath(
                "//input[@type='radio' and following-sibling::*[text()='" + gender + "']]"
        )).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPassField).sendKeys(confirmPassword);
    }

    public void checkAgeCheckbox() {
        WebElement checkbox = driver.findElement(ageCheckbox);
        if (!checkbox.isSelected()) checkbox.click();
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public boolean isRegistrationSuccessful() {
        // Checks the success toast/message after registration
        return driver.findElement(
                By.xpath("//*[contains(text(),'successfully') or contains(text(),'registered')]")
        ).isDisplayed();
    }
}
