package testScenarios;

import Utils.LoginUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.guideCX.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPageTest extends LoginUtil{

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(loginUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void LoginTestHappyPath() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToGuideCX(userName, password);
        wait.until(ExpectedConditions.titleIs(homePageTitle));
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, homePageTitle);
    }

    @Test
    public void LoginTestInValidEmailScenario1(){
        LoginPage loginPage = new LoginPage(driver);
        String inValidEmail = "har";
        loginPage.loginToGuideCX(inValidEmail, "dfd");
        String validationMessage = driver.findElement(loginPage.txtEmail).getAttribute("validationMessage");
        System.out.println(validationMessage);
        Assert.assertTrue(validationMessage.contains(emailValidationMessage1));
    }

    @Test
    public void LoginTestInValidEmailScenario2(){
        LoginPage loginPage = new LoginPage(driver);
        String inValidEmail = "har@";
        loginPage.loginToGuideCX(inValidEmail, "dfd");
        String validationMessage = driver.findElement(loginPage.txtEmail).getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains(emailValidationMessage2));
    }

    @Test
    public void LoginTestEmptyEmail(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToGuideCX("", "dfd");
        String validationMessage = driver.findElement(loginPage.txtEmail).getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains(emailValidationMessage3));
    }

    @Test
    public void LoginTestEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToGuideCX(userName, "");
        String validationMessage = driver.findElement(loginPage.txtPassword).getAttribute("validationMessage");
        System.out.println(validationMessage);
        Assert.assertTrue(validationMessage.contains(emailValidationMessage3));
    }

    @Test
    public void LoginTestIncorrectEmailAndPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToGuideCX("har@ff.com", "dfddfd");
        Assert.assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
