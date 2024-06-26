import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ElentaTests {
    //vardas 3-20 simbolių, raidės skaičiai ir tarpai galimi
    //passwordas 8 simboliai maža, didelė raidė, skaicius, 8 simboliai. viskas kartu privaloma
    public static WebDriver driver;
    @Ignore
    @Test
    public void openWebsite(){
        driver.get("https://elenta.lt/registracija");
        List<WebElement> errorelements = driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        Assert.assertEquals(errorelements.size(), 1);

        //arba
        WebElement errorelement;
        try {
             errorelement = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
            Assert.assertEquals(errorelement.getText(), "Įveskite vartotojo vardą.");
        }catch (Exception e){
            Assert.fail();
        }
        //arba
       Assert.assertEquals( driver.getCurrentUrl(),"https://elenta.lt/registracija");
    }
    @Test
    public void openRegistrationPage(){
        driver.get("https://elenta.lt/registracija");

    }
    public void acceptCookies(){
        driver.get("https://elenta.lt");
        driver.findElement(By.className("fc-cta-consent")).click();
    }

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }


    @AfterClass
    public void tearDown(){
//        driver.close();
    }


    @Ignore
    @Test
    public void garbagebin() throws InterruptedException {

        driver.get("https://www.elenta.lt");
//        Thread.sleep(5000);
        WebElement mygtukas = driver.findElement(By.className("fc-cta-consent"));
        mygtukas.click();
//        mygtukas.findElement(By.className("btn-title"));
//        List<WebElement> korteles = driver.findElements(By.className("simple-card"));
//        driver.findElement(By.id("header-container-nav"))
//                .findElements(By.className("button"))
//                .get(2)
//                .click();
//        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/a[3]")).click();
//        driver.findElement(By.xpath("//*[@id=\"header-container-nav\"]/a[3]")).click();
//        driver.findElement(By.cssSelector("#header-container-nav > a:nth-child(3)")).click();
    }
}
