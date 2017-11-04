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

    public void setSortAttribute(By by, String attr, String value) {
        List<WebElement> elementList = driver.findElements(by);
        for (WebElement element : elementList) {
            ((JavascriptExecutor) driver)
                  .executeScript("arguments[0].setAttribute('" + attr + "', '" + value + "');", element);
        }
    }

    public void setElementText(By by, String text){
        List<WebElement> elementList = driver.findElements(by);
        for(WebElement element : elementList ){
            ((JavascriptExecutor)driver)
                  .executeScript("arguments[0].innerHTML = \""+text+"\";", element);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        }
    }

    public void removeElements(By by) {
        List<WebElement> elementsList = driver.findElements(by);
        for (WebElement element : elementsList) {
            ((JavascriptExecutor) driver)
                  .executeScript("arguments[0].remove();", element);
        }
    }

    transient Object[] elementData;
    private int size;
    public boolean isEmpty() {
        return size == 0;
    }

    public int indexNth(List charList, int n, Object _enum) {
        int index = 0;
        int findTimes = 0;
        if (n == 0) {
            return -1;
        }
        if (charList.isEmpty()) {
            return -1;
        }
        for (Object o : charList) {
            if (o.equals(_enum)) {
                findTimes++;
            }
            if (findTimes >= n) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

}
