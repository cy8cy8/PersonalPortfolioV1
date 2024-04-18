package com.chenxi;

import com.chenxi.IndexPage;

import lombok.Getter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class IndexPage {
    private WebDriver driver;

    private By profilePicBtn = By.cssSelector("body > div > img");
    private By swEngineerBtn = By.cssSelector("body > div > div.btnContainer > a:nth-child(1) > button");
    private By appSecEngineerBtn = By.cssSelector("body > div > div.btnContainer > a:nth-child(2) > button");

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Chenxi Yang")) {
            throw new IllegalStateException("This is not Sign In Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public SwEngineerPage navigateToSwEngineerPage() {
        driver.findElement(this.profilePicBtn).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMillis(1500));
        wait.until(d -> driver
                .findElement(this.swEngineerBtn)).click();
        return new SwEngineerPage(driver);
    }

}
