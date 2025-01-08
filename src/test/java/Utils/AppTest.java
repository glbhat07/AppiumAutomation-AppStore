package Utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AppTest {

    static AppiumDriver driver;

    public static void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "13.0");
        capabilities.setCapability("appium:deviceName", "Pixel 6 Pro API 33");
        capabilities.setCapability("appium:appPackage", "cm.aptoide.pt");
        capabilities.setCapability("appium:appActivity", "cm.aptoide.pt.view.MainActivity");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:udid", "emulator-5554");


        URL url = new URL("http://localhost:4723");
        driver = new AppiumDriver(url, capabilities);
    }


    public static void moveToHomeScreen() throws InterruptedException, IOException {
        openApp();
        skipAd();
    }

    public static void skipAd() throws InterruptedException {
        String SkipButton = "new UiSelector().resourceId(\"cm.aptoide.pt:id/skip_button\")";
        driver.findElement(AppiumBy.androidUIAutomator(SkipButton)).click();
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        driver.quit();
    }

    public static void captureScreenshot(String name, int i) throws IOException {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Destination = new File("src/test/resources/FailedScenarios/" + name+ i + " screenShot.png");
        Files.copy(screenShot.toPath(), Destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

}
