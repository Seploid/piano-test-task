package org.piano.test.task.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.piano.test.task.ui.WaitConditions;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by Юрий on 24.01.2017.
 */
public class BasePage {

    private static final long DEFAULT_TIMEOUT_IN_SEC = 10;
    protected WebDriver driver;

    public BasePage ( WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);
    }



    public void waitForAllRequestsCompleted() {
            //TODO: add logger
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT_IN_SEC);
            wait.until(WaitConditions.ajaxToFinishLoading());
    }
}
