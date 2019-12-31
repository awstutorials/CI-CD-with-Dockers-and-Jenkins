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

public class HelloWorldSteps {

    private HelloWorld helloWorld = new HelloWorld();


    private String name = "";

    private String output = "";

    @Given("^A String name (.*)$")
    public void givenInput(String name) {
        this.name = name;
    }
    @When("^sayHello method of HelloWorld.java is called$")
    public void whenBusinessLogicCalled() {
        output = helloWorld.sayHello(name);
    }
    @Then("^It should return (.*)$")
    public void thenCheckOutput(String response) {
        Assert.assertEquals(output, response);
    }


    public static void main(String[] args) {
    }
}
