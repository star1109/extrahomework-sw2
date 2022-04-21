package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void open() {
        openBrowser(baseUrl);

    }

        @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        driver.findElement(By.name("username")).sendKeys("abc123");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@class = 'button']")).click();

        String expectedResult = "Accounts Overview";
        WebElement element = driver.findElement(By.xpath("//h1[@class = 'title']"));
        String actualResult = element.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);

    }

    @Test
    public void verifyTheErrorMessage()
    {
        driver.findElement(By.name("username")).sendKeys("abc12311");
        driver.findElement(By.name("password")).sendKeys("1234567");
        driver.findElement(By.xpath("//input[@class = 'button']")).click();

        String expectedResult = "The username and password could not be verified.";
        WebElement element = driver.findElement(By.xpath("//div[@id = 'rightPanel']/p"));
        String actualResult = element.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);
    }

    @Test
    public void userShouldLogOutSuccessfully()
    {
        driver.findElement(By.name("username")).sendKeys("abc123");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@class = 'button']")).click();
        driver.findElement(By.linkText("Log Out")).click();

        String expectedResult = "Customer Login";
        WebElement element = driver.findElement(By.xpath("//div[@id = 'leftPanel']/h2"));
        String actualResult = element.getText();
        Assert.assertEquals("error occured",expectedResult,actualResult);


    }

    @After
    public void close() {
        // closeBrowser();
    }

}
