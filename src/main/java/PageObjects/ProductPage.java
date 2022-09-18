package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {

    WebDriver webDriver;

    By selectProduct = By.xpath("//div[@class='item-prod col-lg-3']");

    @FindBy (xpath = "//label[@for='fltr-1']")
    private WebElement existProduct;

/*    @FindBy (xpath = "//div[@class='item-prod col-lg-3']")
    private WebElement selectProduct_PF;*/

    public ProductPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void checkOnlyExistProduct(){
        existProduct.click();
    }

    /*ToDo Implement PageFactory with findElements*/
    public void selectProduct(){
        List<WebElement> elements = webDriver.findElements(selectProduct);
        for (int i=0; i < elements.size(); i++){
            elements.get(i).click();
            break;
        }
    }

}
