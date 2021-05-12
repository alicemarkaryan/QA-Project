package AutomationQa;

import net.bytebuddy.dynamic.DynamicType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebDriverWait wait=new WebDriverWait(driver,20);
        By elemSel=By.id("searchAll");
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(elemSel));
        elem.sendKeys("dresses" + Keys.ENTER);
        By productSel=By.cssSelector("#searchPage article");
        List<WebElement> product = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productSel,20));
        Random random = new Random();
        int result = random.nextInt(product.size());
        WebElement dress = product.get(result);
        By priceSelec=By.cssSelector("span[itemprop=price]");
        WebElement price = dress.findElement(priceSelec);
        String pricee = price.getText();
        WebElement brand = dress.findElement(By.cssSelector("dd[itemprop=brand]"));
        String brandd = brand.getText();
        WebElement name = dress.findElement(By.cssSelector("dd[itemprop=name]"));
        String namee = name.getText();

        wait.until(ExpectedConditions.elementToBeClickable(dress));
        dress.click();
        By price1Selec=By.cssSelector("#productRecap div span[aria-hidden=true]");
        List<WebElement> price1 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(price1Selec));
        WebElement price11 = price1.get(1);
        String price111 = price11.getText();
        WebElement name1 = driver.findElement(By.cssSelector("#overview div > span:nth-child(2)"));
        String name11 = name1.getText();
        WebElement brand1 = driver.findElement(By.cssSelector("span[itemprop=name]"));
        String brand11 = brand1.getText();

        Assert.assertEquals(namee, name11, "fail name");
        Assert.assertEquals(brandd, brand11, "fail brand11");
        Assert.assertEquals(pricee, price111, "fail price");
        driver.quit();


    }
}