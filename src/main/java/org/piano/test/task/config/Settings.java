package org.piano.test.task.config;

import org.kohsuke.args4j.Option;

/**
 * Created by Юрий on 24.01.2017.
 */
public class Settings {

    private static final Settings SETTINGS_INSTANCE = new Settings();

    @Option(name = "--xml", usage = "testNG suite file path", required = true)
    private String xmlPath;

    @Option(name = "--selenium-server", usage = "host of selenium server", required = false)
    private String seleniumServer = "localhost:4723";

    public String getSeleniumServer() {
        return seleniumServer;
    }

    //    private constructor for singleton
    private Settings() {}

    public String getXmlPath() {
        return xmlPath;
    }

    public static Settings getInstance() {
        return SETTINGS_INSTANCE;
    }
}
