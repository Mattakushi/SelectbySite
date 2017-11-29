package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[@title='Все банки Беларуси']")
    private WebElement allBanksPage;

    @FindBy(xpath = "//a[@title='Курсы Валют']")
    private WebElement kursPage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage goUrl(){
        driver.get("https://select.by/");
        return this;
    }

    public HomePage goToAllBanksPage(){
        allBanksPage.click();
        return this;
    }

    public HomePage goToKursPage() {
        kursPage.click();
        return this;
    }

}
