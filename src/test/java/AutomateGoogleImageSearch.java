import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class AutomateGoogleImageSearch {
    WebDriver driver;

    @Before
    public void Setup(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxOptions fops = new FirefoxOptions();
        fops.addArguments("--headed");
        driver = new FirefoxDriver(fops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void AutomatingGoogleImageSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Images')]")).click();
        driver.findElement(By.cssSelector("[aria-label='Search by image']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Upload an image')]")).click();
        driver.findElement(By.cssSelector("[name='encoded_image']")).sendKeys("D:\\Torrent\\Wallpaperswide.com\\4K\\3d_sun_system_2-wallpaper-3840x2160.jpg");
        Thread.sleep(8000);
        String text = driver.getTitle();
        System.out.println("Title of the page is: " + text);
        Assert.assertTrue(text.contains("Google Search"));
    }

    @After
    public void FinishTest(){
        driver.close();
    }
}
