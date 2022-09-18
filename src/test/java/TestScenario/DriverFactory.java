package TestScenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class DriverFactory {

    public WebDriver createInstance(String browser) {
        WebDriver webDriver;
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            case EDGE:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                webDriver = new OperaDriver();
                break;
            default:
                throw new UnreachableBrowserException(browser);
        }
        return webDriver;
    }

    public enum BrowserList {
        CHROME, FIREFOX, EDGE, OPERA
    }
}