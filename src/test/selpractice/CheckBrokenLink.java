package selpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CheckBrokenLink {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        SoftAssert softAssert = new SoftAssert();


//        String url = driver.findElement(By.xpath("//a[text()='Broken Link']")).getDomAttribute("href");
//        System.out.println(url);

//        try {
//            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
//            conn.setRequestMethod("HEAD");
//            conn.connect();
//            int respCode = conn.getResponseCode();
//            System.out.println(respCode);
//
//            if (respCode > 400) {
//                Assert.fail();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            driver.quit();
//        }

        List<WebElement> a_elements = driver.findElements(By.xpath("//table[@class='gf-t']//a"));

        for (WebElement ele : a_elements) {
            String url = ele.getDomAttribute("href");
            System.out.println(url);

            if (url.equals("#")) {
                url = "https://rahulshettyacademy.com/AutomationPractice/#";
            }
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int response_code = conn.getResponseCode();
            System.out.println(response_code);

            if (response_code > 400) {
                System.out.println("This link with text " + ele.getText() + " is broken with code: " + response_code);
                softAssert.fail();

            }
        }
        softAssert.assertAll();
        driver.quit();
    }
}
