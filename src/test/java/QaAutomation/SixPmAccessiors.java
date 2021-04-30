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
    }

    public boolean checkLess(double i, double j) {
        return i >= j;
    }
    public boolean checkOver(double i, double j){
        return i<j;
    }
}
