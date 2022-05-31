package org.guideCX.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {
    WebDriver driver;
    By projectName = By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[2]/a/div[2]/div/div/div");
    //By tabTeam = By.xpath("//*[@id=\"_next\"]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/div[3]/div/button[5]/span[1]");
    By tabTeam = By.cssSelector(".MuiButtonBase-root:nth-child(5)");
    By btnAddTeamMember = By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/span/a/button");

    public ProjectPage(WebDriver driver){
        this.driver = driver;
    }

    public void clkProject(){
        driver.findElement(projectName).click();
    }

    public void clkTeam(){
        driver.findElement(tabTeam).click();
    }

    public void clickAddTeamMember(){
        driver.findElement(btnAddTeamMember).click();
    }

}
