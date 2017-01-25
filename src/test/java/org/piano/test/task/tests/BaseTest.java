package org.piano.test.task.tests;

import org.openqa.selenium.WebDriver;
import org.piano.test.task.driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by Юрий on 25.01.2017.
 */
public class BaseTest {

    protected WebDriver driver;


    @BeforeTest
    public void startBrowser() {
        driver = DriverManager.getWebDriver();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
