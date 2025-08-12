package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assessment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption3")).click();

        String selectedOption = driver.findElement(By.xpath("//label[@for='honda']")).getText().trim();
        System.out.println(selectedOption);

        Select opn = new Select(driver.findElement(By.id("dropdown-class-example")));
        opn.selectByVisibleText(selectedOption);

        driver.findElement(By.id("name")).sendKeys(selectedOption);
        driver.findElement(By.id("alertbtn")).click();


        Alert alert = driver.switchTo().alert();
        String massage = alert.getText();

        if (massage.contains(selectedOption)) {

            System.out.println("Alert message success");

        } else

            System.out.println("Something wrong with execution");

        System.out.println(massage);
    }
}
