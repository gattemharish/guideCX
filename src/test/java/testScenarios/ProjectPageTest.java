package testScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.guideCX.pageobjects.AddTeamMemberPage;
import org.guideCX.pageobjects.LoginPage;
import org.guideCX.pageobjects.ProjectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProjectPageTest {
    WebDriver driver;


    @BeforeTest
    public void beforetest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://app.staging.guidecx.io/auth/login");
    }

    @Test
    public void addTeamMember() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProjectPage projectPage = new ProjectPage(driver);
        AddTeamMemberPage addTeamMemberPage = new AddTeamMemberPage(driver);
        loginPage.loginToGuideCX("harishkumargattem@gmail.com", "Guidecx_379");
        projectPage.clkProject();
        Thread.sleep(5000);
        projectPage.clkTeam();
        Thread.sleep(5000);
        projectPage.clickAddTeamMember();
        Thread.sleep(5000);
        addTeamMemberPage.AddTeamMembers("rt", "yu", "ddd@www.com");
        Thread.sleep(5000);
        List<String> emailList = addTeamMemberPage.getTeamMembersList();
        Assert.assertTrue(emailList.contains("options-ddd@www.com"));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
