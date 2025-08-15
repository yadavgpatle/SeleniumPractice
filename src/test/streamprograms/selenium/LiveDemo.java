package streamprograms.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {

    WebDriver driver;

    @Test
    void test1() {

        List<String> price;
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='table table-bordered']//tr//child::td[1]"));

        List<String> originalList = elements.stream().map(WebElement::getText).toList();

        List<String> sortedList = originalList.stream().sorted().toList();

        Assert.assertEquals(originalList, sortedList);

        //get the price of Beans


        do {
            List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered']//tr//child::td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice")).
                    map(s -> getPriceVeggi(s)).collect(Collectors.toList());

            price.forEach(System.out::println);

            if (price.size()<1){

                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        } while (price.size() < 1);

    }

    private String getPriceVeggi(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }
}
