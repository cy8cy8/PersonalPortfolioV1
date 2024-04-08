package com.chenxi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwEngineerPage {

    protected WebDriver driver;
    protected By title = By.cssSelector("body > div.jumbotron.allContainer > div.container > h1");
    protected By description = By.cssSelector("body > div.jumbotron.allContainer > div.container > p");
    protected By myStoryBtn = By
            .cssSelector("body > div.jumbotron.allContainer > div.container > div > button.button-82-blue-pushable");
    protected By gitHubBtn = By
            .cssSelector("body > div.jumbotron.allContainer > div.container > div > button.button-82-pushable");

    public SwEngineerPage(WebDriver driver) {
        this.driver = driver;
    }

}
