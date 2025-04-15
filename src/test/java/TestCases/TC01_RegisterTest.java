package TestCases;

import Factory.FactoryClass;
import Utils.DataUtils;
import Utils.LogsUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Listeners.* ;
import java.io.IOException;
import java.time.Duration;

import static Factory.FactoryClass.getDriver;
import static Factory.FactoryClass.setBrowser;

@Listeners({IInvokedListener.class, ITestListener.class})
public class TC01_RegisterTest {

    @BeforeClass
    public void setUp() throws IOException {
       setBrowser(DataUtils.readPropertiesFile("ENV","browserName"));
    }

    @BeforeMethod
    public void beginTest() throws IOException {

        getDriver().get(DataUtils.readPropertiesFile("ENV","baseUrl"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void validRegisterTC(){
        LogsUtils.info("welcome");
        Assert.assertEquals(getDriver().getTitle(), "nopCommerce demo store");
    }


    @AfterClass
    public void tearDown()
    {
        FactoryClass.closeBrowser();
    }
}
