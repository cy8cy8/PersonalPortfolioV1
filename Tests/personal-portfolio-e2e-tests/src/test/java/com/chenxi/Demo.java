package com.chenxi;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {

    private static WebDriver driver = new ChromeDriver();

    @BeforeTest
    void Setup() {
        driver.get("http://localhost:8000");
        driver.manage().window().maximize();
    }

    /**
     * Change all sleep duration for demos.
     * @throws InterruptedException
     */
    @Test
    void test_demo() throws InterruptedException {
        /*
         * Hover over photo button and click.
         */
        Thread.sleep(5000); 
        IndexPage indexPage = new IndexPage(driver);
        WebElement profilePictureBtn = driver.findElement(indexPage.getProfilePicBtn());
        Actions action = new Actions(driver);
        action.moveToElement(profilePictureBtn, 0, 0).perform();
        Thread.sleep(5000); 
        profilePictureBtn.click();

        /*
         * Hover to SW Engineer btn, then to AppSec Engineer btn, then back, then
         * click, then switch to SW Engineer site
         */
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMillis(1500));
        wait.until(d -> driver
                .findElement(indexPage.getSwEngineerBtn()));
        wait.until(d -> driver
                .findElement(indexPage.getAppSecEngineerBtn()));
        WebElement swBtn = driver.findElement(indexPage.getSwEngineerBtn());
        WebElement appSecBtn = driver.findElement(indexPage.getAppSecEngineerBtn());
        action.moveToElement(swBtn).perform();
        Thread.sleep(3000);
        action.moveToElement(appSecBtn).perform();
        Thread.sleep(3000); 
        action.moveToElement(swBtn).perform();
        Thread.sleep(1500); 
        // Making the window switch
        String homeWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        swBtn.click();
        wait.until(d -> d.getWindowHandles().size() == 2);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!homeWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(d -> d.getTitle().equals("Chenxi - SW Engineer"));

        /*
         * Hover over title, click on link, switch to LinkedIn, close LinkedIn, back
         * to SW Engineer page.
         */
        SwEngineerPage swEngineerPage = new SwEngineerPage(driver);
        WebElement swPageH1Btn = driver.findElement(swEngineerPage.getTitle());
        Thread.sleep(3000);
        action.moveToElement(swPageH1Btn).perform();
        Thread.sleep(3000); 
        // Open linkedin, close it, then repoen again (due to authwall)
        String swWindow = driver.getWindowHandle();
        for (int i = 0; i < 2; i++) {
            assert driver.getWindowHandles().size() == 2;
            swPageH1Btn.click();

            for (String windowHandle : driver.getWindowHandles()) {
                if (!swWindow.contentEquals(windowHandle) && !homeWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            Thread.sleep(5000);
            driver.close();
            driver.switchTo().window(swWindow);
        }
        wait.until(d -> d.getTitle().equals("Chenxi - SW Engineer"));

        /*
         * Hover over My Story, click on it and stay, close My Story modal.
         */
        WebElement myStoryBtn = driver.findElement(swEngineerPage.getMyStoryBtn());
        WebElement gitHubBtn = driver.findElement(swEngineerPage.getGitHubBtn());
        for (int i = 0; i < 3; i++) {
            action.moveToElement(myStoryBtn).perform();
            Thread.sleep(2000); 
            action.moveToElement(gitHubBtn).perform();
            Thread.sleep(2000);
        }
        action.moveToElement(myStoryBtn).perform();
        Thread.sleep(2000); 
        action.clickAndHold(myStoryBtn).perform();
        Thread.sleep(1000); 
        myStoryBtn.click();
        Thread.sleep(2000); 
        WebElement modalCloseBtn = driver.findElement(swEngineerPage.getModalBtn());
        modalCloseBtn.click();

        /*
         * hover to GitHub and click, switch to GitHub, close GitHub, double click to
         * close page.
         */
        WebElement description = driver.findElement(swEngineerPage.getDescription());
        action.moveToElement(gitHubBtn).perform();
        Thread.sleep(1500); // change duration for demo
        action.clickAndHold(gitHubBtn).perform();
        Thread.sleep(500); // change duration for demo
        // Switch to newly opened GitHub tab.
        assert driver.getWindowHandles().size() == 2;
        gitHubBtn.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!swWindow.contentEquals(windowHandle) && !homeWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(swWindow);
        assert driver.getTitle().equals("Chenxi - SW Engineer");
        Thread.sleep(2000);
        action.moveToElement(description).doubleClick().build().perform();
    }
    
    @AfterTest
    void Teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
