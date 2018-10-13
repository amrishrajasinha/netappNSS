package com.netapp.supportsite.businesscomponents;

import com.netapp.supportsite.base.GPSBase;
import com.ust.sarf.testdata.TestDataManage;

public class GPS extends GPSBase {

	/********************************************************************************************************************
	* Method : GlueLogin
	* Description: To set the username, password and login the user to Glue URL.
	* Author:Alfred
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void glueLogin()
	{
			
			
			getDriver().manage().deleteAllCookies();
			String url = TestDataManage.getData("Url");
			getDriver().navigate().to(url); 
			waitForPageReady();
			//verifyTitle();
			navigateToLoginPage();
			enterCredentials();
			submit();
			waitForPageReady();
			

	}
	
	/********************************************************************************************************************
	* Method : launchGlueURL
	* Description: To launch Glue URL.
	* Author:Alfred
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void launchGlueURL()
	{
		waitForPageLoad();
		String url = TestDataManage.getData("Url");
		getDriver().navigate().to(url); 
		waitForPageReady();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatIntakeFormAndProceedToChatWindow
	* Description: To Verify chat icon present.
	* Author:Alfred
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void verifyChatIntakeFormAndProceedToChatWindow()
	{
		VerifyChatIconPresentAndHoverText();
		OpenChatIntakeForm();
		enterSerialNumberForChatIntake();
		clickChatButton();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatIntakeFormForInvalidSerialNumber
	* Description: To Verify chat icon present.
	* Author:Alfred
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void verifyChatIntakeFormForInvalidSerialNumber()
	{
		VerifyChatIconPresentAndHoverText();
		OpenChatIntakeForm();
		enterSerialNumberForChatIntake();
		clickChatButton();
		verifyHyperLinkForChatWindow();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatIntakeFormForInvalidSerialNumber
	* Description: To Verify chat icon present.
	* Author:Alfred
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void verifyChatIntakeForm()
	{
		VerifyChatIconPresentAndHoverText();
		OpenChatIntakeForm();
		verifyChatIntakeFormorAllFields();
	}
	
	/********************************************************************************************************************
	* Method : verifyChatIcon
	* Description: To Verify chat icon present.
	* Author:Alfred
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void VerifyChatIconAvailableHours()
	{
		VerifyChatIconPresentAndHoverText();
		VerifyChatIconAvailableHoursPresent();
		
	}
	
	/********************************************************************************************************************
	* Method : validateChatIconGreyedOutAndAvailableAfterLogin
	* Description: To Verify chat icon present.
	* Author:Alfred
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void validateChatIconGreyedOutAndAvailableAfterLogin()
	{
		verifyAndClickGPSChatLogin();
		enterCredentials();
		submit();
		waitForPageReady();
		VerifyChatIconPresentAndHoverText();	
	}

	/********************************************************************************************************************
	* Method : clickCreateACaseLink
	* Description: To click create a case link.
	* Author:Alfred
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void clickCreateACaseLink()
	{
		clickCreateACaseButton();	
	}
	
	/********************************************************************************************************************
	* Method : validateChatIconGreyedOutAndClickLoginLink
	* Description: To Verify chat icon greyed out and click login 
	* Author:Tony George
	* Date: Mar-14-2017
	********************************************************************************************************************/
	public void validateChatIconGreyedOutAndClickLoginLink()
	{
		ValidateDisabledChatIcon();
		VerifyNavigationAfterClikingLogin();
	}
	
	/********************************************************************************************************************
	* Method : VerifyChatIconNotAvailableForCertainUsers
	* Description: To Verify chat icon greyed out and click login 
	* Author:Tony George
	* Date: Mar-14-2017
	********************************************************************************************************************/
	public void VerifyChatIconNotAvailableForCertainUsers()
	{
		VerifyChatIconNotAvailable();
	}

	/********************************************************************************************************************
	* Method : verifyChatIntakeFormForSSCSupportSerialNumber
	* Description: To Verify chat for ssc support serial number
	* Author:Tony George
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void verifyChatIntakeFormForSSCSupportSerialNumber()
	{
		VerifyChatIconPresentAndHoverText();
		OpenChatIntakeForm();
		enterSerialNumberForChatIntake();
		VerifySSCSerialNumberErrorMessage();
	}
	/********************************************************************************************************************
	* Method : verifyChatIntakeForm_Fields
	* Description: To Verify all the fields in the chat intake form
	* Author:Tony George
	* Date: Mar-15-2017
	********************************************************************************************************************/
	public void verifyChatIntakeForm_Fields()
	{
		VerifyChatIconPresentAndHoverText();
		OpenChatIntakeForm();
		VerifyChatIntakeFormFields();
		verifyInvalidEmailError_ChatIntake();
	}
	/********************************************************************************************************************
	* Method : verifyChatIntakeForm_CancelButtonFunctionality
	* Description: To verify all the fields and click cancel button
	* Author:Tony George
	* Date: Mar-16-2017
	********************************************************************************************************************/
	public void verifyChatIntakeForm_CancelButtonFunctionality()
	{
		VerifyChatIconPresentAndHoverText();
		OpenChatIntakeForm();
		VerifyChatIntakeFormFields();
		ClickOnCancelChatIntakeForm();
	}

	/********************************************************************************************************************
	* Method : verifyChatHoursAfterLogin
	* Description: To verify the chat hours after login
	* Author:Tony George
	* Date: Mar-17-2017
	********************************************************************************************************************/
	public void verifyChatHoursAfterLogin()
	{
		verifyAndClickGPSChatLogin();
		enterCredentials();
		submit();
		waitForPageReady();
		VerifyChatHours();
		
	}

	/********************************************************************************************************************
	* Method : verifyChatIntakeForExpiredOrANZMarkedSerialNumber
	* Description: To verify the chat for expired serial number or ANZ marked as both the message are same
	* Author:Tony George
	* Date: Mar-20-2017
	********************************************************************************************************************/
	public void verifyChatIntakeForExpiredOrANZMarkedSerialNumber()
	{
		OpenChatIntakeForm();
		enterSerialNumberForChatIntake();
		verifyExpiredSerialNumberErrorMessage();
		
	}
	/********************************************************************************************************************
	* Method : verifyChatIntakeForDeclinedSerialNumber
	* Description: To verify the chat for declined serial number
	* Author:Tony George
	* Date: Mar-20-2017
	********************************************************************************************************************/
	public void verifyChatIntakeForDeclinedSerialNumber()
	{
		OpenChatIntakeForm();
		enterSerialNumberForChatIntake();
		verifyDeclinedSerialNumberErrorMessage();
		
	}

	/********************************************************************************************************************
	* Method : verifyChatOpensInNewTab
	* Description: To verify chat windows open in new tab
	* Author:Tony George
	* Date: Mar-21-2017
	********************************************************************************************************************/
	public void verifyChatOpensInNewTab()
	{
		VerifyChatIconPresentAndHoverText();
		OpenChatIntakeForm();
		VerifyChatIntakeFormFields();
		fillChatIntakeForm();
	}

	/********************************************************************************************************************
	* Method : LoginFromGluePage
	* Description: To login from the gluepage for accessing chat
	* Author:Tony George
	* Date: Mar-21-2017
	********************************************************************************************************************/
	public void LoginFromGluePageToAccessChat()
	{
		verifyAndClickGPSChatLogin();
		enterCredentials();
		submit();
		waitForPageReady();
	}

	/********************************************************************************************************************
	* Method : verifyChatNotAvailableForGuestUser
	* Description: To verify the chat icon not available for guest user
	* Author:Tony George
	* Date: Mar-21-2017
	********************************************************************************************************************/
	public void verifyChatNotAvailableForGuestUser()
	{
		validateChatIconForGuestUser();
	}

	/********************************************************************************************************************
	* Method : verifyGLUEURLLaunched
	* Description: To verify the chat icon not available for guest user
	* Author:Tony George
	* Date: Mar-21-2017
	********************************************************************************************************************/
	public void verifyGLUEURLLaunched()
	{
		verifyGLUEURLLaunchedSuccess();
	}

	/********************************************************************************************************************
	* Method : verifyChatAndCreateCaseLinkPresent
	* Description: To verify the chat icon not available for guest user
	* Author:Tony George
	* Date: Mar-21-2017
	********************************************************************************************************************/
	public void verifyChatAndCreateCaseLinkPresent()
	{
		verifyChatAndCreateCaseLinkPresentInGPSPage();
	}

	/********************************************************************************************************************
	* Method : SearchAndVerifyFeedbackNote
	* Description: To verify the feedback note after clicking yes option
	* Author:Tony George
	* Date: Jan-19-2018
	********************************************************************************************************************/
	public void SearchAndVerifyFeedbackNote()
	{
		SearchAndVerifyThankYouNote();
	}

	/********************************************************************************************************************
	* Method : VerifyGPSPage
	* Description: To verify the GPS page 
	* Author:Tony George
	* Date: Jan-19-2018
	********************************************************************************************************************/
	public void VerifyGPSPage()
	{
		GPSPageVerification();
	}

	/********************************************************************************************************************
	* Method : LaunchGPSAndVerifyChatAfterLogin
	* Description: To launcg the GPS page and verify chat icon
	* Author:Tony George
	* Date: Jan-19-2018
	********************************************************************************************************************/
	public void LaunchGPSAndVerifyChatAfterLogin()
	{
		launchGlueURL();
		verifyChatAfterSignInFromGPS();
	}
}
