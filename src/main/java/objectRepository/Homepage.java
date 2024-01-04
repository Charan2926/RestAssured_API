package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	//declaration
	@FindBy(xpath="//a[text()='Projects']")
	private WebElement Projectslink;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutlink;
	
	//Intialiazation
    public Homepage(WebDriver driver) {
   	PageFactory.initElements(driver, this);
   }
    
    //Declaration
	public WebElement getProjectslink() {
		return Projectslink;
	}
	
	public WebElement getLogoutlink() {
		return logoutlink;
	}

	//Business Libraries
	public void clickonproject() {
	  Projectslink.click();
	} 
	
	public void logout(WebDriver driver) {
		logoutlink.click();
	}
	public String GetProjectDetails(String expdata,WebDriver driver) {
		WebElement pd = driver.findElement(By.xpath("//td[.='"+expdata+"']/.."));
		String pro =pd.getText();
		System.out.println(pro);
		return pro;
		
	}
}
