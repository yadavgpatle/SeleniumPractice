import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class CheckBrokenLink {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

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

        String urls;

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        List<WebElement> a_elements = footerDriver.findElements(By.xpath("//a"));

        HttpURLConnection conn = null;

        for (WebElement ele: a_elements){
           urls = ele.getDomAttribute("href");
            System.out.println(urls);


//            try {
//                conn = (HttpURLConnection) new URL(urls).openConnection();
//                conn.setRequestMethod("HEAD");
//                conn.connect();
//                int respCode = conn.getResponseCode();
//                System.out.println(respCode);
//
//
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            finally {
//                driver.quit();
//            }

        }

    }
}
