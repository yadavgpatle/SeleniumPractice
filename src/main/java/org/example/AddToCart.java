package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddToCart {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
        login(driver, wait);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));

        List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));

        for (WebElement product : products) {

            product.click();

        }

        driver.findElement(By.partialLinkText("Checkout")).click();

    }

    public static void login(WebDriver driver, WebDriverWait wait) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");

        driver.findElement(By.xpath("//*[text() =' User']")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));

        driver.findElement(By.id("okayBtn")).click();

        Select seObj = new Select(driver.findElement(By.cssSelector("select[class = form-control]")));
        seObj.selectByVisibleText("Teacher");

        driver.findElement(By.id("signInBtn")).click();
    }
}
