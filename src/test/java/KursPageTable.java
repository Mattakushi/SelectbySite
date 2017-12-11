import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AlphanumComparator;
import utilities.Utils;

public class KursPageTable {

    WebDriver driver;
    static pageObject.KursPage kursPage;
    static utilities.Utils utils;
    private static final AlphanumComparator COMPARATOR = new AlphanumComparator();

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils = new Utils(driver);
        kursPage = PageFactory.initElements(driver, pageObject.KursPage.class);
        kursPage.goHomeUrl()
              .goToKursPage();
    }

    @Test
    public void sortByName() {
        kursPage.changeToAscSort(kursPage.nameColumn());
        List<String> List = kursPage.setAllNames();
        List.sort(COMPARATOR);
        Assert.assertEquals(kursPage.setAllNames(), List);
        kursPage.changeToDescSort(kursPage.nameColumn());
        List.sort(COMPARATOR.reversed());
        Assert.assertEquals(kursPage.setAllNames(), List);
    }

    @Test
    public void sortByUsdBuy() {
        kursPage.changeToAscSort(kursPage.usdBuyColumn());
        List<String> List = kursPage.setUsdBuy();
        List.sort(COMPARATOR);
        Assert.assertEquals(kursPage.setUsdBuy(), List);
        kursPage.changeToDescSort(kursPage.usdBuyColumn());
        List.sort(COMPARATOR.reversed());
        Assert.assertEquals(kursPage.setUsdBuy(), List);
    }

    @Test
    public void sortByUsdSell() {
        kursPage.changeToAscSort(kursPage.usdSellColumn());
        List<String> List = kursPage.setUsdSell();
        List.sort(COMPARATOR);
        Assert.assertEquals(kursPage.setUsdSell(), List);
        kursPage.changeToDescSort(kursPage.usdSellColumn());
        List.sort(COMPARATOR.reversed());
        Assert.assertEquals(kursPage.setUsdSell(), List);
    }

    @Test
    public void sortByEurBuy() {
        kursPage.changeToAscSort(kursPage.eurBuyColumn());
        List<String> List = kursPage.setEurBuy();
        List.sort(COMPARATOR);
        Assert.assertEquals(kursPage.setEurBuy(), List);
        kursPage.changeToDescSort(kursPage.eurBuyColumn());
        List.sort(COMPARATOR.reversed());
        Assert.assertEquals(kursPage.setEurBuy(), List);
    }

    @Test
    public void sortByEurSell() {
        kursPage.changeToAscSort(kursPage.eurSellColumn());
        List<String> List = kursPage.setEurSell();
        List.sort(COMPARATOR);
        Assert.assertEquals(kursPage.setEurSell(), List);
        kursPage.changeToDescSort(kursPage.eurSellColumn());
        List.sort(COMPARATOR.reversed());
        Assert.assertEquals(kursPage.setEurSell(), List);
    }

    @Test
    public void sortByRubBuy() {
        kursPage.changeToAscSort(kursPage.rubBuyColumn());
        List<String> List = kursPage.setRubBuy();
        List.sort(COMPARATOR);
        Assert.assertEquals(kursPage.setRubBuy(), List);
        kursPage.changeToDescSort(kursPage.rubBuyColumn());
        List.sort(COMPARATOR.reversed());
        Assert.assertEquals(kursPage.setRubBuy(), List);
    }

    @Test
    public void sortByRubSell() {
        kursPage.changeToAscSort(kursPage.rubSellColumn());
        List<String> List = kursPage.setRubSell();
        List.sort(COMPARATOR);
        Assert.assertEquals(kursPage.setRubSell(), List);
        kursPage.changeToDescSort(kursPage.rubSellColumn());
        List.sort(COMPARATOR.reversed());
        Assert.assertEquals(kursPage.setRubSell(), List);
    }

    @Test
    public void selectBestBank() {
        System.out.println(kursPage.setBestBank());
    }

    @AfterClass
    public void down() {
        driver.quit();
    }
}
