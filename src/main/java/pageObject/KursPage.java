package pageObject;

import static java.util.Collections.max;
import static java.util.Collections.min;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AlphanumComparator;

public class KursPage {

    WebDriver driver;

    @FindBy(xpath = "//tr[@class='tablesorter-headerRow']/th[@data-column='1']")
    private WebElement nameColumn;

    @FindBy(xpath = "//tr[contains(@class, 'tablesorter-hasChildRow')]/td[2]")
    private List<WebElement> names;

    @FindBy(xpath = "//tr[@class='tablesorter-headerRow']/th[@data-column='2']")
    private WebElement usdBuyColumn;

    @FindBy(xpath = "//tr[contains(@class, 'tablesorter-hasChildRow')]/td[3]")
    private List<WebElement> usdBuy;

    @FindBy(xpath = "//tr[@class='tablesorter-headerRow']/th[@data-column='3']")
    private WebElement usdSellColumn;

    @FindBy(xpath = "//tr[contains(@class, 'tablesorter-hasChildRow')]/td[4]")
    private List<WebElement> usdSell;

    @FindBy(xpath = "//tr[@class='tablesorter-headerRow']/th[@data-column='4']")
    private WebElement eurBuyColumn;

    @FindBy(xpath = "//tr[contains(@class, 'tablesorter-hasChildRow')]/td[5]")
    private List<WebElement> eurBuy;

    @FindBy(xpath = "//tr[@class='tablesorter-headerRow']/th[@data-column='5']")
    private WebElement eurSellColumn;

    @FindBy(xpath = "//tr[contains(@class, 'tablesorter-hasChildRow')]/td[6]")
    private List<WebElement> eurSell;

    @FindBy(xpath = "//tr[@class='tablesorter-headerRow']/th[@data-column='6']")
    private WebElement rubBuyColumn;

    @FindBy(xpath = "//tr[contains(@class, 'tablesorter-hasChildRow')]/td[7]")
    private List<WebElement> rubBuy;

    @FindBy(xpath = "//tr[@class='tablesorter-headerRow']/th[@data-column='7']")
    private WebElement rubSellColumn;

    @FindBy(xpath = "//tr[contains(@class, 'tablesorter-hasChildRow')]/td[8]")
    private List<WebElement> rubSell;

    @FindBy(xpath = "//tr[@class='tablesorter-headerRow')]/th[position() >1, < 9]")
    private List<WebElement> allInfoNames;

    @FindBy(xpath = "//tr[contains(@class, 'tablesorter-hasChildRow')]/td[position() > 1]")
    private List<WebElement> allInfo;

    public KursPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement nameColumn() {
        return nameColumn;
    }

    public WebElement usdBuyColumn() {
        return usdBuyColumn;
    }

    public WebElement usdSellColumn() {
        return usdSellColumn;
    }

    public WebElement eurBuyColumn() {
        return eurBuyColumn;
    }

    public WebElement eurSellColumn() {
        return eurSellColumn;
    }

    public WebElement rubBuyColumn() {
        return rubBuyColumn;
    }

    public WebElement rubSellColumn() {
        return rubSellColumn;
    }

    public List<String> setAllNames() {
        List<String> elements = new ArrayList<String>();
        for (int x = 0; x < names.size(); x++) {
            elements.add(names.get(x).getText());
        }
        return elements;
    }

    public List<String> setUsdBuy() {
        List<String> elements = new ArrayList<String>();
        for (int x = 0; x < usdBuy.size(); x++) {
            elements.add(usdBuy.get(x).getText());
        }
        return elements;
    }

    public List<String> setUsdSell() {
        List<String> elements = new ArrayList<String>();
        for (int x = 0; x < usdSell.size(); x++) {
            elements.add(usdSell.get(x).getText());
        }
        return elements;
    }


    public List<String> setEurBuy() {
        List<String> elements = new ArrayList<String>();
        for (int x = 0; x < eurBuy.size(); x++) {
            elements.add(eurBuy.get(x).getText());
        }
        return elements;
    }


    public List<String> setEurSell() {
        List<String> elements = new ArrayList<String>();
        for (int x = 0; x < eurSell.size(); x++) {
            elements.add(eurSell.get(x).getText());
        }
        return elements;
    }


    public List<String> setRubBuy() {
        List<String> elements = new ArrayList<String>();
        for (int x = 0; x < rubBuy.size(); x++) {
            elements.add(rubBuy.get(x).getText());
        }
        return elements;
    }


    public List<String> setRubSell() {
        List<String> elements = new ArrayList<String>();
        for (int x = 0; x < rubSell.size(); x++) {
            elements.add(rubSell.get(x).getText());
        }
        return elements;
    }

    public List<String> setBestBank() {
        int[] indexUsdBuy = IntStream.range(0, setUsdBuy().size())
              .filter(i -> setUsdBuy().get(i).equals(max(setUsdBuy())))
              .toArray();
        int[] indexUsdSell = IntStream.range(0, setUsdSell().size())
              .filter(i -> setUsdSell().get(i).equals(min(setUsdSell())))
              .toArray();
        int[] indexEurBuy = IntStream.range(0, setEurBuy().size())
              .filter(i -> setEurBuy().get(i).equals(max(setEurBuy())))
              .toArray();
        int[] indexEurSell = IntStream.range(0, setEurSell().size())
              .filter(i -> setEurSell().get(i).equals(min(setEurSell())))
              .toArray();
        int[] indexRubBuy = IntStream.range(0, setRubBuy().size())
              .filter(i -> setRubBuy().get(i).equals(max(setRubBuy())))
              .toArray();
        int[] indexRubSell = IntStream.range(0, setRubSell().size())
              .filter(i -> setRubSell().get(i).equals(min(setRubSell())))
              .toArray();
        int[][] allIndexs = {indexUsdBuy, indexUsdSell, indexEurBuy, indexEurSell, indexRubBuy, indexRubSell};
        byte[] count = new byte[names.size()];
        for (int i = 0; i < allIndexs.length; i++) {
            for (int j = 0; j < allIndexs[i].length; j++) {
                count[allIndexs[i][j]]++;
            }
        }
        byte max = count[0];
        boolean repeat = false;
        byte c = 0;
        for (byte i = 0; i < 6; i++) {
            if (count[i] == max) {
                repeat = true;
            }
            if (count[i] > max) {
                max = count[i];
                repeat = false;
                c = i;
            }
        }
        List<String> elements = new ArrayList<String>();
        for (int x = 0; x < 1; x++) {
            elements.add("Банк с лучшими курсами: " + names.get(c).getText());
        }
        return elements;
    }

    public KursPage changeToAscSort(WebElement element) {
        element.click();
        String attribute = element.getAttribute("aria-sort");
        if (attribute.contentEquals("ascending")) {
            return this;
        } else {
            element.click();
            return this;
        }
    }

    public KursPage changeToDescSort(WebElement element) {
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
