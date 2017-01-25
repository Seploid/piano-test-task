package org.piano.test.task.ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by Юрий on 25.01.2017.
 */
public class WaitConditions {

    public static ExpectedCondition<Boolean> ajaxToFinishLoading() {

        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return window.jQuery == undefined || jQuery.active == 0");
            }

            @Override
            public String toString() {
                return String.format("Wait for ajax to finish loading");
            }
        };
    }

}
