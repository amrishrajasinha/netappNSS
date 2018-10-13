package com.netapp.supportsite.base;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.ui.Select;

import com.ust.sarf.exception.SARFException;
import com.ust.sarf.reports.DetailedReport.Status;
import com.ust.sarf.testdata.TestDataManage;

public class UserRegistrationBase extends Base
{

	///public static String languageselected;
	HomeBase home=new HomeBase();

	/********************************************************************************************************************
	 * Method : navigateProfilePage
	 * Description: To navigate to profile page
	 * Author:Sreejith
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void navigateProfilePage()

	{
		pause(5000);
		home.clickMyProfile("ClickUserProfile_Link", "Profile");
		//		waitForElement(TestDataManage.getObjectProperty("ClickUserProfile_Link"));
		//		click("ClickUserProfile_Link");
		//		waitForElement(TestDataManage.getObjectProperty("ClickMyProfile_Link"));
		//		click("ClickMyProfile_Link");
		//		
	}
	/********************************************************************************************************************
	 * Method : navigvateCaseNotificationePage
	 * Description: To navigate to case notification page
	 * Author:Sreejith
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void navigvateCaseNotificationePage()

	{
		waitForElement(TestDataManage.getObjectProperty("CaseNotification_Link"));
		click("CaseNotification_Link");

	}

	/********************************************************************************************************************
	 * Method : verifySetCaseNotificationTrue
	 * Description: verify  Set case notification to true
	 * Author:Sreejith
	 * Date: Jan-8-2017
	 * @throws Exception 
	 ********************************************************************************************************************/
	public void verifySetCaseNotificationTrue()
	{
		navigateProfilePage();
		

		navigvateCaseNotificationePage();
		pause(5000);
		//switchFrameByLocator(By.name("afr::PushIframe"));
		
		if(!getDriver().findElement(TestDataManage.getObjectProperty("NotificationCheckbox_box")).isSelected()) 
		{
						
			getDriver().findElement(TestDataManage.getObjectProperty("NotificationCheckbox_box")).click();
			waitForElement(TestDataManage.getObjectProperty("SaveChanges_Button"));
			click("SaveChanges_Button");
		}
		else
		{
			System.out.println("Checkbox is already selected");
			getDriver().findElement(TestDataManage.getObjectProperty("NotificationCheckbox_box")).click();
			waitForElement(TestDataManage.getObjectProperty("SaveChanges_Button"));
			click("SaveChanges_Button");
			waitForElement(TestDataManage.getObjectProperty("ReturnPersonalProfile_Link"));
			click("ReturnPersonalProfile_Link");
			waitForElement(TestDataManage.getObjectProperty("CaseNotification_Link"));
			click("CaseNotification_Link");
			waitForElement(TestDataManage.getObjectProperty("NotificationCheckbox_box"));
			getDriver().findElement(TestDataManage.getObjectProperty("NotificationCheckbox_box")).click();
			waitForElement(TestDataManage.getObjectProperty("SaveChanges_Button"));
			click("SaveChanges_Button");
			pause(5000);
			waitForElement(TestDataManage.getObjectProperty("ConfirmationTextpresent"));
			verifyText(TestDataManage.getObjectProperty("ConfirmationTextpresent"), TestDataManage.getData("ConfirmationText"));
		}
	}

	/********************************************************************************************************************
	 * Method :verifyCheckboxcheckedAfterChange
	 * Description: To verify  set case notification after second log in
	 * Author: Sreejith
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void verifyCheckboxcheckedAfterChange()
	{
		navigateProfilePage();
		navigvateCaseNotificationePage();
		
		pause(3000);

		if(!getDriver().findElement(TestDataManage.getObjectProperty("NotificationCheckbox_box")).isSelected()) 
		{
			System.out.println("Checkbox is not  selected");
			getDetailedReport().WriteLog(Status.FAIL, "Expected : Checkbox should be checked. ", "Actual : Checkbox not selected" ,getDriver());

		}
		else
		{
			System.out.println("Checkbox is already selected");
			getDetailedReport().WriteLog(Status.PASS, "Expected : Checkbox should be checked ", "Actual : Checkbox selected" ,getDriver());
		}
	}
	
	/********************************************************************************************************************
	 * Method : verifySetCaseNotificationFalse
	 * Description: verify  Set case notification to  false
	 * Author:Sreejith
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void verifySetCaseNotificationFalse()
	{
		{
			navigateProfilePage();
			navigvateCaseNotificationePage();
            pause(5000);
			if(getDriver().findElement(TestDataManage.getObjectProperty("NotificationCheckbox_box")).isSelected()) 
			{
				getDriver().findElement(TestDataManage.getObjectProperty("NotificationCheckbox_box")).click();
				waitForElement(TestDataManage.getObjectProperty("SaveChanges_Button"));
				click("SaveChanges_Button");
			}
			else
			{
				System.out.println("Checkbox is not  selected");
				getDriver().findElement(TestDataManage.getObjectProperty("NotificationCheckbox_box")).click();
				waitForElement(TestDataManage.getObjectProperty("SaveChanges_Button"));
				click("SaveChanges_Button");
				waitForElementTime(TestDataManage.getObjectProperty("ReturnPersonalProfile_Link"), 300);
			//	waitForElement(TestDataManage.getObjectProperty("ReturnPersonalProfile_Link"));
				click("ReturnPersonalProfile_Link");
				waitForElement(TestDataManage.getObjectProperty("CaseNotification_Link"));
				click("CaseNotification_Link");
				waitForElement(TestDataManage.getObjectProperty("NotificationCheckbox_box"));
				getDriver().findElement(TestDataManage.getObjectProperty("NotificationCheckbox_box")).click();
				waitForElement(TestDataManage.getObjectProperty("SaveChanges_Button"));
				click("SaveChanges_Button");

			}

		}
	}

	/********************************************************************************************************************
	 * Method :verifyCheckboxcheckedAfterChange
	 * Description: To verify  set case notification FALSE  after second log in
	 * Author: Sreejith
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void verifyCheckboxUncheckedAfterChange()
	{
		navigateProfilePage();
		navigvateCaseNotificationePage();
        pause(5000);
		if(!getDriver().findElement(TestDataManage.getObjectProperty("NotificationCheckbox_box")).isSelected()) 
		{
			System.out.println("Checkbox is not   selected");
			getDetailedReport().WriteLog(Status.PASS, "Expected : Checkbox  in un checked. ", "Actual : Check box not  selected mode " ,getDriver());

		}
		else
		{
			System.out.println("Checkbox is already selected");
			getDetailedReport().WriteLog(Status.PASS, "Expected : Checkbox unchecked  ", "Actual : Check box selected mode " ,getDriver());


		}

	}


	/********************************************************************************************************************
	 * Method :updateMyprofile
	 * Description: To  update the existing profile
	 * Author: Sreejith
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void updateMyprofile()
	{
		navigateProfilePage();

		pause(4000);
		if(!getDriver().findElement(TestDataManage.getObjectProperty("EmailCheckbox_Box")).isSelected()) 
		{
			System.out.println(" Email Checkbox is not  selected");
			click("EmailCheckbox_Box");

		}
		else
		{
			System.out.println("Checkbox is already selected,selecting alternate phone");
			click("AlternatePhoneCheckBox_Box");
		}
			setTextField(TestDataManage.getObjectValue("PrimaryPhoneNo_Text"), "PrimaryPhone");
			chooseDropDown("language","language_Select");
			//languageselected=TestDataManage.getData("language");
			//System.out.println(languageselected);
			click("Save_Btn");
			waitForPageLoad();
			
			Boolean isSaveSuccess = false;
			
			try{
				Thread.sleep(1000);
				isSaveSuccess = !isElementPresent(TestDataManage.getObjectProperty("Save_Btn"));
			}catch(Exception e){
				
			}
			if(isSaveSuccess == true){
				getDetailedReport().WriteLog(Status.PASS, "Expected : Profile should be saved with required information. ", "Actual : Profile saved success with required information " ,getDriver());

			}
			else
			{
				getDetailedReport().WriteLog(Status.FAIL, "Expected : Profile should be saved with required information. ", "Actual : Profile not saved success with required information " ,getDriver());
				throw new SARFException("Profile not saved success with required information");
			}

		

	}
	/********************************************************************************************************************
	 * Method :updateMyprofileAfterLogin
	 * Description: To verify  set case notification FALSE  after second log in
	 * Author: Sreejith
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void updateMyprofileAfterLogin()
	{
		navigateProfilePage();
		By elementLocator=TestDataManage.getObjectProperty("language_Select");

		// String Actualtext=getDriver().findElement(TestDataManage.getObjectProperty("language_Select")).getText();
		Select s = new Select(getDriver().findElement(elementLocator));
		String selectedComboValue = s.getFirstSelectedOption().getText();
		System.out.println(selectedComboValue);
		String languageselected=TestDataManage.getData("language");
		if (selectedComboValue.equalsIgnoreCase(languageselected))

		{
			System.out.println("verified the  correct language selection value");
			getDetailedReport().WriteLog(Status.PASS, "Expected " +languageselected, "Actual " +selectedComboValue ,getDriver());

		}
		else
		{
			System.out.println("failed to verify the updated language selection");
			getDetailedReport().WriteLog(Status.FAIL, "Expected " +languageselected, "Actual " +selectedComboValue ,getDriver());

		}

	}

	/********************************************************************************************************************
	 * Method :verifyCheckboxcheckedAfterChange
	 * Description: To validate the change password field by giving invalid inputs
	 * Author: Sreejith
	 * Date: Jan-8-2017
	 ********************************************************************************************************************/
	public void validateChangePasswordfield()
	{
		pause(5000);
		navigateProfilePage();
		waitForElement(TestDataManage.getObjectProperty("ChangePassword_link"));
		getDriver().findElement(TestDataManage.getObjectProperty("ChangePassword_link")).click();
		//Validate error message with out entering any value and save

		waitForElement(TestDataManage.getObjectProperty("Save_Btn"));
		click("Save_Btn");

		pause(3000);
		boolean isVisible=getDriver().findElement(TestDataManage.getObjectProperty("ErrorMessage_Txt")).isDisplayed();
		String ExpectedErrorvalue="Your current password is not correct. Please enter a valid curent password and try again. ";
		String ActualErrorvalue=getDriver().findElement(TestDataManage.getObjectProperty("ErrorMessage_Txt")).getText();
		if(isVisible)
		{

			getDetailedReport().WriteLog(Status.PASS, "Expected message "+ExpectedErrorvalue , "Actual message " +ActualErrorvalue ,getDriver());

		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Expected message "+ExpectedErrorvalue , "Actual message " +ActualErrorvalue ,getDriver());

		}
		//Validate error message by entering wrong values in text fields

		waitForElement(TestDataManage.getObjectProperty("Oldpassword_link"));
		type(TestDataManage.getObjectProperty("Oldpassword_link"), TestDataManage.getData("oldpassword"));
		waitForElement(TestDataManage.getObjectProperty("Newpassword_link"));
		type(TestDataManage.getObjectProperty("Newpassword_link"), TestDataManage.getData("Newpassword"));
		waitForElement(TestDataManage.getObjectProperty("ConfirmNewpassword_link"));
		type(TestDataManage.getObjectProperty("ConfirmNewpassword_link"), TestDataManage.getData("ConfirmNewpassword"));
		pause (3000);
		waitForElement(TestDataManage.getObjectProperty("Save_Btn"));
		click("Save_Btn");

		if(isVisible)
		{
			getDetailedReport().WriteLog(Status.PASS, "Expected message "+ExpectedErrorvalue , "Actual message " +ActualErrorvalue ,getDriver());

		}
		else
		{
			getDetailedReport().WriteLog(Status.FAIL, "Expected message "+ExpectedErrorvalue , "Actual message " +ActualErrorvalue ,getDriver());

		}
	}


	/********************************************************************************************************************
	 * Method :supportSiteuserRemovalAccess
	 * Description: To remove the selected support site users
	 * Author: Sreejith
	 * Date: Feb-14-2017
	 ********************************************************************************************************************/
	public void supportSiteuserRemovalAccess()
	{
		pause(5000);
		navigateProfilePage();
		waitForElement(TestDataManage.getObjectProperty("EditSupportsiteUsers_Link"));
		click("EditSupportsiteUsers_Link");
		waitForPageLoad();
		if(isDisplayedWait(TestDataManage.getObjectProperty("SelectSupportSiteUsers_Select")))
		{	
			chooseDropDown("SelectSupportSiteUsers", "SelectSupportSiteUsers_Select");
			waitForElement(TestDataManage.getObjectProperty("Go_Btn"));
			click("Go_Btn");
		}
		waitForPageLoad();
		if(isDisplayedWait(TestDataManage.getObjectProperty("Removeuser_CheckBox")))
		{
		
		click("Removeuser_CheckBox");
		
		waitForElement(TestDataManage.getObjectProperty("RemoveAccess_Btn"));
		click("RemoveAccess_Btn");
		waitForPageLoad();
		verifyText(TestDataManage.getObjectProperty("Feedback_Text"), TestDataManage.getData("Feedback"));	
	}

	}
	/********************************************************************************************************************
	 * Method :EditRemoveNowUsersValid
	 * Description: To remove the selected support site valid users
	 * Author: Sreejith
	 * Date: Feb-14-2017
	 ********************************************************************************************************************/
	public void EditRemoveNowUsersValid()
	{
		pause(5000);
		navigateProfilePage();
		waitForElement(TestDataManage.getObjectProperty("EditSupportsiteUsers_Link"));
		click("EditSupportsiteUsers_Link");
		waitForPageLoad();
		if(isDisplayedWait(TestDataManage.getObjectProperty("SelectFirstName_Select")))
		{	
			chooseDropDown("SelectFirstName", "SelectFirstName_Select");

			//type(TestDataManage.getObjectProperty("Entervalue_Text"), TestDataManage.getData("Value"));
			setTextBox( "Value","Entervalue_Text");
			//            waitForElement(TestDataManage.getObjectProperty("Go_Btn"));
			//			click("Go_Btn");

			//String SearchpageTextVerify=getDriver().findElement(TestDataManage.getObjectProperty("SearchSupportSite_Text")).getText();

	
			String Email1verification_text=getDriver().findElement(TestDataManage.getObjectProperty("Email1verification_text")).getText();
			String Email2verification_text=getDriver().findElement(TestDataManage.getObjectProperty("Email2verification_text")).getText();
			waitForElement(TestDataManage.getObjectProperty("Removeuser_CheckBox"));
			click("Removeuser_CheckBox");
			waitForElement(TestDataManage.getObjectProperty("Removeuser_CheckBox1"));
			click("Removeuser_CheckBox1");
			waitForElement(TestDataManage.getObjectProperty("RemoveAccess_Btn"));
			click("RemoveAccess_Btn");
			waitForPageLoad();


			/*if (getDriver().getPageSource().contains(SearchpageTextVerify))
			{
				getDetailedReport().WriteLog(Status.FAIL,
						"Expected  Details: verifying resultspage is available" + Email1verification_text
						+ ". Actual results id",
						"Results page is not available", getDriver());
			}
			else*/
              //verfying search page with removed email id is available or not
				if (getDriver().getPageSource().contains(Email1verification_text))
				{
					getDetailedReport().WriteLog(Status.FAIL,
							"Expected  Details: verifying first row Email id should not preset: " + Email1verification_text
							+ ". Actual Set value",
							"Email id is present", getDriver());

				}
				else 
					if (getDriver().getPageSource().contains(Email2verification_text))
					{
						getDetailedReport().WriteLog(Status.FAIL,
								"Expected  Details: verifying first row Email id should not preset: " + Email2verification_text
								+ ". Actual Set value",
								"Email id is present", getDriver()); 
					}

			   	    getDetailedReport().WriteLog(Status.PASS,
									"Expected  Details: verifying first row Email id should not preset: " + Email1verification_text
											+ ". Actual Set value",
									"Email id is  not present", getDriver());  
			   	    
		}


	}
	/********************************************************************************************************************
	 * Method :EditRemoveNowUsersInValid
	 * Description: To validate the search results by providing invalid data
	 * Author: Sreejith
	 * Date: Feb-14-2017
	 ********************************************************************************************************************/
	public void EditRemoveNowUsersInValid()
	{
		pause(5000);
		navigateProfilePage();
		waitForElement(TestDataManage.getObjectProperty("EditSupportsiteUsers_Link"));
		click("EditSupportsiteUsers_Link");
		waitForPageLoad();
		//Verify warning mesage with out selecting any fields
		waitForElement(TestDataManage.getObjectProperty("Go_Btn"));
		click("Go_Btn");
		verifyText(TestDataManage.getObjectProperty("NoResultvalidationMessaage_TXT"), TestDataManage.getData("NoResultvalidationMessage_go"));	


		if(isDisplayedWait(TestDataManage.getObjectProperty("SelectFirstName_Select")))
		{	
			chooseDropDown("SelectFirstName", "SelectFirstName_Select");
			type(TestDataManage.getObjectProperty("Entervalue_Text"), TestDataManage.getData("Invalid_Value"));

			waitForElement(TestDataManage.getObjectProperty("Go_Btn"));
			click("Go_Btn");
		
		//waitForPageLoad();
		verifyText(TestDataManage.getObjectProperty("NoResultvalidationMessaage_TXT"), TestDataManage.getData("NoResultvalidationMessage_firstname"));	


		}
	}

	/********************************************************************************************************************
	 * Method :updateGuestPErsonalProfile
	 * Description: To update the guest personal profile data
	 * Author: Sreejith
	 * Date: Feb-14-2017
	 ********************************************************************************************************************/
	public void updateGuestPersonalProfile()
	{
		pause(5000);
		navigateProfilePage();
		waitForPageLoad();
		getElement(TestDataManage.getObjectProperty("Department_Txt")).clear();
		getElement(TestDataManage.getObjectProperty("Department_Txt")).clear();
		type(TestDataManage.getObjectProperty("Department_Txt"), TestDataManage.getData("Department"));
		type(TestDataManage.getObjectProperty("JobTitle_Txt"), TestDataManage.getData("JobTitle"));
		click("Save_Btn");



	}
	/********************************************************************************************************************
	 * Method :ValidateUpdateGuestProfileAfterLogin
	 * Description: To u validate the updated profile data after second log in
	 * Author: Sreejith
	 * Date: Feb-14-2017
	 ********************************************************************************************************************/
	public boolean  ValidateUpdateGuestProfileAfterLogin()
	{
		try
		{		
			pause(5000);
			navigateProfilePage();
			waitForPageLoad();
			verifyValue(TestDataManage.getObjectProperty("Department_Txt"), TestDataManage.getData("Department"));	
			//verifyText(TestDataManage.getObjectProperty("Department_Txt"), TestDataManage.getData("JobTitle"));	
			
		}
		catch (Exception e)
		{
			return false;
		}
		return false;
	}

}




