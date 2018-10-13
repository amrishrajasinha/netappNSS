package com.netapp.supportsite.businesscomponents;
/**
 * Class : RequestAPartDetails
 * @author : UST Global
 */

import com.netapp.supportsite.base.RequestAPartDetailsBase;

public class RequestAPartDetails extends RequestAPartDetailsBase {
	
	/********************************************************************************************************************
	* Method : createRequestForPartByEnteringOrder()
	* Description: To add the order and Submit it 
	* Author:Tony
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void createRequestForPartByEnteringOrder(){
		addOrder();
		submitOrder();
	}
	
	
	/********************************************************************************************************************
	* Method : addingOrder
	* Description: To add the order 
	* Author:Tony
	* Date: Mar-13-2017
	********************************************************************************************************************/
	public void addingOrder(){
		addOrder();
	}
	
	/********************************************************************************************************************
	* Method : rootCaseAnalysischeck
	* Description: To add the order , check whether RCA checkbox is not displayed , click on What's This link
	* Author:Salba
	* Date: Mar-28-2017
	********************************************************************************************************************/
	
	public void rootCaseAnalysischeck(){
		addOrder();
		isRootCaseAnalysisCheckboxNotDisplayed();
		clickWhatIsThisLink();
	}
	

	/********************************************************************************************************************
	* Method : AddOrder_CustomerUser
	* Description: To add a order for customer user
	* Author: Sreejith
	* Date: Mar-23-2017 
	********************************************************************************************************************/
	public void addOrder_CustomerUser()
	{
		addOrder_Customer();
	}
	

	/********************************************************************************************************************
	* Method : AddOrder_CustomerUser
	* Description: To add a order for Logistic user
	* Author: Sreejith
	* Date: Mar-23-2017 
	********************************************************************************************************************/
	public void addOrder_LogicticUser()	{
		addOrder_Customer();;
	}

}
