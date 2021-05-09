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
            WebElement versionelem=driver.findElement(By.xpath("//*[@class='right']//p[1]//a[1]"));
        String versionSelem=versionelem.getText();
        String lastVersion="3.141.59";
        System.out.println(versionSelem);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(this.checkVersion(versionSelem,lastVersion),"version doesn't match");
        Thread.sleep(2000);
        WebElement search=driver.findElement(By.xpath("//input[@id='gsc-i-id1']"));
        search.sendKeys("selenium"+ Keys.ENTER);
        Thread.sleep(5000);
       List<WebElement> selemElem=driver.findElements(By.xpath("//*[@class='gs-webResult gs-result']"));
       //"//*[contains(text(),'Selenium')]"
            //*[@class='gs-webResult gs-result']")
        //"//a[@class='gs-title']"
        Thread.sleep(3000);


       for (WebElement e: selemElem) {
           String selemtext = e.getText();
           System.out.println(selemtext);

       String word="selenium";
   softAssert.assertTrue(this.checkSelen(selemtext, word), "word doesn't match");

       }
        Thread.sleep(5000);

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
