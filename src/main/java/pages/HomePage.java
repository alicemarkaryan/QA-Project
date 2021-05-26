package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    private By searchLoc=By.xpath("//*[@id='jobsfilter-category']");
    private By categoriesLoc=By.xpath("//option[text()='Web/Graphic design']");
    private By searchButtonLok=By.xpath("//*[@class='fa fa-search']");

    public HomePage(WebDriver driver){
        this.driver=driver;

    }

    public void searchJob(){
        WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement searchElem=wait.until(ExpectedConditions.elementToBeClickable(searchLoc));
        searchElem.click();
        WebElement jobElem=wait.until(ExpectedConditions.elementToBeClickable(categoriesLoc));
        jobElem.click();
        WebElement searchButtonElem=driver.findElement(searchButtonLok);
        searchButtonElem.click();
    }

}
