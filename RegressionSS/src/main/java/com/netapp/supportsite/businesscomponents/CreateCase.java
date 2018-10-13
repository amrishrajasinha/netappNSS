package com.netapp.supportsite.businesscomponents;
/**
 * Class : CreateCase
 * @author : UST Global
 */

import com.netapp.supportsite.base.CreateCaseBase;

public class CreateCase extends CreateCaseBase
{
	/********************************************************************************************************************
	 * Method : createCase
	 * Description: To fill in all the details for case creation
	 * Author: Tony George
	 * Date: February-10-2017
	 ********************************************************************************************************************/
	public void createCase()
	{
		fillCaseAndContactPage();

	}
	
	/********************************************************************************************************************
	 * Method : validateChatIconAndCreateCase
	 * Description: To fill in all the details for case creation
	 * Author: Salba
	 * Date: February-17-2017
	 ********************************************************************************************************************/
	public void validateChatIconAndCreateCase()
	{
		verifyChatIconPresent();
		fillCaseAndContactPage();

	}

	/********************************************************************************************************************
	 * Method : createCaseAndVerifyChatIconNotPresent
	 * Description: To verify if Chat icon is present
	 * Author: Alfred dcruz
	 * Date: February-14-2017
	 ********************************************************************************************************************/
	public void createCaseAndVerifyChatIconNotPresent()
	{
		validateChatIconNotPresent();
		createCase();
	
	}

	/********************************************************************************************************************
	 * Method : verifyChatIconPresent
	 * Description: To verify if chat icon is present
	 * Author: Salba
	 * Date: February-16-2017
	 ********************************************************************************************************************/
	public void verifyChatIconPresent()
	{
		validateChatIconPresent();

	}
	
	/********************************************************************************************************************
	 * Method : verifyLiveChatTiming
	 * Description: To verify if chat timing
	 * Author: Tony George
	 * Date: March-14-2017
	 ********************************************************************************************************************/
	public void verifyLiveChatTiming()
	{
		
		validateLiveChatTiming();
	}
	
	
	
	
	/********************************************************************************************************************
	 * Method : verifyChatIconNotPresent
	 * Description: To verify if chat icon is not present
	 * Author: Salba
	 * Date: February-21-2017
	 ********************************************************************************************************************/
	public void verifyChatIconNotPresent()
	{
		validateChatIconNotPresent();

	}
	/********************************************************************************************************************
	 * Method : verifyChatIconPresentForCreateCase
	 * Description: Validate the Chat icon present
	 * Author: Rajmohan Dhanapal
	 * Date: February-10-2017
	 ********************************************************************************************************************/
	public void verifyChatProvideInformation()
	{
		waitForPageReady();
		validateChatIconPresent();
		clickChatIcon();
		clickChatContinue();
		validateProvideInformationChat();	
	}
	
	/********************************************************************************************************************
	 * Method : verifyProductAreaMandatoryWarning
	 * Description: Validate warning message when Product Area is not selected
	 * Author: Rajmohan Dhanapal
	 * Date: February-10-2017
	 ********************************************************************************************************************/
	public void verifyProductAreaMandatoryWarning()
	{
		waitForPageReady();
		validateChatIconPresent();
		clickChatIcon();
		clickChatContinue();
		clickChatButton();
		validateChatWarningForProductArea();	
	}
	
	/********************************************************************************************************************
	 * Method : verifyProductAreaSorted
	 * Description: Validate Product Area is sorted
	 * Author: Rajmohan Dhanapal
	 * Date: February-17-2017
	 ********************************************************************************************************************/
	public void verifyProductAreaSorted()
	{
		waitForPageReady();
		validateChatIconPresent();
		clickChatIcon();
		clickChatContinue();
		validateProductAreaDropDownSort();
	}
	
	/********************************************************************************************************************
	 * Method : verifyProductAreaDefaulValue
	 * Description: Validate Product Area default value
	 * Author: Rajmohan Dhanapal
	 * Date: February-17-2017
	 ********************************************************************************************************************/
	public void verifyProductAreaDefaulValue()
	{
		waitForPageReady();
		validateChatIconPresent();
		clickChatIcon();
		clickChatContinue();
		validateProductAreaDefaultDropDown();
	}
	
	public void cancelChat(){
		waitForPageReady();
		validateChatIconPresent();
		clickChatIcon();
		clickChatContinue();
		clickCancelChat();
	}

	
	/********************************************************************************************************************
	 * Method : selectPriorityAndVerfyChatIcon
	 * Description: Validate select Priority And Verify Chat Icon
	 * Author: Harish
	 * Date: February-22-2017
	 ********************************************************************************************************************/
	public void selectPriorityAndVerfyChatIcon()
	{
		waitForPageReady();
		createCasePriority();
		validateChatIconPresent();
		
	}
	/********************************************************************************************************************
	 * Method : validateChatIntakeForm
	 * Description: Validate validate Chat Intake Form
	 * Author: Harish
	 * Date: February-22-2017
	 ********************************************************************************************************************/
	public void validateChatIntakeForm()
	{
		waitForPageReady();
		validateChatIconPresent();
		clickChatIcon();
		clickChatContinue();
		validateChatIntakeText();
		
	}
	/********************************************************************************************************************
	 * Method : verifyPriorityP1MessageOnCreateCasePage
	 * Description: Validate validate Chat Intake Form
	 * Author: Alfred
	 * Date: February-22-2017
	 ********************************************************************************************************************/
	public void verifyPriorityP1MessageOnCreateCasePage()
	{
		createCasePriority();
		verifyPriorityP1Message();
		
	}
	
	/********************************************************************************************************************
	 * Method : createCaseChatPresent
	 * Description: Validate chat icon present or not
	 * Author: Sreejith
	 * Date: February-20-2017
	 ********************************************************************************************************************/
	public void createCaseChatPresent()
	{
		waitForPageReady();
		validateChatIconNotPresent();
		
	}
	
	
	/********************************************************************************************************************
	 * Method : createCaseSetPriority
	 * Description: to create a case with selected priority
	 * Author: Sreejith
	 * Date: February-20-2017
	 ********************************************************************************************************************/
	public void createCaseSetPriority()
	{
		waitForPageReady();
		createCaseSetPriorityLevel();
	}
	
	
	/********************************************************************************************************************
	 * Method : createCaseChatPresentsSelectedPriority1
	 * Description: to verify chat preset with priority level 1
	 * Author: Sreejith
	 * Date: February-20-2017
	 ********************************************************************************************************************/
	public void createCaseChatPresentsSelectedPriority1()
	{
		waitForPageReady();
		verifyChatSetPriorityLevel1();
		validateChatIconNotPresent();
	}

	/********************************************************************************************************************
	 * Method : createCaseChatPresentsSelectedPriority3
	 * Description: to verify chat preset with priority level 3
	 * Author: Sreejith
	 * Date: February-20-2017
	 ********************************************************************************************************************/
	public void createCaseChatPresentsSelectedPriority3()
	{
		waitForPageReady();
		validateChatIconNotPresent();
	}
	

	/********************************************************************************************************************
	 * Method : updateCase
	 * Description: To update a case
	 * Author: sreejith
	 * Date: February-10-2017
	 ********************************************************************************************************************/
	public void updateCase()
	{
		openCase();
		fillCaseAndContactPage();

	}
	
	/********************************************************************************************************************
	 * Method : verifyChatPresentCreatecase
	 * Description: to verify chat preset while creating a case
	 * Author: Sreejith
	 * Date: February-20-2017
	 ********************************************************************************************************************/
	public void verifyChatPresentCreatecase()
	{
		waitForPageReady();
		validateChatIconNotPresent();
		fillCaseAndContactPage();
		
	}
	
	/********************************************************************************************************************
	 * Method : createCaseAnyway
	 * Description: to create a new case any way
	 * Author: Sreejith
	 * Date: February-22-2017
	 ********************************************************************************************************************/
	public void createCaseAnyway()
	{
		waitForPageReady();
		openCase();
		fillCaseAndContactPage();
		
	}

	/********************************************************************************************************************
	 * Method : createCaseAnyway
	 * Description: to close a case
	 * Author: Sreejith
	 * Date: Mar-28-2017
	 ********************************************************************************************************************/
	public void CloseaCase()
	{
		closeCaseSetPriorityLevel();
		
		
	}
	

	/********************************************************************************************************************
	 * Method : reOpenACloseCase
	 * Description: to reopen a closed case
	 * Author: Sreejith
	 * Date: Mar-29-2017
	 ********************************************************************************************************************/
	public void reOpenACloseCase()
	{
		closeCaseSetPriorityLevel();
		
		
	}
	
}

