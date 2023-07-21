package com.cucumberFramework.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.cucumberFramework.enums.Browsers;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class ServiceHooks extends TestBase{




	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				logger.infoLog(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png","Failed"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				logger.infoLog(scenario.getName() + " is pass");
				scenario.attach(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png","Passed");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		TestBase.driver.quit();
	}
}
