package org.guideCX.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProjectPage {
    WebDriver driver;
    By projectName = By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[2]/a/div[2]/div/div/div");
    public By tabTeam = By.cssSelector(".MuiButtonBase-root:nth-child(5)");
    public By btnAddTeamMember = By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/span/a/button");
    public By teamMemberGrid = By.xpath("//div[contains(@class, 'sc-gqjmRU grid-layout sc-')]/div");

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

    public List<String> getTeamMembersEmailList(){
        List<WebElement> teamMemberList = driver.findElements(teamMemberGrid);
        List<String> teamMemberEmailList = new ArrayList<>();
        for(WebElement x: teamMemberList){
            teamMemberEmailList.add(x.getAttribute("data-test").substring(8));
        }

        return teamMemberEmailList;

    }

}
