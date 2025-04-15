package Utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class ClassesUtils {


    // TODO :: click on Element
    public static void clickOnElement(WebDriver driver , By ele) {
        new WebDriverWait(driver , Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(ele)) ;
        driver.findElement(ele).click();
    }


    // TODO :: get text from Element
    public static String getTextFromElement(WebDriver driver , By ele) {
        new WebDriverWait(driver , Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(ele)) ;
        return driver.findElement(ele).getText();
    }


    //  TODO :: enter text
    public static void enterTextOnEle(WebDriver driver , By ele , String txt)
    {
        new WebDriverWait(driver , Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(ele)) ;
        driver.findElement(ele).sendKeys(txt);
    }

    //TODO:: timestamp
    public static String getTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    //TODO :: Scrolling
    public static void scrollDown(WebDriver driver , By ele) {

            new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(ele)) ;
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(ele)) ;
        }

        //TODO :: take screenshot

    public static final String screenPaths = "test-outputs/screenshots/";

    public static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        LogsUtils.info("logs");
           File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
        LogsUtils.info("logs");
           File dis = new File(screenPaths+screenshotName+"-"+getTimestamp()+".png");
        LogsUtils.info("logs");
            FileUtils.copyFile(src,dis);
        LogsUtils.info("logs");


        try {
            Allure.addAttachment(screenshotName , Files.newInputStream(Path.of(dis.getPath())));
        } catch (IOException e) {
           e.getStackTrace();
        }

    }


     //TODO :: get Latest File
    public static File getLatestFile(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();

        assert files != null;
        Arrays.sort(files, Comparator.comparing(File::lastModified).reversed());
        return files[0];


    }






    }

