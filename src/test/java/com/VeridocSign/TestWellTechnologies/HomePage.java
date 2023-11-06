package com.VeridocSign.TestWellTechnologies;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.VeridocSign.TestWellTechnologies.PomPages.CofoundryPage;
import com.VeridocSign.TestWellTechnologies.genericLib.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass{
	
	@Test(priority=1)
	public void HomePage_TC01()
	{
		Assert.assertEquals(driver.getTitle(), "A Complete, Reliable & Blockchain-secure ESign Solution | VeriDoc Sign");
	}
	
	@Test(priority=2)
	public void HomePage_TC02()
	{
		boolean isLogoDisplayed = new CofoundryPage(driver).getLogo().isDisplayed();
		 if (isLogoDisplayed) {
		        test.log(Status.INFO, "Logo is displayed");
		    } else {
		        test.log(Status.INFO, "Logo is not displayed");
		    }
		Assert.assertTrue(isLogoDisplayed, "Logo is not displayed");
	}
	
	@Test(priority=3)
	public void HomePage_TC03()
	{
		String title = driver.getTitle();
		new CofoundryPage(driver).getLogo().click();
		Assert.assertEquals(title, driver.getTitle());
	}
	
	@Test(priority=4)
	public void HomePage_TC04() {
	    CofoundryPage cofoundryPage = new CofoundryPage(driver);

	    boolean isEmailTextBoxDisplayed = cofoundryPage.getEmailTextBox().isDisplayed();
	    boolean isStartFreeTrialBtnDisplayed = cofoundryPage.getStartFreeTrialBtn().isDisplayed();

	    test.log(Status.INFO, "Verifying elements on the home page:");

	    test.log(Status.INFO, "Email Text Box displayed: " + isEmailTextBoxDisplayed);
	    test.log(Status.INFO, "Start Your Free Trial displayed: " + isStartFreeTrialBtnDisplayed);

	    Assert.assertTrue(isEmailTextBoxDisplayed, "Email Text Box is not displayed");
	    Assert.assertTrue(isStartFreeTrialBtnDisplayed, "Start Your Free Trial button is not displayed");
	}
	
	@Test(priority=5)
	public void HomePage_TC05()
	{
		CofoundryPage cofoundryPage = new CofoundryPage(driver);
		cofoundryPage.getStartFreeTrialBtn().click();
		boolean isErrorMsgDisplayed = cofoundryPage.getErrorMsg().isDisplayed();
		test.log(Status.INFO, "Error message displayed: " + isErrorMsgDisplayed);
		Assert.assertTrue(isErrorMsgDisplayed, "Error message not displayed");
	}
	
	@Test(priority=6)
	public void HomePage_TC06()
	{
		CofoundryPage cofoundryPage = new CofoundryPage(driver);
		cofoundryPage.getEmailTextBox().sendKeys("12345678");
		cofoundryPage.getStartFreeTrialBtn().click();
		boolean isErrorMsgDisplayed = cofoundryPage.getErrorMsg().isDisplayed();
		test.log(Status.INFO, "Error message displayed: " + isErrorMsgDisplayed);
		Assert.assertTrue(isErrorMsgDisplayed, "Error message not displayed");
		String errormsg = cofoundryPage.getErrorInvalidMsg().getText();
		test.log(Status.INFO, "Error Message: "+errormsg);
		Assert.assertEquals(errormsg, "Please enter valid email");
	}
	
	@Test(priority=7)
	public void HomePage_TC07()
	{
		CofoundryPage cofoundryPage = new CofoundryPage(driver);
		cofoundryPage.getEmailTextBox().sendKeys("shashi1995");
		cofoundryPage.getStartFreeTrialBtn().click();
		boolean isErrorMsgDisplayed = cofoundryPage.getErrorMsg().isDisplayed();
		test.log(Status.INFO, "Error message displayed: " + isErrorMsgDisplayed);
		Assert.assertTrue(isErrorMsgDisplayed, "Error message not displayed");
		String errormsg = cofoundryPage.getErrorInvalidMsg().getText();
		test.log(Status.INFO, "Error Message: "+errormsg);
		Assert.assertEquals(errormsg, "Please enter valid email");
	}
	
	@Test(priority=8)
	public void HomePage_TC08()
	{
		CofoundryPage cofoundryPage = new CofoundryPage(driver);
		cofoundryPage.getEmailTextBox().sendKeys("shashi@yourflow.com.au");
		cofoundryPage.getStartFreeTrialBtn().click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(cofoundryPage.getErrorMsg()));
		boolean isErrorMsgDisplayed = cofoundryPage.getErrorMsg().isDisplayed();
		test.log(Status.INFO, "Error message displayed: " + isErrorMsgDisplayed);
		Assert.assertTrue(isErrorMsgDisplayed, "Error message not displayed");
		String errormsg = cofoundryPage.getErrorExistMsg().getText();
		test.log(Status.INFO, "Error Message: "+errormsg);
		Assert.assertEquals(errormsg, "This email already in use.");
	}
	
	@Test(priority=9)
	public void HomePage_TC09()
	{
		CofoundryPage cofoundryPage = new CofoundryPage(driver);
		cofoundryPage.getEmailTextBox().sendKeys("shashiprakashsunny@gmail.com");
		cofoundryPage.getStartFreeTrialBtn().click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(cofoundryPage.getCheckIcon()));
		cofoundryPage.getStartFreeTrialBtn().click();
		boolean isPopupDisplayed = cofoundryPage.getPassSetupPopup().isDisplayed();
		test.log(Status.INFO, "Popup displayed: " + isPopupDisplayed);
		Assert.assertTrue(isPopupDisplayed, "Popup not displayed");
		String popuptitle = cofoundryPage.getPopupTitle().getText();
		test.log(Status.INFO, "Popup Title: "+popuptitle);
		Assert.assertEquals(popuptitle, "Sign up for a free trial");
		
	}
	
	@Test(priority=10)
	public void HomePage_TC010()
	{
		CofoundryPage cofoundryPage = new CofoundryPage(driver);
		cofoundryPage.getEmailTextBox().sendKeys("shashiprakashsunny@gmail.com");
		cofoundryPage.getStartFreeTrialBtn().click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(cofoundryPage.getCheckIcon()));
		cofoundryPage.getStartFreeTrialBtn().click();
		boolean isLoginDisplayed = cofoundryPage.getLoginLink().isDisplayed();
		test.log(Status.INFO, "Login Link displayed: " + isLoginDisplayed);
		Assert.assertTrue(isLoginDisplayed, "Login Link not displayed");
		cofoundryPage.getLoginLink().click();
		utilities.switchTabs(driver);
		Assert.assertEquals(driver.getTitle(), "Login to Our My VeriDoc Sign Account Now");
		test.log(Status.INFO, "Navigated to the Login page");
		
	}
	
	@Test(priority=11)
	public void HomePage_TC011()
	{
		CofoundryPage cofoundryPage = new CofoundryPage(driver);
		cofoundryPage.getEmailTextBox().sendKeys("shashiprakashsunny@gmail.com");
		cofoundryPage.getStartFreeTrialBtn().click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(cofoundryPage.getCheckIcon()));
		cofoundryPage.getStartFreeTrialBtn().click();
		boolean isPopupEmailTextFieldDisplayed = cofoundryPage.getPopupEmailTextField().isDisplayed();
		test.log(Status.INFO, "Email Text Field in popup window displayed: " + isPopupEmailTextFieldDisplayed);
		Assert.assertTrue(isPopupEmailTextFieldDisplayed, "Email Text Field in popup window not displayed");
		boolean isPopupPassTextFieldDisplayed = cofoundryPage.getPopupPassTextField().isDisplayed();
		test.log(Status.INFO, "Password Text Field in popup window displayed: " + isPopupPassTextFieldDisplayed);
		Assert.assertTrue(isPopupPassTextFieldDisplayed, "Password Text Field in popup window not displayed");
		Point loc = cofoundryPage.getPopupEmailTextField().getLocation();
		int emailTextFieldXaxis = loc.getX();
		Point loc1 = cofoundryPage.getPopupPassTextField().getLocation();
		int passTextFieldXaxis = loc1.getX();
		Assert.assertEquals(emailTextFieldXaxis, passTextFieldXaxis, "Email Text Field and Password Text Field are not properly aligned");
		Dimension size = cofoundryPage.getPopupEmailTextField().getSize();
		int emailTextFieldHeight = size.getHeight();
		int emailTextFieldWidth = size.getWidth();
		Dimension size1 = cofoundryPage.getPopupPassTextField().getSize();
		int passTextFieldHeight = size1.getHeight();
		int passTextFieldWidth = size1.getWidth();
		Assert.assertEquals(emailTextFieldHeight, passTextFieldHeight, "Email Text Field and Password Text Field are not properly aligned");
		Assert.assertEquals(emailTextFieldWidth, passTextFieldWidth, "Email Text Field and Password Text Field are not properly aligned");
		test.log(Status.INFO, "Email Text Field and Password Text Field are properly aligned");
	
	}
	
	@Test(priority=12)
	public void HomePage_TC012()
	{
		CofoundryPage cofoundryPage = new CofoundryPage(driver);
		cofoundryPage.getEmailTextBox().sendKeys("shashiprakashsunny@gmail.com");
		cofoundryPage.getStartFreeTrialBtn().click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(cofoundryPage.getCheckIcon()));
		cofoundryPage.getStartFreeTrialBtn().click();
		cofoundryPage.getPopupStartFreeTrialBtn().click();
		boolean isErrorMsgDisplayed = cofoundryPage.getErrorMsg().isDisplayed();
		test.log(Status.INFO, "Error message displayed: " + isErrorMsgDisplayed);
		Assert.assertTrue(isErrorMsgDisplayed, "Error message not displayed");
	}
}
