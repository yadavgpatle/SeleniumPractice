package selpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavaScriptExecutor {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> amount = driver.findElements(By.xpath("//*[@class='tableFixHead']//td[4]"));

        int sum = 0;
        for (int i = 0; i < amount.size(); i++) {
            sum += Integer.parseInt(amount.get(i).getText());
        }
        String text = driver.findElement(By.cssSelector(".totalAmount")).getText();
        String split = text.split(":")[1].trim();
        Assert.assertEquals(Integer.parseInt(split), sum);


        driver.quit();
    }
}
