package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println("::: Starting Automation :::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    @Before(value = "@db",order = 0)// this hook will run only before scenarios with tag @db
    public void dbSetuo(){
        System.out.println("::: Connecting to the dataBase :::");
    }

    @After(value = "@db")
    public void dbTearDown(){
        System.out.println("::: Disconnecting from the dataBase :::");
    }

    @After
    public void tearDown( Scenario scenario){
        // this is hook after
        // runs automatically after every test
        if(scenario.isFailed()){
            byte[] data = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
             scenario.attach(data,"image/png", scenario.getName());
        }
        Driver.closeDriver();
        System.out.println("::: End of test execution :::");
    }

}
