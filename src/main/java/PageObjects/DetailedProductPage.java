package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailedProductPage {

    WebDriver webDriver;

    @FindBy(xpath = "//a[@class='main-btn main-btn--green main-btn--large']")
    private WebElement buyButton;

    public DetailedProductPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickBuyButton(){
        buyButton.click();
    }
}
