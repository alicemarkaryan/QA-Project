package QaAutomation;

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

public class GreetzWeb {

    private WebDriver driver;
    private static final int TimeOut = 15;





    @BeforeClass //open browser and login one time before all tests
    public void BeforeClass () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.greetz.nl/");
        WebDriverWait wait = new WebDriverWait(driver,15);

        By logelem=By.xpath("//a[@class='page-header__navigation-item item-user']");
        WebElement log = wait.until(ExpectedConditions.elementToBeClickable(logelem));
        log.click();
        By passelem=By.xpath("//span[@class='b-list--item-subject']");
         WebElement pass=driver.findElement(passelem);
        pass.click();
        By loginElem=(By.xpath("//input[@type='email']"));
          WebElement login=wait.until(ExpectedConditions.elementToBeClickable(loginElem));
          login.click();
        login.sendKeys("alisa.markaryan@yahoo.com");
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.click();
        password.sendKeys("Basicitcentre"+ Keys.ENTER);

    }

    @BeforeMethod //find and click in flowers page before tests
    public void BeforeMethod() throws InterruptedException {
        Actions action=new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,15);
      String flowers="Bloemen";
        By flower1Elem=By.xpath("//div[@class='content-menu--container']//*[text()= '" + flowers + "']");

        WebElement flower1=wait.until(ExpectedConditions.visibilityOfElementLocated(flower1Elem));
        action.moveToElement(flower1).perform();
        String Boeket="Boeketten";
        By flow=By.xpath("//*[@href='/bloemen/gemengde-boeketten']");
        WebElement flw=wait.until(ExpectedConditions.elementToBeClickable(flow));
        flw.click();

    }



       @Test
    public void Test1() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,20);
           By allProdsLoc=By.className("b-products-grid__item-preview");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(allProdsLoc,30));
           By produ=By.xpath("//*[@class='b-products-grid__item']");
        List<WebElement> product=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(produ,20));
        Random rand=new Random();
        int result=rand.nextInt(product.size());
        WebElement flower=product.get(result);
        Thread.sleep(2000);
        By pricesel=By.xpath(".//g-price[@current-price='item.source.currentPrice']");
        WebElement price =flower.findElement(pricesel);
        String priceStr=price.getText();
        String priceOnee=priceStr.replace(",",".");
        double priceOne=Double.parseDouble(priceOnee);
        System.out.println(priceOne);
         By nameSelec=By.xpath(".//div[@class='b-products-grid__item-title']");
           WebElement name=flower.findElement(nameSelec);
           String nameStr=name.getText();
        System.out.println(nameStr);

        By favselec=By.xpath(".//div[@class='b-favourite']");
        wait.until(ExpectedConditions.elementToBeClickable(favselec));
           WebElement Fav=wait.until(ExpectedConditions.elementToBeClickable(favselec));
           Fav.click();
           By goFavSelec=By.xpath("//*[@data-qa-ref='profile-icon']");
           WebElement goFav=driver.findElement(goFavSelec);
           goFav.click();
           By goFav1Sele=By.xpath("//*[text()='Favorieten']");
           WebElement goFav1=driver.findElement(goFav1Sele);
           goFav1.click();
           By fav1Selec=By.xpath("//div[@class='favorite-item']");
           WebElement fav1=wait.until(ExpectedConditions.elementToBeClickable(fav1Selec));
           fav1.click();
           By name1Selec=By.xpath("//h1[@ng-bind='gift.title']");
           WebElement name1=wait.until(ExpectedConditions.elementToBeClickable(name1Selec));
           String name2=name1.getText();
        System.out.println(name2);
           WebElement price2=driver.findElement(By.xpath("//*[@class='price-normal']"));
        String price3=price2.getText();
        String price4=price3.replace("€ ","");
        String price5=price4.replace(",",".");
        double priceTwo=Double.parseDouble(price5);
        System.out.println(price5);
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
        WebDriverWait wait=new WebDriverWait(driver,20) ;
        By allProdsLoc=By.className("b-products-grid__item-preview");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(allProdsLoc,30));
        By produ=By.xpath("//*[@class='b-products-grid__item']");
        List<WebElement> product12=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(produ,20));
        wait.until(ExpectedConditions.elementToBeClickable(produ));
        Random random=new Random();
        int result = random.nextInt(product12.size());
        WebElement flower2 = product12.get(result);
        By pri= By.xpath(".//g-price[@current-price='item.source.currentPrice']");
        WebElement price=flower2.findElement(pri);
        flower2.click();
        By goFavSelec=By.xpath("//*[@data-qa-ref='profile-icon']");
        WebElement goFav=driver.findElement(goFavSelec);
        goFav.click();
        By favv=By.xpath("//*[text()='Favorieten']");
        WebElement fav=driver.findElement(favv);
        fav.click();
        By fav1Selec=By.xpath("//div[@class='favorite-item']");
        WebElement fav1=wait.until(ExpectedConditions.elementToBeClickable(fav1Selec));
        fav1.click();
        By nam=By.xpath("//h1[@ng-bind='gift.title']");
        WebElement name1=wait.until(ExpectedConditions.elementToBeClickable(nam));
        String name2=name1.getText();
        System.out.println(name2);
        By prri=By.xpath("//*[@class='price-normal']");
        WebElement price2=wait.until(ExpectedConditions.elementToBeClickable(prri));
        String price3=price2.getText();
        String price4=price3.replace("€ ","");
        String price5=price4.replace(",",".");
        double priceTwo=Double.parseDouble(price5);
        System.out.println(price5);
        By goo=By.xpath("//*[@data-qa-ref='profile-icon']");
        WebElement goFavv=driver.findElement(goo);
        goFavv.click();
        WebElement goFav1=driver.findElement(By.xpath("//*[text()='Favorieten']"));
        goFav1.click();
        By faa=By.xpath("//div[@class='favorite-item']");
        WebElement fav111=wait.until(ExpectedConditions.elementToBeClickable(faa));
        fav111.click();
        By naa=By.xpath("//h1[@ng-bind='gift.title']");
        WebElement name=driver.findElement(naa);
        String namee=name.getText();
        By prii=By.xpath("//*[@class='price-normal']");
        WebElement price0=wait.until(ExpectedConditions.elementToBeClickable(prii));
        String price1=price0.getText();
        String price7=price1.replace("€ ","");
        String price8=price7.replace(",",".");
        double priceOne=Double.parseDouble(price8);
        System.out.println(price8);

        Assert.assertTrue(this.checkprices(priceOne,priceTwo),"doesn't equal prices");
        Assert.assertTrue(this.checknames(namee,name2), "name doesn't equal");

    }

    @AfterMethod // unfollow the flower in the favorite box after tests
    public void aftermethod() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        By un=By.xpath("//*[@class='page-detail__favorite']");
        WebElement unfav=driver.findElement(un);
        unfav.click();
        Thread.sleep(5000);

    }

    @AfterClass //logout from page one time after all tests
    public void AfterClass() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,20);
        By log=By.xpath("//a[@class='page-header__navigation-item item-user']");
        WebElement logout =driver.findElement(log);
        logout.click();
        By exi=By.xpath("//span[@class='b-list--item-icon-primary']");
        WebElement exit = wait.until(ExpectedConditions.elementToBeClickable(exi));
        exit.click();

        driver.quit();
    }


}
