import java.awt.AWTException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AlphanumComparator;
import utilities.Utils;

public class AllBanksTable {

    WebDriver driver;
    static pageObject.AllBanksPage AllBanksPage;
    static utilities.Utils Utils;
    private static final AlphanumComparator Comparator = new AlphanumComparator();


    @BeforeClass
    public void setup() throws AWTException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AllBanksPage = PageFactory.initElements(driver, pageObject.AllBanksPage.class);
        Utils = new Utils(driver);
        AllBanksPage.goHomeUrl()
              .goToAllBanksPage();
        Utils.setElementAttribute(By.xpath("//table[@id='bel_banks']//tr[1]"), "class", "sectiontableentry1 odd");
    }

    @Test
    public void sortByNumsAsc() {
        AllBanksPage.changeToAscSort(AllBanksPage.numsCollumn());
        List<String> AscListNums = AllBanksPage.setAllNums();
        Collections.sort(AscListNums, Comparator);
        Assert.assertEquals(AllBanksPage.setAllNums(), AscListNums);
    }

    @Test
    public void sortByNumsDesc() {
        AllBanksPage.changeToDescSort(AllBanksPage.numsCollumn());
        List<String> DescListNums = AllBanksPage.setAllNums();
        Collections.sort(DescListNums, Comparator.reversed());
        Assert.assertEquals(AllBanksPage.setAllNums(), DescListNums);
    }

    @Test
    public void sortByNamesAsc() {
        AllBanksPage.changeToAscSort(AllBanksPage.namesCollumn());
        List<String> AscListName = AllBanksPage.setAllNames();
        Collections.sort(AscListName, Comparator);
        Assert.assertEquals(AllBanksPage.setAllNames(), AscListName);
    }

    @Test
    public void sortByNamesDesc() {
        AllBanksPage.changeToDescSort(AllBanksPage.namesCollumn());
        List<String> DescListName = AllBanksPage.setAllNames();
        Collections.sort(DescListName, Comparator.reversed());
        Assert.assertEquals(AllBanksPage.setAllNames(), DescListName);
    }

    @Test
    public void checkAllBanks() {
        Assert.assertEquals(AllBanksPage.setAllNames().size(), 30);
    }

    @Test(priority = 1)
    public void checkAllBanksFail() {
        Utils.removeElements(By.xpath("//table[@id='bel_banks']//tr[@data-row-index='0']"));
        Assert.assertEquals(AllBanksPage.setAllNames().size(), 29);
    }

    @AfterClass
    public void down() {
        driver.quit();
    }

}
