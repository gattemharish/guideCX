package testScenarios;

import Utils.LoginUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin;
import org.apache.commons.lang3.RandomStringUtils;
import org.guideCX.pageobjects.AddTeamMemberPage;
import org.guideCX.pageobjects.LoginPage;
import org.guideCX.pageobjects.ProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AddTeamMemberPageTest extends LoginUtil {
    WebDriver driver;
    String firstName = RandomStringUtils.randomAlphabetic(8).toLowerCase();
    String lastName =  RandomStringUtils.randomAlphabetic(6).toLowerCase();
    String emailAddress = firstName + "." + lastName + "@" + "gmail.com";

    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://app.staging.guidecx.io/auth/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void addTeamMemberTestHappyPath() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProjectPage projectPage = new ProjectPage(driver);
        AddTeamMemberPage addTeamMemberPage = new AddTeamMemberPage(driver);
        loginPage.loginToGuideCX(userName, password);
        projectPage.clkProject();
        wait.until(ExpectedConditions.elementToBeClickable(projectPage.tabTeam));
        projectPage.clkTeam();
        wait.until(ExpectedConditions.elementToBeClickable(projectPage.btnAddTeamMember));
        projectPage.clickAddTeamMember();
        wait.until(ExpectedConditions.elementToBeClickable(addTeamMemberPage.btnAddTeamMembers));
        addTeamMemberPage.AddTeamMembers(firstName, lastName, emailAddress);
        Thread.sleep(5000);
        List<String> emailList = projectPage.getTeamMembersEmailList();
        Assert.assertTrue(emailList.contains(emailAddress));
    }

    @Test(priority = 2)
    public void addTeamMemberTestInValidEmail() throws InterruptedException {
        ProjectPage projectPage = new ProjectPage(driver);
        AddTeamMemberPage addTeamMemberPage = new AddTeamMemberPage(driver);
        projectPage.clickAddTeamMember();
        wait.until(ExpectedConditions.elementToBeClickable(addTeamMemberPage.btnAddTeamMembers));
        addTeamMemberPage.AddTeamMembers("dd", "dd", "dfd");
        String validationMessage = driver.findElement(addTeamMemberPage.txtEmail).getAttribute("validationMessage");
        System.out.println(validationMessage);
        Assert.assertTrue(validationMessage.contains(emailValidationMessage1));

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
