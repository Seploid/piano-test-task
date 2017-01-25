package org.piano.test.task.tests;

import org.piano.test.task.ui.pageobjects.SearchCompaniesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Юрий on 24.01.2017.
 */
public class SearchCompaniesTest extends BaseTest {

    public SearchCompaniesPage openSearchCompaniesPage() {
        driver.get("https://stackoverflow.com/jobs/companies");
        return new SearchCompaniesPage(driver);
    }

    @Test
    public void searchingByKeyWord_correctResults() {
        SearchCompaniesPage searchCompaniesPage = openSearchCompaniesPage();
        searchCompaniesPage.search("Inc");
        Assert.assertTrue(searchCompaniesPage.resultsContain("Inc"), "the results do not match the query");
    }

    @Test
    public void searchingByKeyWordAndLocation_resultsEmpty() {
        SearchCompaniesPage searchCompaniesPage = openSearchCompaniesPage();
        searchCompaniesPage.search("Inc");
        Assert.assertTrue(searchCompaniesPage.resultsContain("Inc"), "the results do not match the query");
    }

    @Test
    public void searchingByLocation_resultsWitCorrectLocation() {
        SearchCompaniesPage searchCompaniesPage = openSearchCompaniesPage();
        searchCompaniesPage.searchByLocation("Toronto");
        Assert.assertTrue(searchCompaniesPage.resultsContainLocation("Toronto"), "the results do not match the location");
    }

    @Test
    public void searchingByIncorrectLocation_resultsAreExist() {
        SearchCompaniesPage searchCompaniesPage = openSearchCompaniesPage();
        searchCompaniesPage.searchByLocation("asdasfdas");
        Assert.assertTrue(searchCompaniesPage.resultsNotContainLocation("Toronto"), "the results do not match the location");
    }


}
