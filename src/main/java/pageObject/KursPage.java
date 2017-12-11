package pageObject;

import static java.util.Collections.max;
import static java.util.Collections.min;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KursPage extends HomePage {

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

    public KursPage(WebDriver driver) {
        super(driver);
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
        List<String> elements = new ArrayList<>();
        for (WebElement element : names) {
            elements.add(element.getText());
        }
        return elements;
    }

    public List<String> setUsdBuy() {
        List<String> elements = new ArrayList<>();
        for (WebElement element : usdBuy) {
            elements.add(element.getText());
        }
        return elements;
    }

    public List<String> setUsdSell() {
        List<String> elements = new ArrayList<>();
        for (WebElement element : usdSell) {
            elements.add(element.getText());
        }
        return elements;
    }


    public List<String> setEurBuy() {
        List<String> elements = new ArrayList<>();
        for (WebElement element : eurBuy) {
            elements.add(element.getText());
        }
        return elements;
    }


    public List<String> setEurSell() {
        List<String> elements = new ArrayList<>();
        for (WebElement element : eurSell) {
            elements.add(element.getText());
        }
        return elements;
    }


    public List<String> setRubBuy() {
        List<String> elements = new ArrayList<>();
        for (WebElement element : rubBuy) {
            elements.add(element.getText());
        }
        return elements;
    }


    public List<String> setRubSell() {
        List<String> elements = new ArrayList<>();
        for (WebElement element : rubSell) {
            elements.add(element.getText());
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
        int[] counter = new int[names.size()];
        int[][] allIndexs = {indexUsdBuy, indexUsdSell, indexEurBuy, indexEurSell, indexRubBuy, indexRubSell};
        for (int[] arr : allIndexs) {
            for (int arrs : arr) {
                counter[arrs]++;
            }
        }
        int max = counter[0];
        int[] index = new int[names.size()+1];
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > max) {
                max = counter[i];
            }}
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == max) {
                index[i] = i;
            }
        }
        List<String> elements = new ArrayList<>();
        for (int in : index) {
            if (in > 0) {
                elements.add("\nБанк с лучшими курсами: " + names.get(in).getText());
            }
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
