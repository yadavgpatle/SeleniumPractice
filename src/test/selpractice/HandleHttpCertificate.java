import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleHttpCertificate {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

        Thread.sleep(5000);
        driver.quit();
    }
}
