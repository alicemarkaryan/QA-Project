package QaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SixpmResultTest {
    @Test
    public void testSearchResult() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Alisa\\IdeaProjects\\qa.project\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https:www.6pm.com");
        Thread.sleep(5000);

        List<WebElement> products=driver.findElements(By.cssSelector("#searchPage article"));
        for(WebElement elem: products){
            String price=elem.getText();
            System.out.println(price);
        }
        Assert.assertEquals(products.size(),100, "Product should be 98 but, " +products.size());
            driver.quit();
    }
}
