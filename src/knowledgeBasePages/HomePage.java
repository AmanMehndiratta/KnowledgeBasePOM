package knowledgeBasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Locators;
import utilities.utilityFunctions;

public class HomePage {

	@FindBy(xpath = Locators.loginButton)
	public WebElement loginButton;

	@FindBy(xpath = Locators.loginWithMobiControl)
	public WebElement loginWithMobiControl;

	@FindBy(xpath = Locators.mobiControlEnterEmail)
	public WebElement mobiControlEnterEmail;

	@FindBy(xpath = Locators.mobiControlEnterPassword)
	public WebElement mobiControlEnterPassword;

	@FindBy(xpath = Locators.mobiControlLoginButton)
	public WebElement mobiControlLoginButton;

	@FindBy(xpath = Locators.userProfileIcon)
	public WebElement userProfileIcon;

	@FindBy(xpath = Locators.logoutButton)
	public WebElement logoutButton;

	@FindBy(xpath = Locators.closeMobiControlLoginPopup)
	public WebElement closeMobicontrolLoginPopup;
	
	@FindBy(xpath = Locators.articlesTabOnHomePage)
	public WebElement articlesTabOnHomePage;
	
	@FindBy(xpath = Locators.questionsTabOnHomePage)
	public WebElement questionsTabOnHomePage;
	

	public void loginMobiControl(WebDriver driver, String username, String password) throws Exception {
		utilityFunctions.waitForElementToBeClickable(driver, Locators.loginButton);
		loginButton.click();
		loginWithMobiControl.click();
		utilityFunctions.waitForElementToBeClickable(driver, Locators.mobiControlEnterEmail);
		mobiControlEnterEmail.sendKeys(username);
		
		mobiControlEnterPassword.sendKeys(password);
		mobiControlLoginButton.click();
		try {
			utilityFunctions.waitForElementToBeClickable(driver, Locators.userProfileIcon);
			userProfileIcon.click();
			logoutButton.click();
		} catch (Exception e) {
			closeMobicontrolLoginPopup.click();
		}
		
	}
	
	public boolean goToArticlesTab(WebDriver driver){
		try{
			articlesTabOnHomePage.click();
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public boolean goToQuestionsTab(WebDriver driver){
		try{
			questionsTabOnHomePage.click();
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
