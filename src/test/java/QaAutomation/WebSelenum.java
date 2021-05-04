package QaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WebSelenum {

    @Test
    public void Test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.selenium.dev");
        Thread.sleep(3000);
        WebElement downloadelem=driver.findElement(By.xpath("//*[contains(text(),'Downloads')]"));
        downloadelem.click();
        Thread.sleep(3000);
        WebElement versionelem=driver.findElement(By.xpath("//*[contains(text(),'3.141.59')]"));
        String versionSelem=versionelem.getText();
        System.out.println(versionSelem);
        Thread.sleep(2000);
        WebElement search=driver.findElement(By.xpath("//input[@id='gsc-i-id1']"));
        search.sendKeys("selenium"+ Keys.ENTER);
        Thread.sleep(5000);
       List<WebElement> selemElem=driver.findElements(By.xpath("//*[contains(text(),'Selenium')]"));
             //  "//*[contains(text(),'Selenium')]"));
        //"//a[@class='gs-title']"
       Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();

       for (WebElement e: selemElem){
           String selemtext=e.getText();
           String selemln=selemtext.replace("\n","");
           System.out.println(selemtext);
           softAssert.assertTrue(this.checkSelen(selemtext,"Selenium"),"word doesn't match");
       }
        Thread.sleep(5000);
        softAssert.assertTrue(this.checkVersion(versionSelem,"3.141.59"), "Version doesn't equal 3.141.59");
        softAssert.assertAll();
        driver.quit();
    }

    public boolean checkVersion(String a, String b){
        return a.equals(b);
    }

    public boolean checkSelen(String a, String b){
        return a.equalsIgnoreCase(b);
    }
}
