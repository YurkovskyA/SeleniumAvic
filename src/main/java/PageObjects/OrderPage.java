package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    WebDriver webDriver;
    WebElement webElement;

    @FindBy(xpath = "//input[@data-bind='name']")
    private WebElement surnameField;

    @FindBy(xpath = "//input[@data-bind='phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@data-bind='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@class='submit button-reset main-btn main-btn--green submit_concord_paymenet']")
    private WebElement confirmButton;

    public OrderPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void setSurname(String surname){
        webElement = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(driver -> surnameField);
        webElement.sendKeys(surname, Keys.END);
    }

    public void setPhone(String phone){
        phoneField.sendKeys(phone, Keys.END);
    }

    public void setEmail(String email){
        emailField.sendKeys(email, Keys.END);
    }

    public boolean verifyConfirmOrder(){
        return confirmButton.isDisplayed();
    }

}
