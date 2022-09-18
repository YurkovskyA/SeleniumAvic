package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver webDriver;
    WebElement webElement;

    @FindBy(xpath = "//a[@class='main-btn  main-btn--green']")
    private WebElement makeOrderButton;

    @FindBy(xpath = "//span[@class='js_plus btn-count btn-count--plus ']")
    private WebElement increaseButton;

    public CartPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void increaseCountProduct(int countOfProduct){
        webElement = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(driver -> increaseButton);
        Actions action = new Actions(webDriver);
        for (int i = 0; i < countOfProduct - 1; i++) {
            // exception : The Element is not Attached to the DOM
            // https://www.selenium.dev/exceptions/#stale_element_reference
            try {
                action.moveToElement(webElement).perform();
                action.click(webElement).perform();
                action.pause(Duration.ofSeconds(1));
            }
            catch(org.openqa.selenium.StaleElementReferenceException ex){
                action.moveToElement(increaseButton).perform();
                action.click(increaseButton).perform();
                action.pause(Duration.ofSeconds(1));
            }
        }
    }

    public void clickMakeOrderButton (){
        makeOrderButton.click();
    }

}
