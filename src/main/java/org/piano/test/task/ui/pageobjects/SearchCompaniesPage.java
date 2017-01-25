package org.piano.test.task.ui.pageobjects;

import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.piano.test.task.ui.elements.SearchResult;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Юрий on 24.01.2017.
 */
public class SearchCompaniesPage extends BasePage {

    @FindBy(id = "q")
    private TextInput requestInput;

    @FindBy(id = "l")
    private TextInput locationInput;

    @FindBy(className = "search-btn")
    private Button searchButton;

    @FindBy(css = "div.companies>div")
    private List<SearchResult> results;

    @FindBy(id = "index-hed")
    private WebElement  numberOfResults;



    public SearchCompaniesPage(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {

        requestInput.sendKeys(text);
        searchButton.click();
        waitForAllRequestsCompleted();
    }

    public boolean resultsContain(String text) {
        for (SearchResult result : results) {
            if (!result.getName().contains(text)) {
                return false;
            }
        }
        return true;
    }

    public void searchByLocation(String location) {

    }

    public boolean resultsContainLocation(String toronto) {
        return false;
    }

    public boolean resultsNotContainLocation(String toronto) {
    }
}
