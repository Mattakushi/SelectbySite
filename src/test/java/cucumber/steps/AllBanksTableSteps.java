//package cucumber.steps;
//
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.ru.Дано;
//import cucumber.api.java.ru.Когда;
//import cucumber.api.java.ru.Тогда;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import utilities.AlphanumComparator;
//
//public class AllBanksTableSteps {
//
//    static pageObject.HomePage HomePage;
//    static pageObject.AllBanksPage AllBanksPage;
//    private static final AlphanumComparator Comparator = new AlphanumComparator();
//
//    WebDriver driver;
//
//    @Before
//    public void prepareDriver() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    @Дано("^страница с таблицой банков$")
//    public void страница_с_таблицой_банков() throws Throwable {
//        HomePage = PageFactory.initElements(driver, pageObject.HomePage.class);
//        HomePage.goUrl();
//        HomePage.goToAllBanksPage();
//    }
//
//    @Когда("^таблица отсортирована по возрастанию нумерации$")
//    public void таблица_отсортирована_по_возрастанию_нумерации() throws Throwable {
//        AllBanksPage = PageFactory.initElements(driver, pageObject.AllBanksPage.class);
//        AllBanksPage.changeToAscSort(AllBanksPage.namesCollumn());
//    }
//
//    @Когда("^таблица отсортирована по убыванию нумерации$")
//    public void таблица_отсортирована_по_убыванию_нумерации() throws Throwable {
//        AllBanksPage = PageFactory.initElements(driver, pageObject.AllBanksPage.class);
//        AllBanksPage.changeToDescSort(AllBanksPage.namesCollumn());
//    }
//
//    @Когда("^таблица отсортирована по возрастанию названию$")
//    public void таблица_отсортирована_по_возрастанию_названию() throws Throwable {
//        AllBanksPage = PageFactory.initElements(driver, pageObject.AllBanksPage.class);
//        AllBanksPage.changeToAscSort(AllBanksPage.namesCollumn());
//    }
//
//    @Когда("^таблица отсортирована по убыванию названий$")
//    public void таблица_отсортирована_по_убыванию_названий() throws Throwable {
//        AllBanksPage = PageFactory.initElements(driver, pageObject.AllBanksPage.class);
//        AllBanksPage.changeToDescSort(AllBanksPage.namesCollumn());
//    }
//
//    @Тогда("^сравниваем сортировку по возрастанию нумерации$")
//    public void сравниваем_сортировку_по_возрастанию_нумерации() throws Throwable {
//        ArrayList<String> AscListNums = AllBanksPage.setAllNums();
//        Collections.sort(AscListNums, Comparator);
//        Assert.assertEquals(AllBanksPage.setAllNums(), AscListNums);
//    }
//
//    @Тогда("^сравниваем сортировку по убыванию нумерации$")
//    public void сравниваем_сортировку_по_убыванию_нумерации() throws Throwable {
//        ArrayList<String> DescListNums = AllBanksPage.setAllNums();
//        Collections.sort(DescListNums, Comparator.reversed());
//        Assert.assertEquals(AllBanksPage.setAllNums(), DescListNums);
//
//    }
//
//    @Тогда("^сравниваем сортировку по возрастанию названий$")
//    public void сравниваем_сортировку_по_возрастанию_названий() throws Throwable {
//        ArrayList<String> AscListName = AllBanksPage.setAllNames();
//        Collections.sort(AscListName, Comparator);
//        Assert.assertEquals(AllBanksPage.setAllNames(), AscListName);
//    }
//
//    @Тогда("^сравниваем сортировку по убыванию названий$")
//    public void сравниваем_сортировку_по_убыванию_названий() throws Throwable {
//        ArrayList<String> DescListName = AllBanksPage.setAllNames();
//        Collections.sort(DescListName, Comparator.reversed());
//        Assert.assertEquals(AllBanksPage.setAllNames(), DescListName);
//    }
//
//    @After
//    public void quitDriver() {
//        driver.quit();
//    }
//
//
//}
