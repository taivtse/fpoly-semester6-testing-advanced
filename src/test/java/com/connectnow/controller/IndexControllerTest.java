package com.connectnow.controller;

import com.connectnow.config.SpringWebConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class IndexControllerTest extends AbstractTestNGSpringContextTests {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void indexTest() {
        driver.get("http://localhost:7649/");
        Assert.assertEquals("Connect Now", driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}