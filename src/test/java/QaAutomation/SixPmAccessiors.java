package QaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SixPmAccessiors {
    @Test
    public void testSixPm() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.6pm.com");
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        WebElement elem = driver.findElement(By.xpath("//a[@href='/c/accessories']"));
        actions.moveToElement(elem).perform();
        Thread.sleep(3000);
        WebElement findElem = driver.findElement(By.xpath("//*[text()='Jewelry']"));
        findElem.click();
        Thread.sleep(5000);
        WebElement prices = driver.findElement(By.cssSelector("#searchFilters div ul[aria-labelledby='priceFacet']"));
        List<WebElement> price = prices.findElements(By.tagName("li"));
        price.get(1).click();
        String price1 = price.get(1).getText();
        Thread.sleep(100);
        String price1Sub = price1.substring(1, 3);
        double b = Double.parseDouble(price1Sub);
        System.out.println(b);
        Thread.sleep(1000);
        List<WebElement> allPrice = driver.findElements(By.cssSelector("#searchPage article span[itemprop=price]"));
        for (WebElement e : allPrice) {
            String p = e.getText();
            String priceSub = p.substring(1, 5);
            double a = Double.parseDouble(priceSub);
            System.out.println(a);
            Assert.assertTrue(this.check(b, a), " price over the actual value of the product(25 USD)");
        }
        Thread.sleep(5000);
        driver.quit();
    }

    public boolean check(double i, double j) {
        return i >= j;
    }
}
