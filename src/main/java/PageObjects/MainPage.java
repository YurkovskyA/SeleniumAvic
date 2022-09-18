package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    WebDriver webDriver;
    WebElement webElement;

    @FindBy(xpath = "//input[@class='search-query']")
    private WebElement searchProduct;

    @FindBy (xpath = "//button[@class='button-reset search-btn']")
    private WebElement clickSearchButton;


    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickSearchButton(){
        clickSearchButton.click();
    }

    public void searchProduct(String searchInput){
        webElement =  new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(driver -> searchProduct);
        webElement.sendKeys(searchInput, Keys.END);
    }

}
