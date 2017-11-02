import java.awt.AWTException;
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

    static pageObject.HomePage HomePage;
    static pageObject.AllBanksPage AllBanksPage;
    static utilities.Utils Utils;
    private static final AlphanumComparator Comparator = new AlphanumComparator();

    WebDriver driver;

    @BeforeClass
    public void setup() throws AWTException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage = PageFactory.initElements(driver, pageObject.HomePage.class);
        AllBanksPage = PageFactory.initElements(driver, pageObject.AllBanksPage.class);
        Utils = new Utils(driver);
        HomePage.goUrl();
        HomePage.goToAllBanksPage();
    }

//    @Test
//    public void sortByNumsAsc() {
//        AllBanksPage.changeToAscSort(AllBanksPage.numsCollumn());
//        ArrayList<String> AscListNums = AllBanksPage.setAllNums();
//        Collections.sort(AscListNums, Comparator);
//        Assert.assertEquals(AllBanksPage.setAllNums(), AscListNums);
//    }
//
//    @Test
//    public void sortByNumsDesc() {
//        AllBanksPage.changeToDescSort(AllBanksPage.numsCollumn());
//        ArrayList<String> DescListNums = AllBanksPage.setAllNums();
//        Collections.sort(DescListNums, Comparator.reversed());
//        Assert.assertEquals(AllBanksPage.setAllNums(), DescListNums);
//    }
//
//    @Test
//    public void sortByNamesAsc() {
//        AllBanksPage.changeToAscSort(AllBanksPage.namesCollumn());
//        ArrayList<String> AscListName = AllBanksPage.setAllNames();
//        Collections.sort(AscListName, Comparator);
//        Assert.assertEquals(AllBanksPage.setAllNames(), AscListName);
//    }
//
//    @Test
//    public void sortByNamesDesc() {
//        AllBanksPage.changeToDescSort(AllBanksPage.namesCollumn());
//        ArrayList<String> DescListName = AllBanksPage.setAllNames();
//        Collections.sort(DescListName, Comparator.reversed());
//        Assert.assertEquals(AllBanksPage.setAllNames(), DescListName);
//    }

    @Test
    public void checkAllBanks() {
        Assert.assertEquals(AllBanksPage.setAllNames().size(), 30);
    }

    @Test
    public void checkAllBanksFail() {
        Utils.removeElements(By.xpath("//tr[@class='static sectiontableentry1 odd']"));
        Assert.assertEquals(AllBanksPage.setAllNames().size(), 30);
    }

    @AfterClass
    public void down() {
        driver.quit();
    }

}
