package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Booking {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.booking.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[id=':rh:']")).click();
        WebElement from = driver.findElement(By.cssSelector("input[id=':rh:']"));
        from.sendKeys("Ben");

        List<WebElement> elements = driver.findElements(By.xpath("//ul[@role='group']//li"));

//        for (int i = 0; i < elements.toArray().length; i++) {
//            if (elements.get(i).getText().contains("Bangalore")) {
//                elements.get(i).click();
//            }
//        }

        for (WebElement element: elements){
            if (element.getText().contains("Bangalore")){
                element.click();
            }
        }

    }

}
