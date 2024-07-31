import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class skelbiult {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Test
    public void search() {
        driver.findElement(By.id("searchKeyword")).sendKeys("saulegraza");
        driver.findElement(By.id("searchButton")).click();
    }


    @BeforeMethod
  public void openWebsite(){
      driver.get("https://skelbiu.lt");
  }
    public void acceptCookies(){
        driver.get("https://skelbiu.lt");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(25));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
             acceptCookies();
    }


    @AfterClass
    public void tearDown(){
//        driver.close();
    }


}
