package selpractice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class TakeScreenShots {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techtars.com/");

        File srcScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir")+ "\\screenshots\\" + "HomePage.png";

        FileHandler.copy(srcScreenshotFile,new File(destinationPath));

        driver.quit();

    }
}
