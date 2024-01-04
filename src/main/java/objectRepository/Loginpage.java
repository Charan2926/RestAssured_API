package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//Declaration
	@FindBy(id="usernmae")
	private WebElement username;
	
    @FindBy(id="inputPassword")
    private WebElement password;
    
    @FindBy(xpath="//button[text()='Sign in']")
    private WebElement loginbutton;
    
    //Intialiazation
    public Loginpage(WebDriver driver) {
   	PageFactory.initElements(driver, this);
   }
    
    //Declaration
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	//Business Libraries
	public void Logindata(String Username,String Password ) {
	username.sendKeys(Username);
	password.sendKeys(Password);
	loginbutton.click();	
  }  
}
