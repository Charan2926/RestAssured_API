package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CreateProject  {
	
	//Declaration
	@FindBy(xpath="//span[text()='Create Project']")
	private WebElement createprojectlink;

	@FindBy(name="projectName")
	private WebElement projectName;
	
	@FindBy(name="createdBy")
	private WebElement createdBy;
	
	@FindBy(name="status")
	private WebElement statusDropdown;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement savebutton;
	
	//Intialiazation
    public CreateProject(WebDriver driver) {
   	PageFactory.initElements(driver, this);
   }

    //Declaration
	public WebElement getCreateprojectlink() {
		return createprojectlink;
	}


	public WebElement getProjectName() {
		return projectName;
	}


	public WebElement getCreatedBy() {
		return createdBy;
	}

	public WebElement getStatusDropdown() {
		return statusDropdown;
	}
	
	public WebElement getSavebutton() {
		return savebutton;
	}

	//Business Libraries
	public void  createNewProject(String Pname,String Author,String value) throws InterruptedException {
	createprojectlink.click();
	projectName.sendKeys(Pname);
	createdBy.sendKeys(Author);
	WebElement ele = statusDropdown;
	Select sel = new Select(ele);
	sel.selectByValue(value);
	savebutton.click();
	Thread.sleep(2000);
	}
	
	public String captureProjectId(String ProjectName,WebDriver driver) throws Throwable {
		WebElement pid = driver.findElement(By.xpath("//td[.='"+ProjectName+"']/preceding-sibling::td"));
		String pro =pid.getText();
		System.out.println(pro);
		return pro;
	}
	
}
