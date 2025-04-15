package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FactoryClass {

public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

public static void setBrowser(String browserName) {

    if (browserName.equalsIgnoreCase("chrome")) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
      threadLocal.set(new ChromeDriver(options));

    } else if (browserName.equalsIgnoreCase("firefox")) {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        threadLocal.set(new FirefoxDriver(options));

    }else {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        threadLocal.set(new EdgeDriver(options));
    }
}

public static WebDriver getDriver()
{
    return threadLocal.get();
}

public static void closeBrowser()
{
    getDriver().quit();
   // threadLocal.remove();
}








}
