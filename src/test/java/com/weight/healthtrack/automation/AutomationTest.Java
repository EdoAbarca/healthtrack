// src/test/java/com/healthtrack/SeleniumFunctionalTest.java

package com.healthtrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumFunctionalTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();  // Puedes usar FirefoxDriver si lo prefieres
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testUserWeightSubmission() {
        // 1. Ir al sitio (el HTML servido por Nginx)
        driver.get("http://localhost");  // o usa el puerto que hayas mapeado

        // 2. Esperar a que cargue el nombre del usuario
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("name"), "Name:"));

        // 3. Verificar que los datos iniciales se cargaron
        WebElement name = driver.findElement(By.id("name"));
        WebElement weight = driver.findElement(By.id("current-weight"));

        Assertions.assertTrue(name.getText().startsWith("Name:"));
        Assertions.assertTrue(weight.getText().contains("Weight:"));

        // 4. Enviar nuevo peso
        WebElement input = driver.findElement(By.id("weight"));
        input.clear();
        input.sendKeys("82.5");

        driver.findElement(By.id("add-btn")).click();

        // 5. Verificar que aparece el mensaje de agradecimiento
        WebElement thanks = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("thanks-message"))
        );

        Assertions.assertTrue(thanks.isDisplayed());
    }
}
