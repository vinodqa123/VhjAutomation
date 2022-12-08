package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import Base.BaseClass;

public class LoginPage extends BaseClass  {
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement userName;
	
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")
	WebElement passWord;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")
	WebElement loginBtn;
	
	public LoginPage() throws IOException{
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String UserName) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));		
		userName.sendKeys(UserName);
		Thread.sleep(1000);
	}
	public void enterPassword(String Password) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));		
		passWord.sendKeys(Password);
	}
	public void loginbtn() throws InterruptedException{		
		loginBtn.click();
		Thread.sleep(4000);
		
		
	}


}
