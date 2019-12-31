package com.in28minutes.springboot.web;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginSteps {

    String output = "";

    @Given("^A username name (.*) and password (.*)$")
    public void when_a_user_with_username_in_minutes_and_password_dummy(String name, String password) throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            driver.get("http://localhost:8081");
            driver.findElement(By.id("username")).sendKeys(name);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.xpath("/html/body/div[@class='container']/form[@class='form-signin']/button[@class='btn btn-lg btn-primary btn-block']")).click();
            WebElement firstResult = wait.until(presenceOfElementLocated(By.xpath("/html/body/nav[@class='navbar navbar-default']/div[1]/a[@class='navbar-brand']")));
            output = firstResult.getText();
            System.out.println(firstResult.getText());
        } catch (Exception e) {
            output = "failure";
        } finally {
            driver.quit();
        }
    }

    @When("^tries to login to todo web application$")
    public void tries_to_login_to_the_application() throws Exception {
    }

    @Then("^It should login (.*)$")
    public void thenCheckOutput(String response) {
       Assert.assertEquals(output, response);
    }

    public static void main(String[] args) {
    }
}
