package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a/strong[text()='Все банки Беларуси']")
    private WebElement allBanksPage;

    @FindBy(xpath = "//a/strong[text()='Курсы валют']")
    private WebElement kursPage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage goHomeUrl(){
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
