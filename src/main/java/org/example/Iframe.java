package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Iframe {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_middle']")));
        String text = driver.findElement(By.cssSelector("div[id='content']")).getText();
        System.out.println(text);
    }
}
