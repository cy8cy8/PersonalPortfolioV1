package com.chenxi;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexTest {

    public static WebDriver driver = new ChromeDriver();

    @BeforeTest
    void Setup() {
        driver.get("http://localhost:8000");
        driver.manage().window().maximize();
    }

    @Test
    void test_TitlePresent() {
        String expectedTitle = "Chenxi Yang";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void test_BothBtnsPresent() {
        IndexPage indexPage = new IndexPage(driver);
        WebElement profilePictureBtn = driver.findElement(indexPage.profilePicBtn);
        profilePictureBtn.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMillis(1500));
        wait.until(d -> driver
                .findElement(indexPage.swEngineerBtn));
        wait.until(d -> driver
                .findElement(indexPage.appSecEngineerBtn));
        WebElement swBtn = driver.findElement(indexPage.swEngineerBtn);
        WebElement appSecBtn = driver.findElement(indexPage.appSecEngineerBtn);
        String expectedSwEngineerBtnText = "SW Engineer";
        String expectedAppSecEngineerBtnText = "AppSec Engineer";
        String actualSwEngineerBtnText = swBtn.getText();
        String actualAppSecEngineerBtnText = appSecBtn.getText();
        Assert.assertEquals(actualAppSecEngineerBtnText, expectedAppSecEngineerBtnText);
        Assert.assertEquals(actualSwEngineerBtnText, expectedSwEngineerBtnText);
    }

    @Test
    void test_SWEngineerBtnNavigatesToCorrectPage() {
        
    }

    @AfterTest
    void Teardown() {
        driver.close();
    }
}
