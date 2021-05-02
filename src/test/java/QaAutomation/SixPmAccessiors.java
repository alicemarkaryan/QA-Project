package QaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;


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
        List<WebElement> randomPrice = driver.findElements(By.xpath("//ul[@aria-labelledby='priceFacet']//li//span[1]"));
        Random random = new Random();
        int result = random.nextInt(randomPrice.size());
        WebElement prices = randomPrice.get(result);
        Thread.sleep(100);
        prices.click();
        String price1 = prices.getText();

        String priceRep = price1.replace(" and Under", "");
        String priceRep1 = priceRep.replace("$", "");
        String priceOver=priceRep1.replace("and Over","");
        double b = Double.parseDouble(priceOver);
        System.out.println(b);
        Thread.sleep(1000);
        List<WebElement> allPrice = driver.findElements(By.cssSelector("#searchPage article span[itemprop=price]"));
        for (WebElement e : allPrice) {
            String p = e.getText();
            String allPriceRep = p.replace("$", "");
            double a = Double.parseDouble(allPriceRep);
            System.out.println(a);
            Thread.sleep(100);
            if(b<200) {
                Assert.assertTrue(this.checkLess(b, a), "The product price is over the actual mentioned value ");
            }
          if (b>=200)
            {
                Assert.assertTrue(this.checkOver(b,a), "The product price is less  200 usd");
            }
        }

        driver.quit();

    }

    public boolean checkLess(double i, double j) {
        return i >= j;
    }
    public boolean checkOver(double i, double j){
        return i<j;
    }
}
