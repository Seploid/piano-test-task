package org.piano.test.task.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.piano.test.task.config.Settings;
import org.piano.test.task.driver.factories.AbstractFactory;
import org.piano.test.task.driver.factories.ChromeFactory;
import org.piano.test.task.driver.factories.FirefoxFactory;
import org.piano.test.task.driver.factories.InternetExplorerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Юрий on 24.01.2017.
 */
public class DriverManager {

    private static final String URL = "http://%s/wd/hub";
    private static final String DEFAULT_NAME = "DEFAULT_NAME";
    private static final DriverType DEFAULT_TYPE = DriverType.CHROME;
//    to store instances of drivers
    private static HashMap<String, WebDriver> instances = new HashMap<String, WebDriver>();
//    associated list for mapping factories
    private static HashMap<DriverType, AbstractFactory> factories = new HashMap<DriverType, AbstractFactory>();
    static {
        factories.put(DriverType.CHROME, new ChromeFactory());
        factories.put(DriverType.FIREFOX, new FirefoxFactory());
        factories.put(DriverType.IE, new InternetExplorerFactory());
    }

    public static WebDriver getWebDriver(String name, DriverType driverType) {
        if (!instances.containsKey(name)) {
            try {
                HttpCommandExecutor executor = Executor.getExecutor(new URL(String.format(URL, Settings.getInstance().getSeleniumServer())));
                WebDriver driver = new RemoteWebDriver(executor, factories.get(driverType).getCapability());
                instances.put(name, driver);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Fail to connect to Selenium Server. ", e);
            }
        }
        return instances.get(name);
    }

    public static WebDriver getWebDriver(String name) {
        return getWebDriver(name,  DEFAULT_TYPE);
    }

    public static WebDriver getWebDriver() {
        return getWebDriver(DEFAULT_NAME);
    }
}
