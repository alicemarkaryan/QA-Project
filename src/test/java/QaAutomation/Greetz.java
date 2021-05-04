package QaAutomation;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.List;
import java.util.Random;

public class Greetz {

    private WebDriver driver;

    @BeforeClass //open browser and login one time before all tests
    public void BeforeClass () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.greetz.nl/");
        Thread.sleep(2000);
        WebElement log=driver.findElement(By.xpath("//a[@class='page-header__navigation-item item-user']"));
        log.click();
        WebElement pass=driver.findElement(By.xpath("//span[@class='b-list--item-subject']"));
        pass.click();
        Thread.sleep(1000);
        WebElement login=driver.findElement(By.xpath("//input[@type='email']"));
        login.click();
        login.sendKeys("alisa.markaryan@yahoo.com");
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.click();
        password.sendKeys("Basicitcentre"+ Keys.ENTER);
        Thread.sleep(5000);
    }

    @BeforeMethod //find and click in flowers page before tests
    public void BeforeMethod() throws InterruptedException {
        WebElement flower1=driver.findElement(By.xpath("//a[@rel='menu_86881551']"));
        Thread.sleep(1000);
        flower1.click();
        Thread.sleep(1000);
    }



    @Test
    public void Test1() throws InterruptedException {
        List<WebElement> product12=driver.findElements(By.xpath("//*[@class='b-products-grid__item']"));
        Random random=new Random();
        int result = random.nextInt(product12.size());
        WebElement flower2 = product12.get(result);
        Thread.sleep(3000);
        WebElement price=flower2.findElement(By.xpath(".//g-price[@current-price='item.source.currentPrice']"));
        String priceStr=price.getText();
        String priceOnee=priceStr.replace(",",".");
        double priceOne=Double.parseDouble(priceOnee);
        System.out.println(priceOne);
        Thread.sleep(3000);
        WebElement name=flower2.findElement(By.xpath(".//div[@class='b-products-grid__item-title']"));
        String nameStr=name.getText();
        System.out.println(nameStr);
        Thread.sleep(3000);
        WebElement Fav=flower2.findElement(By.xpath(".//div[@class='b-favourite']"));
        Fav.click();
        Thread.sleep(3000);
        WebElement goFav=driver.findElement(By.xpath("//*[@data-qa-ref='profile-icon']"));
        goFav.click();
        WebElement goFav1=driver.findElement(By.xpath("//*[text()='Favorieten']"));
        goFav1.click();
        Thread.sleep(3000);
        WebElement fav1=driver.findElement(By.xpath("//div[@class='favorite-item']"));
        fav1.click();
        Thread.sleep(3000);
        WebElement name1=driver.findElement(By.xpath("//h1[@ng-bind='gift.title']"));
        String name2=name1.getText();
        System.out.println(name2);
        Thread.sleep(3000);
        WebElement price2=driver.findElement(By.xpath("//*[@class='price-normal']"));
        String price3=price2.getText();
        String price4=price3.replace("€ ","");
        String price5=price4.replace(",",".");
        double priceTwo=Double.parseDouble(price5);
        System.out.println(price5);

        Thread.sleep(3000);
        Assert.assertTrue(this.checkprices(priceOne,priceTwo),"doesn't equal prices");
        Assert.assertTrue(this.checknames(nameStr,name2), "name doesn't equal");

    }

    public boolean checkprices(double a, double b){
        return a==b;
    }
    public boolean checknames(String a, String b){
        return a.equals(b);
    }


    @Test
    public void Test2() throws InterruptedException {
        List<WebElement> product12=driver.findElements(By.xpath("//*[@class='b-products-grid__item']"));
        Random random=new Random();
        int result = random.nextInt(product12.size());
        WebElement flower2 = product12.get(result);
        flower2.click();
        Thread.sleep(2000);
        WebElement fav=driver.findElement(By.xpath("//*[@class='page-detail__favorite']"));
        fav.click();
        Thread.sleep(3000);
        WebElement name1=driver.findElement(By.xpath("//h1[@ng-bind='gift.title']"));
        String name2=name1.getText();
        System.out.println(name2);
        Thread.sleep(3000);
        WebElement price2=driver.findElement(By.xpath("//*[@class='price-normal']"));
        String price3=price2.getText();
        String price4=price3.replace("€ ","");
        String price5=price4.replace(",",".");
        double priceTwo=Double.parseDouble(price5);
        System.out.println(price5);
        Thread.sleep(2000);
        WebElement goFav=driver.findElement(By.xpath("//*[@data-qa-ref='profile-icon']"));
        goFav.click();
        WebElement goFav1=driver.findElement(By.xpath("//*[text()='Favorieten']"));
        goFav1.click();
        Thread.sleep(2000);
        WebElement fav1=driver.findElement(By.xpath("//div[@class='favorite-item']"));
        fav1.click();
        Thread.sleep(3000);
        WebElement name=driver.findElement(By.xpath("//h1[@ng-bind='gift.title']"));
        String namee=name.getText();
        System.out.println(namee);
        Thread.sleep(3000);
        WebElement price=driver.findElement(By.xpath("//*[@class='price-normal']"));
        String price1=price.getText();
        String price7=price1.replace("€ ","");
        String price8=price7.replace(",",".");
        double priceOne=Double.parseDouble(price8);
        System.out.println(price8);
        Thread.sleep(5000);
        Assert.assertTrue(this.checkprices(priceOne,priceTwo),"doesn't equal prices");
        Assert.assertTrue(this.checknames(namee,name2), "name doesn't equal");

    }

    @AfterMethod // unfollow the flower in the favorite box after tests
    public void aftermethod() throws InterruptedException {
        WebElement unfav=driver.findElement(By.xpath("//*[@class='page-detail__favorite']"));
        unfav.click();
        Thread.sleep(5000);

    }

    @AfterClass //logout from page one time after all tests
    public void AfterClass() throws InterruptedException {
        WebElement logout = driver.findElement(By.xpath("//a[@class='page-header__navigation-item item-user']"));
        logout.click();
        WebElement exit = driver.findElement(By.xpath("//span[@class='b-list--item-icon-primary']"));
        exit.click();
        Thread.sleep(3000);
        driver.quit();
    }


}
