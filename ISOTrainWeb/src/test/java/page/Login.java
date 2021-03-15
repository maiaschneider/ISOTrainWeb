package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	private WebDriver driver;
	 
	//Selectors
    @FindBy(id= "lblWelcome") 
    WebElement titlePage;
    
    @FindBy(id = "ucLoginBox_txtUsername")
    private WebElement user;
    
    @FindBy(id = "ucLoginBox_txtPassword")
    private WebElement password;
    
    @FindBy(id = "ucLoginBox_btnLogin")
    private WebElement btnLogin;
    
    @FindBy(id = "ucLoginBox_btnCancel")
    private WebElement btnCancel;
    
    @FindBy(id = "ucLoginBox_chkChangePassword")
    private WebElement checkChgPass;
    
    
	    //Constructor
	    public Login(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public boolean isPageOpened(String title){
	        return titlePage.getText().contains(title);
	    }
	    
	    public void loginVal(String user_id, String pass)
	    {
	    	sendText(user,user_id);
	    	sendText(password, pass);
	    	clickOnElement(btnLogin);
	    	
	    }

		private void clickOnElement(WebElement btn) {
			btn.click();
			
		}

		private void sendText(WebElement element, String text) {
			element.clear();
			element.sendKeys(text);
			
		}
}
