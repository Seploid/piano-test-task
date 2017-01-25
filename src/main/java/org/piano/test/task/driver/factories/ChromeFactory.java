package org.piano.test.task.driver.factories;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Юрий on 24.01.2017.
 */
public class ChromeFactory implements AbstractFactory {

    public DesiredCapabilities getCapability() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return chromeCapabilities;
    }

}
