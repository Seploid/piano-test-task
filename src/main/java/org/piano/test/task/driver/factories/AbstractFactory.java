package org.piano.test.task.driver.factories;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Юрий on 24.01.2017.
 */
public interface AbstractFactory {
    DesiredCapabilities getCapability();
}
