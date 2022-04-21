package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest
{
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void open() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyThatSigningUpPageDisplay()
    {
        driver.findElement(By.linkText("Register")).click();
        String expectedResult = "Signing up is easy!";
        WebElement element = driver.findElement(By.xpath("//div[@id='rightPanel']/h1"));
        String actualResult = element.getText();

        Assert.assertEquals("error occured",expectedResult,actualResult);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully()
    {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("prime");
        driver.findElement(By.id("customer.lastName")).sendKeys("testing");
        driver.findElement(By.xpath("//tr/td[2]/input[@id='customer.address.street']")).sendKeys("abc street");
        driver.findElement(By.id("customer.address.city")).sendKeys("kingston");
        driver.findElement(By.id("customer.address.state")).sendKeys("london");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("0000");
        driver.findElement(By.id("customer.username")).sendKeys("abc123456");
        driver.findElement(By.id("customer.password")).sendKeys("1234");
        driver.findElement(By.id("repeatedPassword")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@value='Register']")).click();

        String expectedResult = "Your account was created successfully. You are now logged in.";
        WebElement element = driver.findElement(By.xpath("//div[@id='rightPanel']/p"));
        String actualResult = element.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);


    }

    @After
    public void close() {
        // closeBrowser();
    }
}
