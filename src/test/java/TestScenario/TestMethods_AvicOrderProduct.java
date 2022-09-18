package TestScenario;

import PageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestMethods_AvicOrderProduct {
    protected WebDriver webDriver;
    final String searchProduct = "iphone13";
    final int countOfProducts = 4;

    @Parameters("browser")
    @BeforeClass
   // Passing Browser parameter from TestNG xml
    public void beforeTest(String browser) {

        webDriver = new DriverFactory().createInstance(browser);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https:\\avic.ua/ua");
        webDriver.manage().window().maximize();
    }

    @Test (priority = 0)
    public void searchOperation(){

        try {
            MainPage mainPage = new MainPage(webDriver);
            mainPage.searchProduct(searchProduct);
            mainPage.clickSearchButton();
        }
        catch (Exception e){
            System.out.println("Exception catch" + e.getMessage());
        }
    }

    @Test (priority = 1)
    public void clickDetailProductOperation(){
        try {
            ProductPage productPage = new ProductPage(webDriver);
            productPage.checkOnlyExistProduct();
            productPage.selectProduct();
        }
        catch (Exception e){
            System.out.println("Exception catch" + e.getMessage());
        }
    }

    @Test (priority = 2)
    public void addToCartOperation(){
        try {
            DetailedProductPage detailedProductPage = new DetailedProductPage(webDriver);
            detailedProductPage.clickBuyButton();
        }
        catch (Exception e){
            System.out.println("Exception catch" + e.getMessage());
        }
    }

    @Test (priority = 3)
    public void makeOrderProductOperation(){
        try {
            CartPage cartPage = new CartPage(webDriver);
            cartPage.increaseCountProduct(countOfProducts);
            cartPage.clickMakeOrderButton();
        }
        catch (Exception e){
            System.out.println("Exception catch" + e.getMessage());
        }
    }

    @Test (priority = 4)
    public void confirmOrderOperation(){
        try {
            OrderPage orderPage = new OrderPage(webDriver);
            orderPage.setSurname("Test EPAM");
            orderPage.setPhone("0000000000");
            orderPage.setEmail("test_epam@epam.com");
        }
        catch (Exception e){
            System.out.println("Exception catch" + e.getMessage());
        }
    }

    @AfterTest
    public void verify(){
        OrderPage verifyPage = new OrderPage(webDriver);
        boolean isButtonDisplayed = verifyPage.verifyConfirmOrder();
        Assert.assertEquals(true, isButtonDisplayed);
    }

    @AfterClass
    public void afterTest(){
        webDriver.close();
    }
}
