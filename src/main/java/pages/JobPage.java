package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class JobPage {
    private WebDriver driver;
    private  By jobCheckLoc= By.xpath("//*[@id='jobsfilter-category']//child::label[3]");
    private By JobsLoc=By.xpath("//*[@class='job_list_company_title']");
    private By checkLoc=By.xpath("//input[@checked='checked']");
    public JobPage(WebDriver driver){
        this.driver=driver;
    }
    public void JobPage(){
        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement checkedElem=wait.until(ExpectedConditions.elementToBeClickable(checkLoc));
        if(checkedElem.isSelected()){
            System.out.println("Job is  selected");
        }
        else{
            System.out.println("Job doesn't selected");
        }
        WebElement jobCount=driver.findElement(jobCheckLoc);
        String checkedStr=jobCount.getText().replaceAll("[^0-9]","");
        int countJob=Integer.parseInt(checkedStr);
        System.out.println(countJob);

        List<WebElement> JobList=wait.until(ExpectedConditions.numberOfElementsToBeLessThan(JobsLoc,50));
        int size=JobList.size();
        System.out.println(size);
        Assert.assertTrue(this.check(size,countJob)," size doesn't match");
    }

    public boolean check(int a, int b){
        return a==b;
    }



}
