package com.netapp.supportsite.businesscomponents;
/**
 * Class : UserRegistration
 * @author : UST Global
 */
import com.netapp.supportsite.base.UserRegistrationBase;

public class UserRegistration extends UserRegistrationBase
{
	/********************************************************************************************************************
	* Method : Validate the functionality of check box in case notification
	* Description: To request a part
	* Author: Sreejith
	* Date: February-08-2017
	********************************************************************************************************************/
	
	public void caseNotificationCheckBoxTrue()
	{
		waitForPageReady();
		verifySetCaseNotificationTrue();
	}	
	
	/********************************************************************************************************************
	* Method : validateCaseNotificationCheckBoxafterLogin
	* Description:Validate the functionality of check box in case notification
	* Author: Sreejith
	* Date: February-08-2017
	********************************************************************************************************************/

	public void validateCaseNotificationCheckBoxafterLogin()
	{
		waitForPageReady();
		verifyCheckboxcheckedAfterChange();
		
	}
	/********************************************************************************************************************
	* Method : caseNotificationCheckBoxFalse
	* Description: To  validate  the case notification check box field 
	* Author: Sreejith
	* Date: February-08-2017
	********************************************************************************************************************/
	

	public void caseNotificationCheckBoxFalse()
	{
		waitForPageReady();
		verifySetCaseNotificationFalse();
	}	
	
	/********************************************************************************************************************
	* Method : validateCaseNotificationUnCheckBoxafterLogin
	* Description: To validate the check box condition after log in
	* Author: Sreejith
	* Date: February-08-2017
	********************************************************************************************************************/

	public void validateCaseNotificationUnCheckBoxafterLogin()
	{
		waitForPageReady();
		verifyCheckboxUncheckedAfterChange();
		
	}
	
	/********************************************************************************************************************
	* Method : UpdateProfile
	* Description: Validate the functionality of  update profile field
	* Author: Sreejith
	* Date: February-08-2017
	********************************************************************************************************************/

	public void UpdateProfile()
	{
		waitForPageReady();
		updateMyprofile();
		
	}
	/********************************************************************************************************************
	* Method : ValidateUpdateProfileAfterLogin
	* Description: verify the updated  field are updated correctly after login 
	* Author: Sreejith
	* Date: February-08-2017
	********************************************************************************************************************/

	public void validateUpdateProfileAfterLogin()
	{
		waitForPageReady();
		updateMyprofileAfterLogin();
		
	}
	/********************************************************************************************************************
	* Method : ValidateUpdateProfileAfterLogin
	* Description: verify the functioanlity password reset fields
	* Author: Sreejith
	* Date: February-08-2017
	********************************************************************************************************************/

	public void validateChangePassword()
	{
		waitForPageReady();
		validateChangePasswordfield();
		
	}
	
	/********************************************************************************************************************
	* Method : validateSupportSiteuserRemoval
	* Description: To valiadate  the the successful user removal 
	* Author: Sreejith
	* Date: February-14-2017
	********************************************************************************************************************/

	public void validateSupportSiteuserRemoval()
	{
		waitForPageReady();
		supportSiteuserRemovalAccess();
		
	}
	/********************************************************************************************************************
	* Method : multipleNowusersRemovalValidData
	* Description: To Remove multiple now users from the list
	* Author: Sreejith
	* Date: February-14-2017
	********************************************************************************************************************/

	public void multipleNowusersRemovalValidData()
	{
		waitForPageReady();
		EditRemoveNowUsersValid();
		
	}
	
	/********************************************************************************************************************
	* Method : multipleNowusersRemovalInValidData
	* Description: To validate the now user filed by giving invalid data
	* Author: Sreejith
	* Date: February-14-2017
	********************************************************************************************************************/
	public void multipleNowusersRemovalInValidData()
	{
		waitForPageReady();
		EditRemoveNowUsersInValid();
		
	}
	
	/********************************************************************************************************************
	* Method : validateSupportSiteuserRemoval
	* Description: To validate the now user filed by giving invalid data
	* Author: Sreejith
	* Date: February-14-2017
	********************************************************************************************************************/
	public void updateGuestProfile()
	{
		waitForPageReady();
		updateGuestPersonalProfile();
		
	}
	
	

	/********************************************************************************************************************
	* Method : validateGuestProfileAfterLogin
	* Description: To validate the guest user field
	* Author: Sreejith
	* Date: February-14-2017
	********************************************************************************************************************/
	public void  validateGuestProfileAfterLogin()
	{
		waitForPageReady();
		 ValidateUpdateGuestProfileAfterLogin();
		 		
	}
	
	
	
}