package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        ConfigReader.initReader();
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if(scenario.isFailed()){
         byte[] ss=ScreenshotUtils.getScreenshot(DriverManager.getDriver());
         scenario.attach(ss,"image/jpg","screenshot");
        }
//        DriverManager.getDriver().quit();
    }
}
