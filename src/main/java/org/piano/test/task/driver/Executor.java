package org.piano.test.task.driver;

import org.openqa.selenium.remote.HttpCommandExecutor;

import java.net.URL;

/**
 * Created by Юрий on 25.01.2017.
 */
public class Executor {
    private static HttpCommandExecutor executor;

    public static HttpCommandExecutor getExecutor(URL url) {
        if (executor == null) {
            executor = new HttpCommandExecutor(url);
        }
        return executor;
    }
}
