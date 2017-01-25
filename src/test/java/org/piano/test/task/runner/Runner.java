package org.piano.test.task.runner;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.piano.test.task.config.Settings;
import org.piano.test.task.exceptions.TestNgException;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

/**
 * Created by Юрий on 24.01.2017.
 */
public class Runner {
    private TestNG testng = new TestNG();
    private Settings settings = Settings.getInstance();

    public static void main(String[] args) {
        new Runner(args).run();
    }

    private Runner (String[] args) {
        CmdLineParser parser = new CmdLineParser(settings);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println("Error: " + e.toString());
            System.err.println("Usage: ");
            parser.printUsage(System.err);
        }
    }

    private void run() {
        try {
            Parser xml = new Parser(settings.getXmlPath());
            XmlSuite xmlSuite = xml.parseToList().get(0);
            testng.setCommandLineSuite(xmlSuite);
            testng.run();
        } catch (Exception e) {
            throw new TestNgException("Error executing TestNG suite " + e.getMessage());
        }
    }
}
