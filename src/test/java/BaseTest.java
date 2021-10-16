import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

    public class BaseTest{
        public static WebDriver driver;
        @BeforeTest

        public static void StartUp(){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver(options);
            options.addArguments("--disable-notifications");
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.get("https://www.migros.com.tr/");
            driver.manage().window().maximize();
        }

        @AfterTest
        public void tearDown(){
            driver.quit();
        }


    }

