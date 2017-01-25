package org.piano.test.task.driver.factories;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Юрий on 24.01.2017.
 */
public class FirefoxFactory implements AbstractFactory {

    public DesiredCapabilities getCapability() {
        return DesiredCapabilities.firefox();
    }
}
