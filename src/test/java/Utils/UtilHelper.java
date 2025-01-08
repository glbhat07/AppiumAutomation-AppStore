package Utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class UtilHelper extends AppTest {

    public static Duration explicitWaitTime = Duration.ofSeconds(10);

    public static WebElement findElement(String locator) {
        String locatorType = locator.split("==")[0];
        String locatorValue = locator.split("==")[1];
        if (locatorType.equals("AndroidUiAutomator")) {
            return driver.findElement(AppiumBy.androidUIAutomator(locatorValue));
        } else if (locatorType.equals("xpath")) {
            return driver.findElement(AppiumBy.xpath(locatorValue));
        } else if (locatorType.equals("id")) {
            return driver.findElement(AppiumBy.id(locatorValue));
        } else if (locatorType.equals("accessibilityId")) {
            return driver.findElement(AppiumBy.accessibilityId(locatorValue));
        }
        return null;
    }

    public static List<WebElement> findElements(String locator) {
        String locatorType = locator.split("==")[0];
        String locatorValue = locator.split("==")[1];
        if (locatorType.equals("AndroidUiAutomator")) {
            return driver.findElements(AppiumBy.androidUIAutomator(locatorValue));
        } else if (locatorType.equals("xpath")) {
            return driver.findElements(AppiumBy.xpath(locatorValue));
        } else if (locatorType.equals("id")) {
            return driver.findElements(AppiumBy.id(locatorValue));
        } else if (locatorType.equals("accessibilityId")) {
            return driver.findElements(AppiumBy.accessibilityId(locatorValue));
        }
        return null;
    }

    public static void clickElement(String locator) {
        findElement(locator).click();
    }

    public static void inputElement(String locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public static Boolean checkMatchingElementsListed(String locator, String text) {
        List<WebElement> elements = findElements(locator);
        for (WebElement element : elements) {
            if (!(element.getText().trim().equalsIgnoreCase(text))) {
                return false;
            }
        }
        return true;
    }

    public static Boolean checkMatchContainsElementsListed(String locator, String text) {
        List<WebElement> elements = findElements(locator);
        for (WebElement element : elements) {
            if (!(element.getText().contains(text))) {
                return false;
            }
        }
        return true;
    }

    public static Boolean checkListOfElementsContainsMatch(String locator, String text) {
        List<WebElement> elements = findElements(locator);
        for (WebElement element : elements) {
            if ((element.getText().contains(text))) {
                return true;
            }
        }
        return false;
    }

    public static void keyboardActions(Keys actionType) {
        Actions action = new Actions(driver);
        action.sendKeys(actionType).build().perform();
    }

    public static void waitForVisibilityOfWebElement(String locator) {
        FluentWait<WebDriver> wait = new WebDriverWait(driver, explicitWaitTime).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(findElement(locator)));
    }

    public static boolean waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((JavascriptExecutor) driver).executeScript("return jQuery.active").toString().equalsIgnoreCase("0");
                } catch (Exception e) {
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            poll(1000);
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10L));
            waits.until(jsLoad);
            waits.until(jQueryLoad);

        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public static void poll(int timeInMs) {
        try {
            Thread.sleep(timeInMs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isElementPresents(String locator) {
        return findElements(locator).size() > 0;
    }

    public static void scrollIntoView(String locator) {
        String locatorValue = locator.split("==")[1];
        driver.findElement(By.xpath(locatorValue));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(locator));
    }

    public static String customElementLocator(String locator, String replaceValue) {
        return locator.replace("{REPLACE}", replaceValue);
    }

    public static void swipeDown(String text1, String text2) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text1 + "\"));"
            ));
            poll(4000);
            scrollDownUntilTextIsVisible(text2);
        } catch (Exception e) {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text2 + "\"));"
            ));
        }
    }

    public static void scrollDownUntilTextIsVisible(String text) {
        boolean isElementFound = false;
        boolean endOfPageReached = false;
        int previousVisibleItemCount = -1;

        while (!isElementFound && !endOfPageReached) {
            try {
                // Attempt to scroll to the element by text
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text + "\"));"
                ));
                isElementFound = true;  // Element is found
            } catch (Exception e) {
                // Element is not found yet, continue scrolling down

                // Get the current list of visible items (e.g., number of elements in the view)
                int currentVisibleItemCount = driver.findElements(AppiumBy.androidUIAutomator(
                        "new UiSelector().scrollable(true)"
                )).size();

                // Check if we've reached the bottom of the page
                if (currentVisibleItemCount == previousVisibleItemCount) {
                    endOfPageReached = true;  // No more items are loading, so stop scrolling
                    break;
                }

                // Update previous item count
                previousVisibleItemCount = currentVisibleItemCount;

                // Swipe down manually since UiScrollable failed to find the text
                swipeDown();

                // Wait for the API/Page to load (adjust the duration as needed)
                try {
                    Thread.sleep(2000);  // Adding a wait time of 2 seconds to load new content
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();  // Handle the interrupt
                }
            }
        }

        if (!isElementFound && endOfPageReached) {
            System.out.println("Reached the end of the page, but element was not found.");
        }
    }

    public static void swipeDown() {
        // Get the size of the screen
        Dimension size = driver.manage().window().getSize();

        // Define swipe start and end points
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.80);  // Start swipe from near the bottom
        int endY = (int) (size.height * 0.20);    // Swipe to near the top

        // Perform swipe action
        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    public static String elementText(String locator) {
        return findElement(locator).getText();
    }


}
