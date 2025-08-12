package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope {
    public static <E> void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> elements = driver.findElements(By.xpath("//a"));
        int number = elements.size();
        System.out.println(number);

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        WebElement footerDriverFirst = driver.findElement(By.xpath("//table[@class='gf-t']//td[1]//ul"));
        System.out.println(footerDriverFirst.findElements(By.tagName("a")).size());

        for (int i = 1; i < footerDriverFirst.findElements(By.tagName("a")).size(); i++) {

            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL)
                    .click(footerDriverFirst.findElements(By.tagName("a")).get(i)).build()
                    .perform();
            Thread.sleep(5000);
        }

            Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            driver.switchTo().window(handle);
            System.out.println("Window: " + driver.getTitle());
        }

        driver.quit();
    }
}
