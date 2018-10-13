package com.netapp.supportsite.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class GPSBase extends Base {

	 /********************************************************************************************************************
 	* Method : EnterCredentials
 	* Description: To enter the username and password
 	* Author: Salba Balakrishnan
 	* Date:August-25 -2016
 	********************************************************************************************************************/
   
   public void enterCredentials() 
   {
	   waitForElement(TestDataManage.getObjectProperty("UserName"));
	   type(TestDataManage.getObjectProperty("UserName"), TestDataManage.getData("UserName"));
	   type(TestDataManage.getObjectProperty("Password"), TestDataManage.getData("Password"));
       
   }

	

       /********************************************************************************************************************
     	* Method : verifyTitle
     	* Description: To verify the title of the Login page
     	* Author: Salba Balakrishnan
     	* Date:August-25 -2016
     	********************************************************************************************************************/
       
       public void verifyTitle() 
       {
    	  try
    	  {
    	  // waitForElementTime(TestDataManage.getObjectProperty("LoginPage_Title"),180);
    	   waitForTitle(TestDataManage.getObjectValue("LoginPage_Title", "TEXT"));
    	  }
    	  catch(Exception e)
    	  {
    		  //System.exit(1); 
    	  }
       
       
       }

   /********************************************************************************************************************
   	* Method : submit
   	* Description: To click the Submit button
   	* Author: Salba Balakrishnan
   	* Date:August-25 -2016
   	********************************************************************************************************************/

       public void submit() {
        click("Login_Button");
        //APPLICATION LOAD ISSUE 
        waitForPageLoad();
        pause(5000);
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
 	   for (int i=0; i<200; i++){ 
 		  
 		   //To check page ready state.
 		   if (js.executeScript("return document.readyState").toString().equalsIgnoreCase("complete")){
 		    System.out.println("Page is ready ");
 			   break;
 		   }
 		    else{
 		    	System.out.println("Waiting for the page to load");
 		    	pause(10000);
 		    }
 	   }   
      
                  
              
       }
       
       /********************************************************************************************************************
      	* Method : verifyTitleHome
      	* Description: To verify the title of the home page
      	* Author: Salba Balakrishnan
      	* modified:Sreejith
      	* Date:November-14-2016
      	********************************************************************************************************************/
       
       public void verifyTitleHome() 
       {
    	   	System.out.println("Started to verify  title");
              waitForTitle(TestDataManage.getObjectValue("HomePage_Title","TEXT"));
       }
      
       /********************************************************************************************************************
     	* Method : verifyTitleHome
     	* Description: To verify the title of the home page
     	* Author: Salba Balakrishnan
     	* modified:Sreejith
     	* Date:November-14-2016
     	********************************************************************************************************************/
      
      public void navigateToLoginPage() 
      {
    	  waitForElement(TestDataManage.getObjectProperty("Login_Link"));
    	  click("Login_Link");
      }
      
      /********************************************************************************************************************
   	* Method : verifyAndClickGPSChatLogin
   	* Description: To verify the title of the home page
   	* Author: Alfred
   	* Modified:Tony George
   	* Date:November-14-2016
   	********************************************************************************************************************/
    
    public void verifyAndClickGPSChatLogin() 
    {
    	
    	waitForElement(TestDataManage.getObjectProperty("DisabledChat_Icon"));
  	  	if(isElementPresent(TestDataManage.getObjectProperty("DisabledChat_Icon"))){
			getDetailedReport().WriteLog(Status.PASS, "Element present: Chat Icon. Expected Element should be present and greyed out", "Actual element is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: Chat Icon. Expected Element should be present and greyed out", "Actual element is not present.", getDriver()); 
		 }
  	  	verifyContainsText(TestDataManage.getObjectProperty("LogIn_Text"), "Log In to access chat");
  	  	click("GPSLoginForChat_Lnk");
    }
      
    /********************************************************************************************************************
   	* Method : ValidatedDisabledChatIconAndVerifyNavigationAfterClick
   	* Description: To verify the disabled chat icon and verify the click of the icon
   	* Author: Tony George
   	* Date:March-14-2016
   	********************************************************************************************************************/
    
    public void ValidateDisabledChatIcon() 
    {
    	 waitForElement(TestDataManage.getObjectProperty("DisabledChat_Icon"));
     	  if(isElementPresent(TestDataManage.getObjectProperty("DisabledChat_Icon"))){
   			getDetailedReport().WriteLog(Status.PASS, "Element present: Chat Icon. Expected Element should be present and greyed out", "Actual element is present.", getDriver()); 
   		 }
   		 else
   		 {
   			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: Chat Icon. Expected Element should be present and greyed out", "Actual element is not present.", getDriver()); 
   		 }
     	  verifyContainsText(TestDataManage.getObjectProperty("LogIn_Text"), "Log In to access chat");
     	 
    }
    
    /********************************************************************************************************************
   	* Method : VerifyNavigationAfterClikingLogin
   	* Description: To verify the navigation for login click
   	* Author: Tony George
   	* Date:March-14-2016
   	********************************************************************************************************************/
    
    public void VerifyNavigationAfterClikingLogin() 
    {
    	
     	  click("GPSLoginForChat_Lnk");
     	  String RedirectedURL=getDriver().getCurrentUrl();
     	  if(RedirectedURL.contains("login"))
     	  {
     		 getDetailedReport().WriteLog(Status.PASS,"Expected: Clicking Log In to access chat link should navigate to the login page of NSS","Actual: Clicking Log In to access chat link navigated to the login page of NSS",getDriver()); 
     	  }
     	  else
     	  {
     		 getDetailedReport().WriteLog(Status.FAIL,"Expected: Clicking Log In to access chat link should navigate to the login page of NSS","Actual: Clicking Log In to access chat link didn't navigate to the NSS login page instead it navigated to "+RedirectedURL,getDriver());   
     	  }
    }
    
    
      /********************************************************************************************************************
  	* Method : VerifyChatIconPresent
  	* Description: To accept the expired agreement 
  	* Author: Alfred Dcruz
  	* modified:Tony George
  	* Date: Feb-14-2017 
  	********************************************************************************************************************/
  	public void VerifyChatIconPresentAndHoverText()
  	{
  		waitForPageReady();
  		waitForElementTime(TestDataManage.getObjectProperty("LiveChat_Lnk"), 60);
  		if(isElementPresent(TestDataManage.getObjectProperty("LiveChat_Lnk"))){
  			getDetailedReport().WriteLog(Status.PASS, "Element present: Chat Icon. Expected Element should be present", "Actual element is present.", getDriver()); 
  		 }
  		 else
  		 {
  			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: Chat Icon. Expected Element should be present", "Actual element is not present.", getDriver()); 
  		 }
  	
 		String Hovertext=getDriver().findElement(TestDataManage.getObjectProperty("LiveChat_Img")).getAttribute("title").trim();
		if(Hovertext.equals("Use chat for technical issue"))
		{
			getDetailedReport().WriteLog(Status.PASS, "Expected:Hover text of chat image should be Use chat for technical issue", "Actual:Hover text of chat image is Use chat for technical issue", getDriver()); 
		}
		else
		{
  			getDetailedReport().WriteLog(Status.PASS, "Expected:Hover text of chat image should be Use chat for technical issue", "Actual:Hover text of chat image is "+Hovertext, getDriver());	
  		}
  		
  	}
  	
  	 /********************************************************************************************************************
  	* Method : VerifyChatIconNotAvailable
  	* Description: To accept the expired agreement 
  	* Author: Alfred Dcruz
  	* modified:Tony George
  	* Date: Feb-14-2017 
  	********************************************************************************************************************/
  	public void VerifyChatIconNotAvailable()
  	{
  		waitForPageReady();
  		waitForElementTime(TestDataManage.getObjectProperty("LiveChat_Lnk"), 60);
  		if(!isElementPresent(TestDataManage.getObjectProperty("LiveChat_Lnk"))){
  			getDetailedReport().WriteLog(Status.PASS, "Chat Icon. Should be greyed out and not available for Chat", "Expected is shown.", getDriver()); 
  		 }
  		 else
  		 {
  			 getDetailedReport().WriteLog(Status.FAIL, "Chat Icon. Should be greyed out and not available for Chat", "Invalid since Chat available.", getDriver()); 
  		 }  		
  	}
  	
  	/********************************************************************************************************************
  	* Method : VerifyChatIconAvailableHoursPresent
  	* Description: To accept the expired agreement 
  	* Author: Alfred Dcruz
  	* Date: Feb-14-2017 
  	********************************************************************************************************************/
  	public void VerifyChatIconAvailableHoursPresent()
  	{
  		waitForPageReady();
  		waitForElementTime(TestDataManage.getObjectProperty("ChatTime_Lbl"), 60);
  		if(isElementPresent(TestDataManage.getObjectProperty("ChatTime_Lbl"))){
  			getDetailedReport().WriteLog(Status.PASS, "Element present: Available Hours for Chat Icon. Expected Element should be present", "Actual element is present.", getDriver()); 
  		 }
  		 else
  		 {
  			 getDetailedReport().WriteLog(Status.FAIL, "Available Hours for Chat Icon. Expected Element should be present", "Actual element is not present.", getDriver()); 
  		 }
  	}
  	
  	/********************************************************************************************************************
	* Method : OpenChatIntakeForm
	* Description: To open the chat intake form
	* Author: Alfred
	* Date: Mar-13-2017 
	********************************************************************************************************************/
	public void OpenChatIntakeForm()
	{
		waitForElement(TestDataManage.getObjectProperty("LiveChat_Lnk"));
		click("LiveChat_Lnk");
		pause(5000);
		boolean isEnabled=getDriver().findElement(TestDataManage.getObjectProperty("ChatMessageAllow_Lbl")).isDisplayed();
		if(isEnabled == true){
			
		waitForElement(TestDataManage.getObjectProperty("ChatIconAllowContinue_Btn"));
		click("ChatIconAllowContinue_Btn");
		}else{
			waitForElement(TestDataManage.getObjectProperty("ChatContinue_Button"));
			click("ChatContinue_Button");
		}
	}
	
	/********************************************************************************************************************
	* Method : enterSerialNumberForChatIntake
	* Description: Validate the Provide Information form in live Chat
	* Author: Alfred Dcruz
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void enterSerialNumberForChatIntake()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"));
		type(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"), TestDataManage.getData("SerialNumber"));
		click(TestDataManage.getObjectProperty("ChatFirstName_TextBox"));
	}
	
	/********************************************************************************************************************
	* Method : verifyChatIntakeForm
	* Description: Validate the Provide Information form in live Chat
	* Author: Alfred Dcruz
	* Date: Jan-14-2017
	********************************************************************************************************************/
	public void verifyChatIntakeFormorAllFields()
	{
		if(isElementPresent(TestDataManage.getObjectProperty("ChatSerNumber_TextBox")) && isElementPresent(TestDataManage.getObjectProperty("ChatFirstName_TextBox")) && isElementPresent(TestDataManage.getObjectProperty("ChatLastName_TextBox")) && isElementPresent(TestDataManage.getObjectProperty("ChatEmailAddress_TextBox")) && isElementPresent(TestDataManage.getObjectProperty("ChatPriority_Drpdwn"))){
			getDetailedReport().WriteLog(Status.PASS, "Element present: Chat Intake Form verify. Expected Element should be present", "Actual element is present.", getDriver()); 
 		 }
 		 else
 		 {
 			 getDetailedReport().WriteLog(Status.FAIL, "Chat Intake Form verify. Expected Element should be present", "Actual element is not present.", getDriver()); 
 		 }
	}
	
	/********************************************************************************************************************
	* Method : clickChatButton
	* Description: Click the live Chat Button in intake form
	* Author: Rajmohan Dhanapal
	* Date: FEB-14-2017
	********************************************************************************************************************/
	public void clickChatButton()
	{
		waitForElement(TestDataManage.getObjectProperty("LiveChat_Lnk"));
		click("LiveChat_Lnk");
		sleepFor(10000);
	}

	/********************************************************************************************************************
	* Method : VerifySSCSerialNumberErrorMessage
	* Description: To verify the error message for SSC Serial Number
	* Author: Tony George
	* Date: March-14-2017
	********************************************************************************************************************/
	public void VerifySSCSerialNumberErrorMessage()
	{
		waitForElement(TestDataManage.getObjectProperty("GPSNotification_Txt"));
		verifyContainsText(TestDataManage.getObjectProperty("GPSNotification_Txt"), "Please contact Fujitsu Technology Solutions GmbH for support of this product.");
		click("DismissNotification_Btn");
		verifyElementDisplayed("ChatSerNumber_TextBox", "Serial Number Textbox");
	}

	/********************************************************************************************************************
	* Method : VerifyChatIntakeFormFields
	* Description: To verify all the fields in the chat intake form
	* Author: Tony George
	* Date: March-15-2017
	********************************************************************************************************************/
	public void VerifyChatIntakeFormFields()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"));
		verifyElementDisplayed("ChatFirstName_TextBox", "FirstName_Textbox ChatIntake Form");
		verifyElementDisplayed("ChatLastName_TextBox", "LastName_Textbox ChatIntake Form");
		verifyElementDisplayed("ChatEmailAddress_TextBox", "Email_Textbox ChatIntake Form");
		verifyElementDisplayed("ChatPriority_Drpdwn", "Priority_Drpdwn ChatIntake Form");
		verifyElementDisplayed("ChatSerNumber_TextBox", "Serial Number Textbox");
		verifyElementEnabled("ChatSerNumber_TextBox");
		verifyValue(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"), "");
		verifyElementEnabled("ChatFirstName_TextBox");
		verifyValue(TestDataManage.getObjectProperty("ChatFirstName_TextBox"), TestDataManage.getData("FirstName"));
		verifyElementEnabled("ChatLastName_TextBox");
		verifyValue(TestDataManage.getObjectProperty("ChatLastName_TextBox"), TestDataManage.getData("LastName"));
		verifyValue(TestDataManage.getObjectProperty("ChatEmailAddress_TextBox"), TestDataManage.getData("EmailAddress"));
		verifyContainsText(TestDataManage.getObjectProperty("ChatEmailNote_Txt"), "This may be used to contact you if chat gets disconnected");
		verifyMutipleOptionPresentInDropDown("ChatPriority_Drpdwn","PriorityList");
		type(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"), TestDataManage.getData("SerialNumber"));
		click(TestDataManage.getObjectProperty("ChatFirstName_TextBox"));
		waitForClickable(TestDataManage.getObjectProperty("ProvideInfFormChat_Button"));
		clearTextBox("ChatFirstName_TextBox");
		clearTextBox("ChatLastName_TextBox");
		clearTextBox("ChatEmailAddress_TextBox");
		click("ProvideInfFormChat_Button");
		verifyContainsText(TestDataManage.getObjectProperty("ChatFirstNameRequired_Txt"), "Required");
		verifyContainsText(TestDataManage.getObjectProperty("ChatLastNameRequired_Txt"), "Required");
		verifyContainsText(TestDataManage.getObjectProperty("ChatEmailAddressRequired_Txt"), "Required");
		
		
	}
	
	/********************************************************************************************************************
	* Method : VerifyInvalidEmailError_ChatIntake
	* Description: To verify error message of invalid email
	* Author: Tony George
	* Date: March-21-2017
	********************************************************************************************************************/
	public void verifyInvalidEmailError_ChatIntake()
	{
		type(TestDataManage.getObjectProperty("ChatFirstName_TextBox"), TestDataManage.getData("FirstName"));
		type(TestDataManage.getObjectProperty("ChatLastName_TextBox"), TestDataManage.getData("LastName"));
		type(TestDataManage.getObjectProperty("ChatEmailAddress_TextBox"), "122");
		click("ProvideInfFormChat_Button");
		verifyAlertTextAndAccept("You have entered an invalid email address!");
	}
	
	/********************************************************************************************************************
	* Method : FillChatIntakeForm
	* Description: To fill all the details in chat intakeform
	* Author: Tony George
	* Date: March-21-2017
	********************************************************************************************************************/
	public void fillChatIntakeForm()
	{
		clearTextBox("ChatFirstName_TextBox");
		clearTextBox("ChatLastName_TextBox");
		clearTextBox("ChatEmailAddress_TextBox");
		clearTextBox("ChatSerNumber_TextBox");
		click("ChatIntakeCancel_Btn");
		OpenChatIntakeForm();
		waitForElement(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"));
		type(TestDataManage.getObjectProperty("ChatSerNumber_TextBox"), TestDataManage.getData("SerialNumber"));
		click("ChatFirstName_TextBox");
		waitForClickable(TestDataManage.getObjectProperty("ProvideInfFormChat_Button"));
		type(TestDataManage.getObjectProperty("ChatFirstName_TextBox"), TestDataManage.getData("FirstName"));
		type(TestDataManage.getObjectProperty("ChatLastName_TextBox"), TestDataManage.getData("LastName"));
		type(TestDataManage.getObjectProperty("ChatEmailAddress_TextBox"), TestDataManage.getData("EmailAddress"));
		click("ProvideInfFormChat_Button");
		switchToNewWindow();
		verifyTitle("Support Live Chat");
	}
	
	
	/********************************************************************************************************************
	* Method : ClickOnCancelChatIntakeForm
	* Description: To click on the cancel button
	* Author: Tony George
	* Date: March-16-2017
	********************************************************************************************************************/
	public void ClickOnCancelChatIntakeForm()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatIntakeCancel_Btn"));
		click("ChatIntakeCancel_Btn");
		if(getElement("ChatFirstName_TextBox").isDisplayed()==false)
		{
			getDetailedReport().WriteLog(Status.PASS, "Expected :Chat intake form should be closed on clicking the close button", "Actual:Chat intake form is closed on clicking the cancel button", getDriver()); 	
		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Expected :Chat intake form should be closed on clicking the close button", "Actual:Chat intake form is not closed on clicking the cancel button", getDriver()); 	
		}
	
	
	}	

	/********************************************************************************************************************
	* Method : VerifyChatHours
	* Description: Verify the chat hours after login
	* Author: Tony George
	* Date: March-17-2017
	********************************************************************************************************************/
	public void VerifyChatHours()
	{
		waitForElement(TestDataManage.getObjectProperty("ChatTime_Text"));
		verifyContainsText(TestDataManage.getObjectProperty("ChatTime_Text"), TestDataManage.getData("ChatHours"));
	
	}

	/********************************************************************************************************************
	* Method : verifyCreateACaseLinkAvailable
	* Description: To verify the create a case link available
	* Author: Alfred Dcruz
	* Date: March-14-2017
	********************************************************************************************************************/
	public void clickCreateACaseButton()
	{
		waitForPageLoad();
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("CreateACase_Lnk"));
		click(TestDataManage.getObjectProperty("CreateACase_Lnk"));
		waitForPageReady();
		
		

	}

	/********************************************************************************************************************
	* Method : verifyHyperLinkForChatWindow
	* Description: To verify the create a case link available
	* Author: Alfred Dcruz
	* Date: March-14-2017
	********************************************************************************************************************/
	public void verifyHyperLinkForChatWindow()
	{
		waitForPageLoad();
		waitForPageReady();
		waitForElement(TestDataManage.getObjectProperty("SupportSiteChat_Lnk"));
		if(isElementPresent(TestDataManage.getObjectProperty("SupportSiteChat_Lnk")) && isElementPresent(TestDataManage.getObjectProperty("ContactUsChat_Lnk"))){
			getDetailedReport().WriteLog(Status.PASS, "Element present: SupportSite and ContactUs should be present", "Actual element is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: SupportSite and ContactUs should be present", "Actual element is not present.", getDriver()); 
		 }
		
		String windowHandle = getDriver().getWindowHandle();
		click(TestDataManage.getObjectProperty("SupportSiteChat_Lnk"));
		switchToNewWindow();
		if(getCurrentUrl().contains("http://mysupport-tst.corp.netapp.com/cssportal")){
			getDetailedReport().WriteLog(Status.PASS, "Element present: URL should navigate to the required page", "Actual element is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: SupportSite and ContactUs should be present", "Actual element is not present.", getDriver()); 
		 }
		getDriver().close();
		getDriver().switchTo().window(windowHandle);
		waitForElement(TestDataManage.getObjectProperty("ContactUsChat_Lnk"));
		click(TestDataManage.getObjectProperty("ContactUsChat_Lnk"));
		waitForPageReady();
		switchToNewWindow();
		if(getCurrentUrl().contains("http://www.netapp.com/us/services-support/ngs-contacts.aspx")){
			getDetailedReport().WriteLog(Status.PASS, "Element present: URL should navigate to the required page", "Actual element is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: SupportSite and ContactUs should be present", "Actual element is not present.", getDriver()); 
		 }
		getDriver().close();
		getDriver().switchTo().window(windowHandle);

	}

	/********************************************************************************************************************
	* Method : VerifyExpiredSerialNumberErrorMessage
	* Description: To verify the error message for expired serial number and verify the navigation of the links in the message
	* Author: Tony George
	* Date: March-20-2017
	********************************************************************************************************************/
	public void verifyExpiredSerialNumberErrorMessage()
	{
		waitForElement(TestDataManage.getObjectProperty("GPSNotification_Txt"));
		verifyContainsText(TestDataManage.getObjectProperty("GPSNotification_Txt"), "Please submit a case on support site or contact us by phone.");
		verifyElementDisplayed("GPSNotificationContactUs_Link", "Chat Notification Contact Us Link");
		verifyElementDisplayed("GPSNotificationSupportSite_Link", "Chat Notification SupportSite Link");
		clickLinkAndVerifyNaviagatedURLInNewWindow("GPSNotificationContactUs_Link","ContactUsURL");
		clickLinkAndVerifyNaviagatedURLInNewWindow("GPSNotificationSupportSite_Link","SupportSiteURL");
		click("DismissNotification_Btn");
		verifyElementDisplayed("ChatSerNumber_TextBox", "Serial Number Textbox");
		
	}
	
	/********************************************************************************************************************
	* Method : verifyDeclinedSerialNumberErrorMessage
	* Description: To verify the error message for declined serial number 
	* Author: Tony George
	* Date: March-20-2017
	********************************************************************************************************************/
	public void verifyDeclinedSerialNumberErrorMessage()
	{
		waitForElement(TestDataManage.getObjectProperty("GPSNotification_Txt"));
		verifyContainsText(TestDataManage.getObjectProperty("GPSNotification_Txt"), "Our records show that you have declined support for this product. Please provide a valid serial number and try again.");
		click("DismissNotification_Btn");
		verifyElementDisplayed("ChatSerNumber_TextBox", "Serial Number Textbox");
		
	}
	/********************************************************************************************************************
	* Method : validateChatIconForGuestUser
	* Description: To verify chat icon to present for guest user
	* Author: Tony George
	* Date: March-21-2017
	********************************************************************************************************************/
	public void validateChatIconForGuestUser()
	{
		verifyContainsText(TestDataManage.getObjectProperty("ChatTime_Text"), "Certain partner accounts do not have chat enabled. Please see alternate ways to contact support");
		verifyElementDisplayed("ContractSupport_Link", "Contract Support Link");
		clickLinkAndVerifyNaviagatedURL("ContractSupport_Link","Url");
	}
	
	/********************************************************************************************************************
	* Method : verifyGLUEURLLaunchedSuccess
	* Description: To verify chat icon to present for guest user
	* Author: Tony George
	* Date: March-21-2017
	********************************************************************************************************************/
	public void verifyGLUEURLLaunchedSuccess()
	{
		waitForPageLoad();
		String Url = getDriver().getCurrentUrl();
		if(Url.contains("ECM")){
			getDetailedReport().WriteLog(Status.PASS, "Element present: URL should navigate to the required page", "Actual element is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: URL should navigate to the required page", "Actual element is not present.", getDriver()); 
		 }
	}
	
	/********************************************************************************************************************
	* Method : verifyChatAndCreateCaseLinkPresentInGPSPage
	* Description: To verify chat icon to present for guest user
	* Author: Tony George
	* Date: March-21-2017
	********************************************************************************************************************/
	public void verifyChatAndCreateCaseLinkPresentInGPSPage()
	{
		waitForPageLoad();
		sleepFor(5000);
		if(isElementPresent(TestDataManage.getObjectProperty("CreateACase_Lnk")) && isElementPresent(TestDataManage.getObjectProperty("GPSLoginForChat_Lnk"))){
			getDetailedReport().WriteLog(Status.PASS, "Element present: Create a Case Link and Chat Link should be available", "Actual element is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Element Not present: Create a Case Link and Chat Link should be available", "Actual element is not present.", getDriver()); 
		 }
	}
	
	/********************************************************************************************************************
	* Method : SearchAndVerifyThankYouNote
	* Description: To search the question and verify the thank you note
	* Author: Tony George
	* Date: Jan-19-2018
	********************************************************************************************************************/
	public void SearchAndVerifyThankYouNote()
	{
		waitForPageLoad();
		sleepFor(5000);
		switchFrameByLocator(By.xpath("//iframe[@class='sasrchIframe srchIframe']"));
		waitForElement(TestDataManage.getObjectProperty("Search_Txtbox"));
		type(TestDataManage.getObjectProperty("Search_Txtbox"), "sample");
		getDriver().findElement(TestDataManage.getObjectProperty("Search_Txtbox")).sendKeys(Keys.ENTER);
		sleepFor(8000);
		waitForElement(TestDataManage.getObjectProperty("FeedbackQuestion_Txt"));
		if(isElementPresent(TestDataManage.getObjectProperty("FeedbackQuestion_Txt")))
		{
			getDetailedReport().WriteLog(Status.PASS, "Text present: Did you find what you were looking for? ", "Actual Text is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Text present: Did you find what you were looking for? ", "Actual Text is not present.", getDriver()); 
		 }
		waitForElement(TestDataManage.getObjectProperty("FeedbackYes_Option"));
		if(TestDataManage.getData("FeedbackOption")=="Yes")
		{
		click(TestDataManage.getObjectProperty("FeedbackYes_Option"));
		}
		else
		{
			click(TestDataManage.getObjectProperty("FeedbackNo_Option"));
			waitForElement(TestDataManage.getObjectProperty("Expecting_Txtbox"));
			type(TestDataManage.getObjectProperty("Expecting_Txtbox"), "test");
			click(TestDataManage.getObjectProperty("CommentSubmit_Btn"));
			
		}
		waitForElement(TestDataManage.getObjectProperty("FeedStatus_Txt"));
		if(isElementPresent(TestDataManage.getObjectProperty("FeedStatus_Txt")))
		{
			getDetailedReport().WriteLog(Status.PASS, "Text present: Feedback sent", "Actual Text is present.", getDriver()); 
		 }
		 else
		 {
			 getDetailedReport().WriteLog(Status.FAIL, "Text present: Feedback sent", "Actual Text is not present.", getDriver()); 
		 }
		verifyElementDisplayed("LiveChat_Lnk", "Chat Icon");
	}
	
	/********************************************************************************************************************
	* Method : GPSPageVerification
	* Description: To verify the GPS page
	* Author: Tony George
	* Date: Jan-18-2018
	********************************************************************************************************************/
	public void GPSPageVerification()
	{
		waitForElement(TestDataManage.getObjectProperty("GpsSignIn_Lnk"));
		verifyElementDisplayed("GpsSignIn_Lnk", "GPS SignIn");
		verifyElementDisplayed("LiveChat_Lnk", "Chat Icon");
		switchFrameByLocator(By.xpath("//iframe[@class='sasrchIframe srchIframe']"));
		verifyElementDisplayed("Search_Txtbox", "GPS SearchBox");
		
	}

	/********************************************************************************************************************
	* Method : GPSPageVerification
	* Description: To verify the GPS page
	* Author: Tony George
	* Date: Jan-18-2018
	********************************************************************************************************************/
	public void verifyChatAfterSignInFromGPS()
	{
		clickChatButton();
		enterCredentials();
		submit();
		waitForElement(TestDataManage.getObjectProperty("LiveChat_Lnk"));
		verifyElementDisplayed("LiveChat_Lnk", "Chat Icon");
	
	}



}
