package org.guideCX.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginPage{

    WebDriver driver;
    public By txtEmail = By.name("email");
    public By txtPassword = By.name("password");
    By btnLogin = By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div/div/form/button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String emailAddress){
        driver.findElement(txtEmail).sendKeys(emailAddress);
    }

    public void setPassword(String password){
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clkLogin(){
        driver.findElement(btnLogin).click();
    }

    public void loginToGuideCX(String email, String password){
        this.setEmail(email);
        this.setPassword(password);
        this.clkLogin();
    }


}
