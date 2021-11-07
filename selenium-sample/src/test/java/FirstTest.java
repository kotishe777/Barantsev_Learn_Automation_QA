
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() throws InterruptedException, UnsupportedEncodingException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click();

        String s = null;
        try {
            String priwet = new String(
                    "\u041F" + "\u043E" + "\u0448" + "\u0443" + "\u043A");
            byte[] utf8Bytes = priwet.getBytes("UTF8");
            s = new String(utf8Bytes,"UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        wait.until(titleIs("webdriver - " + s + " Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}