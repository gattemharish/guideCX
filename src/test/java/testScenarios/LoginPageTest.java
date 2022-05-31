package testScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.guideCX.pageobjects.AddTeamMemberPage;
import org.guideCX.pageobjects.LoginPage;
import org.guideCX.pageobjects.ProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    WebDriver driver;


    @BeforeTest
    public void beforetest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://app.staging.guidecx.io/auth/login");
    }

    @Test
    public void LoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProjectPage projectPage = new ProjectPage(driver);
        AddTeamMemberPage addTeamMemberPage = new AddTeamMemberPage(driver);
        loginPage.loginToGuideCX("harishkumargattem@gmail.com", "Guidecx_379");

        String ff = driver.getTitle();
        System.out.println(ff);
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "Projects");


    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
