package com.netapp.supportsite.base;

/**
 * Class : CheckPartStatusBase
 * @author : UST Global
 */

public class CheckPartStatusBase extends Base {
	
	/********************************************************************************************************************
	* Method : setSearchAndGo
	* Description: Setting the search criteria, Enter value and click Go
	* Author: Salba
	* Date: Feb-14-2017
	********************************************************************************************************************/
	public void setSearchAndGo(){
		waitForPageReady();
		chooseDropDown("Select", "Search_Select");
		setTextBox("Value", "EnterValue_Text");
		click("Go_Search_Button");
		waitForPageReady();		
	}
	
	/********************************************************************************************************************
	* Method : setSearchShowMeAll
	* Description: Setting the Show Me All criteria and click Go
	* Author: Salba
	* Date: Feb-14-2017
	********************************************************************************************************************/
	public void setSearchShowMeAll(){
		waitForPageReady();
		chooseDropDown("ShowMeAll","ShowMeAll_Select");
		chooseDropDown("Status","Status_Select");
		chooseDropDown("State/Province","State/Province_Select");
		chooseDropDown("Country","Country_Select");
		click("Go_ShowMeAll");
		waitForPageReady();	
	
		
	}

}
