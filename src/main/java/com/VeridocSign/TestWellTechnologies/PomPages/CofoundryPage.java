package com.VeridocSign.TestWellTechnologies.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CofoundryPage {
	@FindBy (xpath="//img[@src='/assets/images/109-4358200042985-AuOBvx/veridocsign-logo-h-black-200px.png']")
	private WebElement logo;
	
	@FindBy (name="FreeTrialEmail")
	private WebElement emailTextField;
	
	@FindBy (id="freetrialsubmit")
	private WebElement startFreeTrialBtn;
	
	@FindBy (xpath="//a[text()='Home']")
	private WebElement Home;
	
	@FindBy (id="errorIcon")
	private WebElement errorMsg;
	
	@FindBy (id="errorInvalid")
	private WebElement errorInvalidMsg;
	
	@FindBy (id="errorExist")
	private WebElement errorExistMsg;
	
	@FindBy (id="PassSetup")
	private WebElement PassSetupPopup;
	
	@FindBy (xpath="//div[@class='password-title text-center']")
	private WebElement popupTitle;
	
	@FindBy (xpath="//a[text()='Log in']")
	private WebElement loginLink;
	
	@FindBy (xpath="//i[@class='fa fa-check']")
	private WebElement checkIcon;
	
	@FindBy (id="email_id")
	private WebElement popupEmailTextField;
	
	@FindBy (id="pass_log_id")
	private WebElement popupPassTextField;
	
	@FindBy (id="startFreeTrial")
	private WebElement popupStartFreeTrialBtn;

	public WebElement getPopupStartFreeTrialBtn() {
		return popupStartFreeTrialBtn;
	}

	public WebElement getPopupEmailTextField() {
		return popupEmailTextField;
	}

	public WebElement getPopupPassTextField() {
		return popupPassTextField;
	}

	public WebElement getCheckIcon() {
		return checkIcon;
	}

	public CofoundryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getLogo()
	{
		return logo;
	}
	
	public WebElement getEmailTextBox() {
		return emailTextField;
	}

	public WebElement getStartFreeTrialBtn() {
		return startFreeTrialBtn;
	}

	public WebElement getHome() {
		return Home;
	}
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getErrorInvalidMsg() {
		return errorInvalidMsg;
	}
	
	public WebElement getErrorExistMsg() {
		return errorExistMsg;
	}
	
	public WebElement getPassSetupPopup() {
		return PassSetupPopup;
	}

	public WebElement getPopupTitle() {
		return popupTitle;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}


}
