import static java.util.Collections.max;
import static java.util.Collections.min;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AlphanumComparator;

public class KursPageTable {

    static pageObject.HomePage HomePage;
    static pageObject.KursPage KursPage;
    private static final AlphanumComparator Comparator = new AlphanumComparator();

    WebDriver driver;

    @BeforeClass
    public void setup() throws AWTException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage = PageFactory.initElements(driver, pageObject.HomePage.class);
        KursPage = PageFactory.initElements(driver, pageObject.KursPage.class);
        HomePage.goUrl();
        HomePage.goToKursPage();
    }

    @Test
    public void sortByName() {
        KursPage.changeToAscSort(KursPage.nameColumn());
        List<String> List = KursPage.setAllNames();
        Collections.sort(List, Comparator);
        Assert.assertEquals(KursPage.setAllNames(), List);
        KursPage.changeToDescSort(KursPage.nameColumn());
        Collections.sort(List, Comparator.reversed());
        Assert.assertEquals(KursPage.setAllNames(), List);
    }

    @Test
    public void sortByUsdBuy() {
        KursPage.changeToAscSort(KursPage.usdBuyColumn());
        List<String> List = KursPage.setUsdBuy();
        Collections.sort(List, Comparator);
        Assert.assertEquals(KursPage.setUsdBuy(), List);
        KursPage.changeToDescSort(KursPage.usdBuyColumn());
        Collections.sort(List, Comparator.reversed());
        Assert.assertEquals(KursPage.setUsdBuy(), List);
    }

    @Test
    public void sortByUsdSell() {
        KursPage.changeToAscSort(KursPage.usdSellColumn());
        List<String> List = KursPage.setUsdSell();
        Collections.sort(List, Comparator);
        Assert.assertEquals(KursPage.setUsdSell(), List);
        KursPage.changeToDescSort(KursPage.usdSellColumn());
        Collections.sort(List, Comparator.reversed());
        Assert.assertEquals(KursPage.setUsdSell(), List);
    }

    @Test
    public void sortByEurBuy() {
        KursPage.changeToAscSort(KursPage.eurBuyColumn());
        List<String> List = KursPage.setEurBuy();
        Collections.sort(List, Comparator);
        Assert.assertEquals(KursPage.setEurBuy(), List);
        KursPage.changeToDescSort(KursPage.eurBuyColumn());
        Collections.sort(List, Comparator.reversed());
        Assert.assertEquals(KursPage.setEurBuy(), List);
    }

    @Test
    public void sortByEurSell() {
        KursPage.changeToAscSort(KursPage.eurSellColumn());
        List<String> List = KursPage.setEurSell();
        Collections.sort(List, Comparator);
        Assert.assertEquals(KursPage.setEurSell(), List);
        KursPage.changeToDescSort(KursPage.eurSellColumn());
        Collections.sort(List, Comparator.reversed());
        Assert.assertEquals(KursPage.setEurSell(), List);
    }

    @Test
    public void sortByRubBuy() {
        KursPage.changeToAscSort(KursPage.rubBuyColumn());
        List<String> List = KursPage.setRubBuy();
        Collections.sort(List, Comparator);
        Assert.assertEquals(KursPage.setRubBuy(), List);
        KursPage.changeToDescSort(KursPage.rubBuyColumn());
        Collections.sort(List, Comparator.reversed());
        Assert.assertEquals(KursPage.setRubBuy(), List);
    }

    @Test
    public void sortByRubSell() {
        KursPage.changeToAscSort(KursPage.rubSellColumn());
        List<String> List = KursPage.setRubSell();
        Collections.sort(List, Comparator);
        Assert.assertEquals(KursPage.setRubSell(), List);
        KursPage.changeToDescSort(KursPage.rubSellColumn());
        Collections.sort(List, Comparator.reversed());
        Assert.assertEquals(KursPage.setRubSell(), List);
    }

    @Test
    public void selectBestBank() {
        System.out.println(KursPage.setBestBank());
    }

    @AfterClass
    public void down() {
        driver.quit();
    }
}
