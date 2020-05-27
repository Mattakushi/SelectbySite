package utilities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void setElementText(By by, String text) {
        List<WebElement> elementList = driver.findElements(by);
        for (WebElement element : elementList) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].innerHTML = \"" + text + "\";", element);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        }
    }

    public void setElementAttribute(By by, String attr, String value) {
        List<WebElement> elementList = driver.findElements(by);
        for (WebElement element : elementList) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].setAttribute('" + attr + "', '" + value + "');", element);
        }
    }

    public void removeElements(By by) {
        List<WebElement> elementsList = driver.findElements(by);
        for (WebElement element : elementsList) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].remove();", element);
        }
    }

}
