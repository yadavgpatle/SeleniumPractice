package selpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment7 {

    WebDriver driver;

    @BeforeTest
    void beforeClassMethod() {
        this.driver = new ChromeDriver();

        this.driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

    }

    @Test
    public void Assignment() {
        List<WebElement> course = driver.findElements(By.xpath("//table[@name='courses']//tr"));
        System.out.println("Number of columns: " + course.size());

        //(//table[@name='courses']/tbody/tr)[3]/child::*
        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/child::th"));
        System.out.println("Number of columns: " + rows.size());

        List<WebElement> second_rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/child::th"));
        for (WebElement s_rows : second_rows) {
            System.out.println(s_rows.getText());
        }
    }

    @AfterTest
    public void afterClassMethod() {
        this.driver.quit();
    }
}
