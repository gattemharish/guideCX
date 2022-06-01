package org.guideCX.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddTeamMemberPage {

    WebDriver driver;
   //By txtFirstName = By.xpath("//*[@class=\"sc-jWBwVP etpAgO\"]//input[@data-testid=\"firstName\"]");
    //By tabTeam = By.xpath("//*[@id=\"_next\"]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/div[3]/div/button[5]/span[1]");
    By txtFirstName = By.xpath("/html/body/div[4]/div[3]/div/div[2]/form/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/input");
    By txtLastName = By.xpath("/html/body/div[4]/div[3]/div/div[2]/form/div/div/div/div/div/div/div[2]/div/div[2]/div[2]/input");
    public  By txtEmail = By.xpath("/html/body/div[4]/div[3]/div/div[2]/form/div/div/div/div/div/div/div[2]/div/div[3]/div/div[2]/input");
    public By btnAddTeamMembers = By.xpath("/html/body/div[4]/div[3]/div/div[3]/button");


    public AddTeamMemberPage(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstName(String FirstName) throws InterruptedException {
        driver.findElement(txtFirstName).sendKeys(FirstName);
    }

    public void setLastName(String LastName){
        driver.findElement(txtLastName).sendKeys(LastName);
    }

    public void setEmail(String email){
        //driver.findElement(txtEmail).click();
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void clkAddTeamMembers(){
        driver.findElement(btnAddTeamMembers).click();
    }

    public void AddTeamMembers(String fName, String lName, String email) throws InterruptedException {

        setFirstName(fName);
        setLastName(lName);
        setEmail(email);
        clkAddTeamMembers();

    }



}
