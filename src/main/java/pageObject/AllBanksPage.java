package pageObject;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllBanksPage extends HomePage{

    @FindBy(xpath = "//table[@id='bel_banks']//tr/td[@align='left'][1]")
    private List<WebElement> nums;

    @FindBy(xpath = "//table[@id='bel_banks']//th[@data-column='0']")
    private WebElement numsCollumn;

    @FindBy(xpath = "//table[@id='bel_banks']//tr/td[@align='left'][2]/a/b")
    private List<WebElement> names;

    @FindBy(xpath = "//table[@id='bel_banks']//th[@data-column='2']")
    private WebElement namesCollumn;

    public AllBanksPage(WebDriver driver) {
        super(driver);
    }

    public List<String> setAllNums() {
        List<String> elements = new ArrayList<String>();
        for (WebElement element : nums) {
            elements.add(element.getText());
        }
        return elements;
    }

    public List<String> setAllNames() {
        List<String> elements = new ArrayList<String>();
        for (WebElement element : names) {
            elements.add(element.getText());
        }
        return elements;
    }

    public WebElement numsCollumn() {
        return numsCollumn;
    }

    public WebElement namesCollumn() {
        return namesCollumn;
    }

    public AllBanksPage changeToAscSort(WebElement element) {
        element.click();
        String attribute = element.getAttribute("aria-sort");
        if (attribute.contentEquals("ascending")) {
            return this;
        } else {
            element.click();
            return this;
        }
    }

    public AllBanksPage changeToDescSort(WebElement element) {
        element.click();
        String attribute = element.getAttribute("aria-sort");
        if (attribute.contentEquals("descending")) {
            return this;
        } else {
            element.click();
            return this;
        }
    }


}
