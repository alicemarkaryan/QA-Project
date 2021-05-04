package QaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SixPmTest {

    @Test
    public void TestSelenium() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.6pm.com");
        Thread.sleep(2000);
        WebElement elem = driver.findElement(By.id("searchAll"));
        elem.sendKeys("dresses" + Keys.ENTER);
        Thread.sleep(1000);
        List<WebElement> product = driver.findElements(By.cssSelector("#searchPage article"));
        Random random = new Random();
        int result = random.nextInt(product.size());
        WebElement dress = product.get(result);
        Thread.sleep(2000);
        WebElement price = dress.findElement(By.cssSelector("span[itemprop=price]"));
        String pricee = price.getText();
        WebElement brand = dress.findElement(By.cssSelector("dd[itemprop=brand]"));
        String brandd = brand.getText();
        WebElement name = dress.findElement(By.cssSelector("dd[itemprop=name]"));
        String namee = name.getText();
        Thread.sleep(2000);
        dress.click();
//        Thread.sleep(5000);
//        List<WebElement> price1 = driver.findElements(By.cssSelector("#productRecap div span[aria-hidden=true]"));
//        WebElement price11 = price1.get(1);
//        String price111 = price11.getText();
//        WebElement name1 = driver.findElement(By.cssSelector("#overview div > span:nth-child(2)"));
//        String name11 = name1.getText();
//        WebElement brand1 = driver.findElement(By.cssSelector("span[itemprop=name]"));
//        String brand11 = brand1.getText();
//        Thread.sleep(1000);
//        Assert.assertEquals(namee, name11, "fail name");
//        Assert.assertEquals(brandd, brand11, "fail brand11");
//        Assert.assertEquals(pricee, price111, "fail price");
        driver.quit();


    }
}