package com.weight.healthtrack.automation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.*;

@Tag("automation")
public class AutomationTest extends SeleniumTest{

    @Test
    public void testUserDataDisplay() {
        driver.get(BASE_URL);
        
        WebElement nameElement = driver.findElement(By.id("name"));
        WebElement weightElement = driver.findElement(By.id("current-weight"));
        
        assertTrue(nameElement.getText().contains("Eduardo"));
        assertTrue(weightElement.getText().contains("86")); //Deberia ser 75
    }

    @Test
    public void testWeightUpdate() {
        driver.get(BASE_URL);
        
        WebElement weightInput = driver.findElement(By.id("weight"));
        WebElement addButton = driver.findElement(By.id("add-btn"));
        WebElement thanksMessage = driver.findElement(By.id("thanks-message"));
        
        weightInput.sendKeys("86.0");
        addButton.click();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        assertTrue(thanksMessage.isDisplayed());
    }
}