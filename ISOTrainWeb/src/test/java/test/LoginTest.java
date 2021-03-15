package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.Login;

public class LoginTest {
	private String PATHDRIVER = "C:\\drivers/";
    
    WebDriver	driver;
    
    
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver",PATHDRIVER+"chromedriver.exe");
        driver = new ChromeDriver();
        
    }
    
    
    @Parameters({"serverPath", "user", "password"})
	@Test (priority = 1)
    public void signIn(String serverPath, String user, String password) throws NumberFormatException, InterruptedException{
	driver.get(serverPath);
	Thread.sleep(new Long("8000"));
	//Crear objeto de la clase Login
	Login login = new Login(driver);
	Assert.assertTrue(login.isPageOpened("WELCOME"));
	login.loginVal(user, password);
    }
}
