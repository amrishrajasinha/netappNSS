package com.netapp.supportsite.businesscomponents;

import com.netapp.supportsite.base.CheckPartStatusBase;

/**
 * Class : CheckPartStatus
 * @author : UST Global
 */
public class CheckPartStatus extends CheckPartStatusBase {
	
	/********************************************************************************************************************
	* Method : searchByCriteria
	* Description: Setting the search criteria, Enter value and click Go
	* Author: Salba
	* Date: Feb-14-2017
	********************************************************************************************************************/
	
	public void searchByCriteria(){
		setSearchAndGo();
		
	}
	
	/********************************************************************************************************************
	* Method : searchByShowMeAll
	* Description: Search using the Show Me all option
	* Author: Salba
	* Date: Feb-14-2017
	********************************************************************************************************************/
	public void searchByShowMeAll(){
		setSearchShowMeAll();
		
	}

}
