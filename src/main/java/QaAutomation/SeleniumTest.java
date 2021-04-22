package QaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
            public void testSelenium() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Alisa\\Desktop\\chromedriver.exe");
        WebDriver w=new ChromeDriver();
//        w.manage().window().maximize();
        w.get("https://youtube.com");
        Thread.sleep(2000);
        WebElement inputField= w.findElement(By.id("buttons"));
        inputField.click();
        Thread.sleep(1000);
        w.quit();





    }


}
