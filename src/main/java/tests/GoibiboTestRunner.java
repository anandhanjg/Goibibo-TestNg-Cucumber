package tests;

import controller.goibibo.Goibibo;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listeners.GoibiboListener;
import org.testng.annotations.*;
import utils.InvalidDateException;


@CucumberOptions(
        features = {"src/main/resources/features/Goibibo.feature","src/main/resources/features/Test.feature"},
        glue = {"tests"},
        tags = "",
        plugin = {"pretty", "html:target/cucumber.html"}
)
@Listeners(GoibiboListener.class)
public class GoibiboTestRunner extends AbstractTestNGCucumberTests {
    Goibibo goibibo;

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }

    @BeforeTest
    public void beforeTest(){
        goibibo=Goibibo.getInstance();
        System.out.println("HELLO DUDE");
    }

    @BeforeGroups
    public void beforeGroup(){
        System.out.println("Before Group");
    }


    @AfterGroups
    public void afterGroup(){
        System.out.println("After Group");
    }

    @AfterTest
    public void afterTest(){
        goibibo.quit();
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
}
