package com.weight.healthtrack.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.*;

public class AutomationTest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        //options.addArguments("--window-size=1920,1200");
        options.addArguments("--ignore-certificate-errors");
        
        driver = new ChromeDriver(options);
        baseUrl = "http://localhost:8080";
    }

    @Test
    public void testUserDataDisplay() {
        driver.get(baseUrl);
        
        WebElement nameElement = driver.findElement(By.id("name"));
        WebElement weightElement = driver.findElement(By.id("current-weight"));
        
        assertTrue(nameElement.getText().contains("Eduardo"));
        assertTrue(weightElement.getText().contains("75.0"));
    }

    @Test
    public void testWeightUpdate() {
        driver.get(baseUrl);
        
        WebElement weightInput = driver.findElement(By.id("weight"));
        WebElement addButton = driver.findElement(By.id("add-btn"));
        WebElement thanksMessage = driver.findElement(By.id("thanks-message"));
        
        weightInput.sendKeys("85.0");
        addButton.click();
        
        // Wait for the update to complete (simplified for example)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        assertTrue(thanksMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}