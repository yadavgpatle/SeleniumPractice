package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class GetWindows {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//*[text() ='Click Here']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        String childText = driver.findElement(By.cssSelector("div[class=example]")).getText();

        System.out.println(childText);

        driver.switchTo().window(parentId);

        String parentText = driver.findElement(By.xpath("//div[@class='example']//following-sibling::h3")).getText();

        System.out.println(parentText);

        driver.close();
        driver.quit();
    }
}
