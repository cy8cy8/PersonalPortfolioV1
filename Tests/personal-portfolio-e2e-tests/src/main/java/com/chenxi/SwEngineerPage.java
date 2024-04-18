package com.chenxi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lombok.Getter;

@Getter
public class SwEngineerPage {

    private WebDriver driver;
    private By title = By.cssSelector("body > div.jumbotron.allContainer > div.container > span");
    private By description = By.cssSelector("body > div.jumbotron.allContainer > div.container > p");
    private By myStoryBtn = By
            .cssSelector("body > div.jumbotron.allContainer > div.container > div > button.button-82-blue-pushable");
    private By gitHubBtn = By
            .cssSelector("#gitHub");
    private By modalBtn = By.cssSelector("#myStory > div > div > div.modal-footer > button");

    public SwEngineerPage(WebDriver driver) {
        this.driver = driver;
    }
}
