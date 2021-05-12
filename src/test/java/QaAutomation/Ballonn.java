package QaAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.List;
import java.util.Random;

public class Ballonn {
    @Test

            public void TestBallonn() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        driver.get("https://www.greetz.nl/ballonnen");
        Random rand=new Random();
        By productSel=By.xpath("//div[@class='b-products-grid__item']");
        List <WebElement> product=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productSel,10));
        int result=rand.nextInt(product.size());
        WebElement ballonn=product.get(result);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ballonn);
        wait.until(ExpectedConditions.elementToBeClickable(ballonn));
        ballonn.click();
        By qualitySel=By.xpath("//*[@data-qa-ref='product-amount']");
        WebElement quality=wait.until(ExpectedConditions.elementToBeClickable(qualitySel));
        By priceSelec=By.xpath("//*[@data-qa-ref='normal-price']");
        WebElement price=wait.until(ExpectedConditions.visibilityOfElementLocated(priceSelec));
        String priceStr=price.getText();
        String priceStr1=priceStr.replace(",",".");
        String priceRep=priceStr1.replaceAll("[^0-9.]","");
        double realPrice=Double.parseDouble(priceRep);
        System.out.println(realPrice);
        quality.sendKeys(Keys.CONTROL+"a");
        quality.sendKeys(Keys.DELETE);
        quality.sendKeys("3"+Keys.ENTER);
        double allPrices=3*realPrice;
        WebElement prices=wait.until(ExpectedConditions.visibilityOfElementLocated(priceSelec));
        String pricesStr=prices.getText();
        String pricesStr1=pricesStr.replace(",",".");
        String pricesRep=pricesStr1.replaceAll("[^0-9.]","");
        double realPrices=Double.parseDouble(pricesRep);
        System.out.println(realPrices);
        Assert.assertTrue(this.check(realPrices,allPrices));
        driver.quit();



    }


    public boolean check(double a, double b){
        return a==b;
    }

}
